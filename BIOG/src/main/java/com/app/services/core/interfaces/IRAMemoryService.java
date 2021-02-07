package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.core.RAMMemory;

public interface IRAMemoryService {
	List<Product> getAllRAMMemory();

	Product getRAMMemoryById(int id);

	Product updateRAMMemoryById(RAMMemory obj);

	Product deleteRAMMemoryById(int id);

	Product createRAMMemory(RAMMemory obj);
}
