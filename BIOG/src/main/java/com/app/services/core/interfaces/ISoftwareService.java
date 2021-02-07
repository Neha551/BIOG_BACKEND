package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.core.Software;

public interface ISoftwareService {

	List<Product> getAllSoftware();
	Product getSoftwareById(int id);
	Product deleteSoftwareById(int id);
	Product updateSoftwareById(Software obj);
	Product createSoftware(Software obj);
}
