package com.app.services.accessories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.accessories.ThermalCompoundAccessory;
import com.app.entities.core.Product;
import com.app.repositories.accessories.IThermalCompoundAccessoryRepository;
import com.app.services.accessories.interfaces.IThermalCompoundAccessoryService;


@Service
@Transactional
public class ThermalCompoundAccessoryServiceImpl implements IThermalCompoundAccessoryService {
	@Autowired
	private IThermalCompoundAccessoryRepository thermalCompoundAccessoryRepo;

	@Override
	public List<Product> getAllThermalCompoundAccessory() {
		List<Product> list = new ArrayList<Product>();
		thermalCompoundAccessoryRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getThermalCompoundAccessoryById(int id) {
		Optional<ThermalCompoundAccessory> opt =thermalCompoundAccessoryRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if ThermalCompoundAccessory is not found : throw custom exception
		throw new ProductNotFoundException("No ThermalCompoundAccessory Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateThermalCompoundAccessoryById(ThermalCompoundAccessory obj) {
		Optional<ThermalCompoundAccessory> optional = thermalCompoundAccessoryRepo.findById(obj.getId());
		if (optional.isPresent())
			return thermalCompoundAccessoryRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("ThermalCompoundAccessory Not Found : InvalidThermalCompoundAccessory id " + obj.getId());

	}

	@Override
	public Product deleteThermalCompoundAccessoryById(int id) {
		Optional<ThermalCompoundAccessory> optional = thermalCompoundAccessoryRepo.findById(id);
		if (optional.isPresent()) {
			thermalCompoundAccessoryRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("ThermalCompoundAccessory"
					+ "Not Found : Invalid ThermalCompoundAccessory id " + id);
	}

	@Override
	public Product createThermalCompoundAccessory(ThermalCompoundAccessory obj) {
		return thermalCompoundAccessoryRepo.save(obj);
	}

		
	
}
