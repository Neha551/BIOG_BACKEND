package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.PowerSupply;
import com.app.entities.core.Product;

public interface IPowerSupplyService {
	List<Product> getAllPowerSupply();

	Product getPowerSupplyById(int id);

	Product updatePowerSupplyById(PowerSupply obj);

	Product deletePowerSupplyById(int id);

	Product createPowerSupply(PowerSupply obj);
}
