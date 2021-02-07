package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.CPUCase;
import com.app.entities.core.Product;

public interface ICpuCaseService {
	
	List<Product> getAllCpuCase();
	Product getCpuCaseById(int id);
	Product updateCpuCaseById(CPUCase obj);
	Product deleteCpuCaseById(int id);
	Product createCpuCase(CPUCase obj);
	

}
