package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.OperatingSystem;
import com.app.entities.core.Product;

public interface IOperatingSystemService {

	List<Product> getAllOperatingSystem();
	Product getOperatingSystemById(int id);
	Product updateOperatingSystemById(OperatingSystem obj);
	Product deleteOperatingSystemById(int id);
	Product createOperatingSystem(OperatingSystem obj);
}
