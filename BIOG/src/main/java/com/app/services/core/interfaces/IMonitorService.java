package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Monitor;
import com.app.entities.core.Product;

public interface IMonitorService {
	List<Product> getAllMonitor();
	Product getMonitorById(int id);
	Product updateMonitorById(Monitor obj);
	Product deleteMonitorById(int id);
	Product createMonitor(Monitor obj);

}
