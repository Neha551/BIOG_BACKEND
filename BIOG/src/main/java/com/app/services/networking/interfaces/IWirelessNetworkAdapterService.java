package com.app.services.networking.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.networking.WirelessNetworkAdapters;

public interface IWirelessNetworkAdapterService {
	List<Product> getAllWireLessNetworkAdapters();
	Product getWireLessNetworkAdapterById(int id);
	Product updateWireLessNetworkAdapterById(WirelessNetworkAdapters obj);
	Product deleteWireLessNetworkAdapterById(int id);
	Product createWireLessNetworkAdapter(WirelessNetworkAdapters obj);
}
