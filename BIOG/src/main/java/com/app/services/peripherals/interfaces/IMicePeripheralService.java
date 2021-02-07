package com.app.services.peripherals.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.peripherals.MicePeripheral;

public interface IMicePeripheralService {
	List<Product> getAllMice();
	Product getMiceById(int id);
	Product updateMiceById(MicePeripheral obj);
	Product deleteMiceById(int id);
	Product createMice(MicePeripheral obj);
}
