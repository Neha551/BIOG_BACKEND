package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.core.Storage;
import com.app.repositories.core.IStorageRepository;
import com.app.services.core.interfaces.IStorageService;

@Service
@Transactional
public class StorageServiceImpl implements IStorageService {
	@Autowired
	private IStorageRepository storageRepo;

	

	@Override
	public List<Product> getAllStorage() {

		List<Product> list = new ArrayList<Product>();
		storageRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getStorageById(int id) {

		Optional<Storage> opt = storageRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if storage is not found : throw custom exception
		throw new ProductNotFoundException("Storage Not Found : Invalid ID " + id);
	
	}

	@Override
	public Product deleteStorageById(int id) {
		// chk if storage exists : yes : delete , otherwise throw exc.
		Optional<Storage> optional =storageRepo.findById(id);
		if (optional.isPresent()) {
			storageRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("Storage Not Found : Invalid Storage id " + id);
	
		
	}

	@Override
	public Product updateStorageById( Storage obj) {
		Optional<Storage> optional = storageRepo.findById(obj.getId());
		if (optional.isPresent())
			return storageRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Storage Not Found : Invalid Storage id " + obj.getId());

	}

	@Override
	public Product createStorage(Storage obj) {

		return storageRepo.save(obj);
		
	}

}
