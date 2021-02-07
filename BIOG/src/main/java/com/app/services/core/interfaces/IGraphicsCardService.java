package com.app.services.core.interfaces;

import java.util.List;

import com.app.entities.core.GraphicsCard;
import com.app.entities.core.Product;

public interface IGraphicsCardService {
	List<Product> getAllGraphicsCard();
	Product getGraphicsCardById(int id);
	Product updateGraphicsCardById(GraphicsCard obj);
	Product createGraphicsCard(GraphicsCard obj);
	Product deleteGraphicsCardById(int id);
}
