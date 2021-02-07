package com.app.services.peripherals.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.peripherals.HeadphonesPeripheral;
import com.app.repositories.peripherals.IHeadphonesPeripheralRepository;
import com.app.services.peripherals.interfaces.IHeadphonesPeripheralService;

@Service
@Transactional
public class HeadphoneServiceImplementations implements IHeadphonesPeripheralService {

	@Autowired
	private IHeadphonesPeripheralRepository headphoneRepo;

	@Override
	public List<Product> getAllHeadphones() {
		List<Product> list = new ArrayList<Product>();
		headphoneRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getHeadphoneById(int id) {
		Optional<HeadphonesPeripheral> opt = headphoneRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if headphone is not found : throw custom exception
		throw new ProductNotFoundException("HeadphonesPeripheral Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateHeadphoneById(HeadphonesPeripheral obj) {

		Optional<HeadphonesPeripheral> optional = headphoneRepo.findById(obj.getId());
		if (optional.isPresent())
			return headphoneRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("HeadphonesPeripheral Not Found : Invalid HeadphonesPeripheral id " + obj.getId());
	}

	@Override
	public Product deleteHeadphoneById(int id) {

		// chk if HeadphonesPeripheral exists : yes : delete , otherwise throw exc.
		Optional<HeadphonesPeripheral> optional = headphoneRepo.findById(id);
		if (optional.isPresent()) {
			headphoneRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("HeadphonesPeripheral Not Found : Invalid HeadphonesPeripheral id " + id);
	}

	@Override
	public Product createHeadphone(HeadphonesPeripheral obj) {
		return headphoneRepo.save(obj);
	}

}
