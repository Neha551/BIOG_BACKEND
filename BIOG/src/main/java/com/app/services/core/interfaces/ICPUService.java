package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Cpu;
import com.app.entities.core.Product;


public interface ICPUService {
	List<Product> getAllCpu();

	Product getCpuById(int id);

	Product updateCpuById(Cpu obj);

	Product deleteCpuById(int id);

	Product createCpu(Cpu obj);
	
	List<Product> getCpuByBrand(String brand);

}
