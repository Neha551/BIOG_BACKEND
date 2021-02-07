package com.app.services.accessories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.accessories.CaseAccessory;
import com.app.entities.core.Product;
import com.app.repositories.accessories.ICaseAccessoryRepository;
import com.app.services.accessories.interfaces.ICaseAccessoryService;



@Service
@Transactional
public class CaseAccessoryServiceImpl implements ICaseAccessoryService {
	@Autowired
	private ICaseAccessoryRepository  caseAccessoryRepo;

	@Override
	public List<Product> getAllCaseAccessory() {
		List<Product> list = new ArrayList<Product>();
		caseAccessoryRepo.findAll().forEach(p -> list.add(p));
		return list;
		
	}

	@Override
	public Product getCaseAccessoryById(int id) {
		Optional<CaseAccessory> opt = caseAccessoryRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if CaseAccessory is not found : throw custom exception
		throw new ProductNotFoundException("No CaseAccessory Not Found : Invalid ID " + id);
	
	}

	@Override
	public Product updateCaseAccessoryId(CaseAccessory obj) {
		Optional<CaseAccessory> optional = caseAccessoryRepo.findById(obj.getId());
		if (optional.isPresent())
			return caseAccessoryRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("CaseAccessory Not Found : Invalid CaseAccessory " + obj.getId());


	}

	@Override
	public Product deleteCaseAccessoryId(int id) {
		// chk if CaseAccessory exists : yes : delete , otherwise throw exc.
				Optional<CaseAccessory> optional = caseAccessoryRepo.findById(id);
				if (optional.isPresent()) {
					caseAccessoryRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("CaseAccessory Not Found : Invalid CaseAccessory id " + id);
	}

	@Override
	public Product createCaseAccessory(CaseAccessory obj) {
		return caseAccessoryRepo.save(obj);
		
	}

	
		
	
}
