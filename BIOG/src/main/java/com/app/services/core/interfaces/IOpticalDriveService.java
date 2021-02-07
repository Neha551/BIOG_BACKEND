package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.OpticalDrive;
import com.app.entities.core.Product;

public interface IOpticalDriveService {

	List<Product> getAllOpticalDrive();
	Product getOpticalDriveById(int id);
	Product updateOpticalDriveById(OpticalDrive obj);
	Product deleteOpticalDriveById(int id);
	Product createOpticalDrive(OpticalDrive obj);
}
