package com.app.services.accessories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.accessories.CaseFanAccessory;

import com.app.entities.core.Product;
import com.app.repositories.accessories.ICaseFanAccessoryRepository;
import com.app.services.accessories.interfaces.ICaseFanAccessoryService;



@Service
@Transactional
public class CaseFanAccessoryServiceImpl implements ICaseFanAccessoryService {

	@Autowired
	private ICaseFanAccessoryRepository caseFanAccessoryRepo;

	@Override
	public List<Product> getAllCaseFanAccessory() {
		List<Product> list = new ArrayList<Product>();
		caseFanAccessoryRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getCaseFanAccessoryById(int id) {
		Optional<CaseFanAccessory> opt = caseFanAccessoryRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if CaseFanAccessory is not found : throw custom exception
		throw new ProductNotFoundException("No CaseFanAccessory Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateCaseFanAccessoryById(CaseFanAccessory obj) {
		Optional<CaseFanAccessory> optional = caseFanAccessoryRepo.findById(obj.getId());
		if (optional.isPresent())
			return caseFanAccessoryRepo
					.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("CaseFanAccessory Not Found : Invalid CaseFanAccessory id " + obj.getId());

	}

	@Override
	public Product deleteCaseFanAccessoryById(int id) {
		// chk if CaseFanAccessory exists : yes : delete , otherwise throw exc.
				Optional<CaseFanAccessory> optional = caseFanAccessoryRepo.findById(id);
				if (optional.isPresent()) {
					caseFanAccessoryRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException(" CaseFanAccessory Not Found : Invalid  CaseFanAccessory id " + id);
			}

	@Override
	public Product createCaseFanAccessory(CaseFanAccessory obj) {
		return caseFanAccessoryRepo.save(obj);
	}
	
	
	
}
