package com.app.services.networking.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.networking.WiredNetworkAdapters;

public interface IWiredNetworkAdapterService {
	List<Product> getAllWiredNetworkAdapters();
	Product getWiredNetworkAdapterById(int id);
	Product updateWiredNetworkAdapterById(WiredNetworkAdapters obj);
	Product deleteWiredNetworkAdapterById(int id);
	Product createWiredNetworkAdapter(WiredNetworkAdapters obj);
}
