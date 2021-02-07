package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.core.Storage;

public interface IStorageService {
	List<Product> getAllStorage();
	Product getStorageById(int id);
	Product updateStorageById(Storage obj);
	Product deleteStorageById(int id);
	Product createStorage(Storage obj);
}
