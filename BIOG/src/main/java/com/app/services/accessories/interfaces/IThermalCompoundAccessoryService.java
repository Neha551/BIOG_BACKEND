package com.app.services.accessories.interfaces;

import java.util.List;

import com.app.entities.accessories.ThermalCompoundAccessory;
import com.app.entities.core.Product;

public interface IThermalCompoundAccessoryService {
	List<Product> getAllThermalCompoundAccessory();

	Product getThermalCompoundAccessoryById(int id);

	Product updateThermalCompoundAccessoryById(ThermalCompoundAccessory obj);

	Product deleteThermalCompoundAccessoryById(int id);

	Product createThermalCompoundAccessory( ThermalCompoundAccessory obj);

}
