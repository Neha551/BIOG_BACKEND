package com.app.services.peripherals.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.peripherals.WebcamPeripheral;

public interface IWebcamPeripheralService {
	List<Product> getAllWebcams();
	Product getWebcamById(int id);
	Product updateWebcamById(WebcamPeripheral obj);
	Product deleteWebcamById(int id);
	Product createWebcam(WebcamPeripheral obj);
}
