package com.app.services.accessories.interfaces;

import java.util.List;

import com.app.entities.accessories.UPSAccessory;
import com.app.entities.core.Product;

public interface IUPSAccessoryService {

	List<Product> getAllUPSAccessory();

	Product getUPSAccessoryById(int id);

	Product updateUPSAccessoryById(UPSAccessory obj);

	Product deleteUPSAccessoryById(int id);

	Product createUPSAccessory(UPSAccessory obj);

}
