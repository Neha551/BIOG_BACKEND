package com.app.services.accessories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.accessories.FanControllerAccessory;
import com.app.entities.core.Product;
import com.app.repositories.accessories.IFanControllerAccessoryRepository;
import com.app.services.accessories.interfaces.IFanControllerAccessoryService;

@Service
@Transactional
public class FanControllerAccessoryServiceImpl implements IFanControllerAccessoryService {
@Autowired
private IFanControllerAccessoryRepository fanControllerRepo;

@Override
public List<Product> getAllFanControllerAccessory() {
	List<Product> list = new ArrayList<Product>();
	fanControllerRepo.findAll().forEach(p -> list.add(p));
	return list;
}

@Override
public Product getFanControllerAccessoryById(int id) {
	Optional<FanControllerAccessory> opt = fanControllerRepo.findById(id);
	if (opt.isPresent())
		return opt.get();
	// if FanControllerAccessory is not found : throw custom exception
	throw new ProductNotFoundException("No FanControllerAccessory Not Found : Invalid ID " + id);
}


@Override
public Product updateFanControllerAccessoryById(FanControllerAccessory obj) {
	Optional<FanControllerAccessory> optional = fanControllerRepo.findById(obj.getId());
	if (optional.isPresent())
		return fanControllerRepo.save(obj); // update
	// if product is not found : throw custom exception
	throw new ProductNotFoundException("FanControllerAccessory Not Found : Invalid FanControllerAccessory id " + obj.getId());

}

@Override
public Product deleteFanControllerAccessoryById(int id) {
	Optional<FanControllerAccessory> optional = fanControllerRepo.findById(id);
	if (optional.isPresent()) {
		fanControllerRepo.deleteById(id);

		return optional.get();
	} else
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("FanControllerAccessory Not Found :"
				+ " Invalid FanControllerAccessoryid " + id);
}


@Override
public Product createFanControllerAccessory(FanControllerAccessory obj) {
	return fanControllerRepo.save(obj);
}


}
