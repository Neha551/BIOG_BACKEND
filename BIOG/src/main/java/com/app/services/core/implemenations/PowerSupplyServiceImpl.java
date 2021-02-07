package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.PowerSupply;
import com.app.entities.core.Product;
import com.app.repositories.core.IPowerSupplyRepo;
import com.app.services.core.interfaces.IPowerSupplyService;


@Service
@Transactional
public class PowerSupplyServiceImpl implements IPowerSupplyService {

	@Autowired
	private IPowerSupplyRepo powerSupplyRepo;
	
	@Override
	public List<Product> getAllPowerSupply() {
		List<Product> list = new ArrayList<Product>();
		powerSupplyRepo.findAll().forEach(p -> list.add(p));
		return list;
		
	}

	@Override
	public Product getPowerSupplyById(int id) {
		Optional<PowerSupply> opt = powerSupplyRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if power supply is not found : throw custom exception
		throw new ProductNotFoundException("Power Supply Not Found : Invalid ID " + id);

		
	}

	@Override
	public Product deletePowerSupplyById(int id) {
		
		// chk if power supply exists : yes : delete , otherwise throw exc.
				Optional<PowerSupply> optional =powerSupplyRepo.findById(id);
				if (optional.isPresent()) {
					powerSupplyRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Power Supply Not Found : Invalid power supply id " + id);
			
	}

	@Override
	public Product updatePowerSupplyById(PowerSupply obj) {
		
		Optional<PowerSupply> optional = powerSupplyRepo.findById(obj.getId());
		if (optional.isPresent())
			return powerSupplyRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Power Supply  Not Found : Invalid power supply id " + obj.getId());

	}

	@Override
	public Product createPowerSupply(PowerSupply obj) {
		
		return powerSupplyRepo.save(obj);
	}

}
