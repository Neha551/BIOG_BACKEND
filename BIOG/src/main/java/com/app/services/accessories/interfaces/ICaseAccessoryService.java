package com.app.services.accessories.interfaces;

import java.util.List;

import com.app.entities.accessories.CaseAccessory;
import com.app.entities.core.Product;



public interface ICaseAccessoryService {

	List<Product> getAllCaseAccessory();

	Product getCaseAccessoryById(int id);

	Product updateCaseAccessoryId(CaseAccessory obj);

	Product deleteCaseAccessoryId(int id);

	Product createCaseAccessory(CaseAccessory obj);
}
