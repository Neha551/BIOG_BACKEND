package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.OpticalDrive;
import com.app.entities.core.Product;
import com.app.repositories.core.IOpticalDriveRepository;
import com.app.services.core.interfaces.IOpticalDriveService;

@Service
@Transactional
public class OpticalDriveServiceImpl implements IOpticalDriveService{
	
	@Autowired
	private IOpticalDriveRepository opticalDriveRepo;
	
	@Override
	public List<Product> getAllOpticalDrive() {
		List<Product> list = new ArrayList<Product>();
		opticalDriveRepo.findAll().forEach(p -> list.add(p));
		return list;

	}

	@Override
	public Product getOpticalDriveById(int id) {

		Optional<OpticalDrive> opt = opticalDriveRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if Optical Drive is not found : throw custom exception
		throw new ProductNotFoundException("Optical Drive Not Found : Invalid ID " + id);
	}

	@Override
	public Product deleteOpticalDriveById(int id) {

		// chk if Optical Drive exists : yes : delete , otherwise throw exc.
		Optional<OpticalDrive> optional = opticalDriveRepo.findById(id);
		if (optional.isPresent()) {
			opticalDriveRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("Optical Drive Not Found : Invalid Optical Drive id " + id);
	}

	@Override
	public 	Product updateOpticalDriveById(OpticalDrive obj) {

		Optional<OpticalDrive> optional = opticalDriveRepo.findById(obj.getId());
		if (optional.isPresent())
			return opticalDriveRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Optical Drive Not Found : Invalid Optical Drive id " + obj.getId());

	}

	@Override
	public Product createOpticalDrive(OpticalDrive obj) {

		return opticalDriveRepo.save(obj);

	}
	
	

}
