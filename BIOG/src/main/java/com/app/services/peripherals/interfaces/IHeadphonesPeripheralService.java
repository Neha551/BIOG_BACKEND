package com.app.services.peripherals.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.peripherals.HeadphonesPeripheral;

public interface IHeadphonesPeripheralService {
	
	List<Product> getAllHeadphones();
	Product getHeadphoneById(int id);
	Product updateHeadphoneById(HeadphonesPeripheral obj);
	Product deleteHeadphoneById(int id);
	Product createHeadphone(HeadphonesPeripheral obj);

}
