package com.app.services.accessories.interfaces;

import java.util.List;

import com.app.entities.accessories.FanControllerAccessory;
import com.app.entities.core.Product;

public interface IFanControllerAccessoryService {

	List<Product> getAllFanControllerAccessory();

	Product getFanControllerAccessoryById(int id);

	Product updateFanControllerAccessoryById(FanControllerAccessory obj);

	Product deleteFanControllerAccessoryById(int id);

	Product createFanControllerAccessory(FanControllerAccessory obj);


}
