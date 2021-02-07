package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Motherboard;
import com.app.entities.core.Product;


public interface IMotherboardService {
	List<Product> getAllMotherboard();

	Product getMotherboardById(int id);

	Product updateMotherboardById(Motherboard obj);

	Product deleteMotherboardById(int id);

	//creating a motherboard is this easy!!
	Product createMotherboard(Motherboard obj); 
}
