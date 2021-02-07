package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.core.Software;
import com.app.repositories.core.ISoftwareRepository;
import com.app.services.core.interfaces.ISoftwareService;

@Service
@Transactional
public class SoftwareServiceImpl implements ISoftwareService{
	
	@Autowired
	private ISoftwareRepository softwareRepo;
	
	@Override
	public List<Product> getAllSoftware() {
		List<Product> list = new ArrayList<Product>();
		softwareRepo.findAll().forEach(p -> list.add(p));
		return list;

	}

	@Override
	public Product getSoftwareById(int id) {

		Optional<Software> opt = softwareRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if cpu is not found : throw custom exception
		throw new ProductNotFoundException("Software Not Found : Invalid ID " + id);
	}

	@Override
	public Product deleteSoftwareById(int id) {

		// chk if Software exists : yes : delete , otherwise throw exc.
		Optional<Software> optional = softwareRepo.findById(id);
		if (optional.isPresent()) {
			softwareRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("Software Not Found : Invalid Software id " + id);
	}

	@Override
	public Product updateSoftwareById(Software obj) {

		Optional<Software> optional = softwareRepo.findById(obj.getId());
		if (optional.isPresent())
			return softwareRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Software Not Found : Invalid Software id " + obj.getId());

	}

	@Override
	public Product createSoftware(Software obj) {

		return softwareRepo.save(obj);

	}

}
