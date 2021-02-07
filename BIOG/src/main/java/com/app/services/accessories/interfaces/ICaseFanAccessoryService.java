package com.app.services.accessories.interfaces;

import java.util.List;

import com.app.entities.accessories.CaseFanAccessory;
import com.app.entities.core.Product;

public interface ICaseFanAccessoryService {

	List<Product> getAllCaseFanAccessory();

	Product getCaseFanAccessoryById(int id);

	Product updateCaseFanAccessoryById(CaseFanAccessory obj);

	Product deleteCaseFanAccessoryById(int id);

	Product createCaseFanAccessory(CaseFanAccessory obj);

}
