package com.app.services.accessories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.accessories.UPSAccessory;

import com.app.entities.core.Product;
import com.app.repositories.accessories.IUPSAccessoryRepository;
import com.app.services.accessories.interfaces.IUPSAccessoryService;
@Service
@Transactional
public class UPSAccessoryServiceImpl implements IUPSAccessoryService {
@Autowired
private IUPSAccessoryRepository uPSAccessoryRepo;
	

@Override
	public List<Product> getAllUPSAccessory() {
	List<Product> list = new ArrayList<Product>();
	uPSAccessoryRepo.findAll().forEach(p -> list.add(p));
	return list;

	}

	@Override
	public Product getUPSAccessoryById(int id) {
		Optional<UPSAccessory> opt = uPSAccessoryRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if UPSAccessory is not found : throw custom exception
		throw new ProductNotFoundException("No UPSAccessory Not Found : Invalid ID " + id);
	}
	
	@Override
	public Product updateUPSAccessoryById(UPSAccessory obj) {
		Optional<UPSAccessory> optional = uPSAccessoryRepo.findById(obj.getId());
		if (optional.isPresent())
			return uPSAccessoryRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("UPSAccessory Not Found : Invalid UPSAccessoryid " + obj.getId());

	}

	@Override
	public Product deleteUPSAccessoryById(int id) {
		Optional<UPSAccessory> optional = uPSAccessoryRepo.findById(id);
		if (optional.isPresent()) {
			uPSAccessoryRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException(" Not UPSAccessory Found : Invalid UPSAccessory id " + id);
	}

	@Override
	public Product createUPSAccessory(UPSAccessory obj) {
		return uPSAccessoryRepo.save(obj);
	}

}
