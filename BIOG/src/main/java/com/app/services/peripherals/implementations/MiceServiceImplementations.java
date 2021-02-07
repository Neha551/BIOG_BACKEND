package com.app.services.peripherals.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.peripherals.MicePeripheral;
import com.app.repositories.peripherals.IMicePeripheralRepository;
import com.app.services.peripherals.interfaces.IMicePeripheralService;

@Service
@Transactional
public class MiceServiceImplementations implements IMicePeripheralService {

	@Autowired
	private IMicePeripheralRepository miceRepo;
	
	@Override
	public List<Product> getAllMice() {
		List<Product> list = new ArrayList<Product>();
		miceRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getMiceById(int id) {
		Optional<MicePeripheral> opt = miceRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if MicePeripheralis not found : throw custom exception
		throw new ProductNotFoundException("MicePeripheral Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateMiceById(MicePeripheral obj) {

		Optional<MicePeripheral> optional = miceRepo.findById(obj.getId());
		if (optional.isPresent())
			return miceRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("MicePeripheral Not Found : Invalid MicePeripheral id " + obj.getId());
	}

	@Override
	public Product deleteMiceById(int id) {
		// chk if MicePeripheral exists : yes : delete , otherwise throw exc.
			Optional<MicePeripheral> optional = miceRepo.findById(id);
			if (optional.isPresent()) {
				miceRepo.deleteById(id);

				return optional.get();
			} else
				// if product is not found : throw custom exception
				throw new ProductNotFoundException("MicePeripheral Not Found : Invalid MicePeripheral id " + id);
	}

	@Override
	public Product createMice(MicePeripheral obj) {
		return miceRepo.save(obj);

	}

}
