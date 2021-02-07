package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.ExternalStorage;
import com.app.entities.core.Product;

public interface IExternalStorageService {
	
	List<Product> getAllExternalStorage();
	Product getExternalStorageById(int id);
	Product updateExternalStorageById(ExternalStorage obj);
	Product deleteExternalStorageById(int id);
	Product createExternalStorage(ExternalStorage obj);

}
