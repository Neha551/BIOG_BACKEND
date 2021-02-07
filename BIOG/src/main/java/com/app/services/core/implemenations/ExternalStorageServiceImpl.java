package com.app.services.core.implemenations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.ExternalStorage;
import com.app.entities.core.Product;
import com.app.repositories.core.IExternalStorageRepository;
import com.app.services.core.interfaces.IExternalStorageService;

@Service
@Transactional
public class ExternalStorageServiceImpl implements IExternalStorageService{

	@Autowired
	private IExternalStorageRepository externalStorageRepo;
	
	@Override
	public List<Product> getAllExternalStorage() {
		List<Product> list = new ArrayList<Product>();
		externalStorageRepo.findAll().forEach(p -> list.add(p));
		return list;

	}

	@Override
	public Product getExternalStorageById(int id) {

		Optional<ExternalStorage> opt = externalStorageRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if External Storage is not found : throw custom exception
		throw new ProductNotFoundException("No External Storage Found : Invalid ID " + id);
	}

	@Override
	public Product deleteExternalStorageById(int id) {

		// chk if External Storage exists : yes : delete , otherwise throw exc.
		Optional<ExternalStorage> optional = externalStorageRepo.findById(id);
		if (optional.isPresent()) {
			externalStorageRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("External Storage Not Found : Invalid External Storage id " + id);
	}

	@Override
	public Product updateExternalStorageById(ExternalStorage obj) {

		Optional<ExternalStorage> optional = externalStorageRepo.findById(obj.getId());
		if (optional.isPresent())
			return externalStorageRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("External Storage Not Found : Invalid External Storage id " + obj.getId());

	}

	@Override
	public Product createExternalStorage(ExternalStorage obj) {

		return externalStorageRepo.save(obj);

	}

}
