package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.CPUCooler;
import com.app.entities.core.Product;

public interface ICpuCoolerService {
	
	List<Product> getAllCpuCooler();
	Product getCpuCoolerById(int id);
	Product updateCpuCoolerById(CPUCooler obj);
	Product deleteCpuCoolerById(int id);
	Product createCpuCooler(CPUCooler obj);

}
