package com.app.services.core.implemenations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.OperatingSystem;
import com.app.entities.core.Product;
import com.app.repositories.core.IOperatingSystemRepository;
import com.app.services.core.interfaces.IOperatingSystemService;

@Service
@Transactional
public class OperatingSystemServiceImpl implements IOperatingSystemService{

	@Autowired
	private IOperatingSystemRepository operatingSystemRepo;
	
	@Override
	public List<Product> getAllOperatingSystem() {
		List<Product> list = new ArrayList<Product>();
		operatingSystemRepo.findAll().forEach(p -> list.add(p));
		return list;

	}

	@Override
	public Product getOperatingSystemById(int id) {

		Optional<OperatingSystem> opt = operatingSystemRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if Operating System is not found : throw custom exception
		throw new ProductNotFoundException("Operating System Not Found : Invalid ID " + id);
	}

	@Override
	public Product deleteOperatingSystemById(int id) {

		// chk if Operating System exists : yes : delete , otherwise throw exc.
		Optional<OperatingSystem> optional = operatingSystemRepo.findById(id);
		if (optional.isPresent()) {
			operatingSystemRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("Operating System Not Found : Invalid Operating System id " + id);
	}

	@Override
	public 	Product updateOperatingSystemById(OperatingSystem obj) {

		Optional<OperatingSystem> optional = operatingSystemRepo.findById(obj.getId());
		if (optional.isPresent())
			return operatingSystemRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Operating System Not Found : Invalid Operating System id " + obj.getId());

	}

	@Override
	public Product createOperatingSystem(OperatingSystem obj) {

		return operatingSystemRepo.save(obj);

	}
}
