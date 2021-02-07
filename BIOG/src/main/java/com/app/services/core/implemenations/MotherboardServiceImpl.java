package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Motherboard;
import com.app.entities.core.Product;
import com.app.repositories.core.IMotherBoardRepository;
import com.app.services.core.interfaces.IMotherboardService;

@Service
@Transactional
public class MotherboardServiceImpl implements IMotherboardService {

	@Autowired
	private IMotherBoardRepository motherBoardRepo;

	@Override
	public List<Product> getAllMotherboard() {
		List<Product> list = new ArrayList<Product>();
		motherBoardRepo.findAll().forEach(p -> list.add(p));
		return list;
		
	}

	@Override
	public Product getMotherboardById(int id) {


		Optional<Motherboard> opt = motherBoardRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if motherboard is not found : throw custom exception
		throw new ProductNotFoundException("No Motherboard Not Found : Invalid ID " + id);
	}

	@Override
	public Product deleteMotherboardById(int id) {

		// chk if cpu exists : yes : delete , otherwise throw exc.
				Optional<Motherboard> optional = motherBoardRepo.findById(id);
				if (optional.isPresent()) {
					motherBoardRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Motherboard Not Found : Invalid motherboard id " + id);
	}

	@Override
	public Product updateMotherboardById(Motherboard obj) {

		Optional<Motherboard> optional = motherBoardRepo.findById(obj.getId());
		if (optional.isPresent())
			return motherBoardRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Motherboard Not Found : Invalid motherboard  id " + obj.getId());

	}

	@Override
	public Product createMotherboard(Motherboard obj) {

		return motherBoardRepo.save(obj);
		
	}

}
