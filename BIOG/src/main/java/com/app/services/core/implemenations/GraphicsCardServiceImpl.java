package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.GraphicsCard;
import com.app.entities.core.Product;
import com.app.repositories.core.IGraphicsCardRepository;
import com.app.services.core.interfaces.IGraphicsCardService;

@Service
@Transactional
public class GraphicsCardServiceImpl implements IGraphicsCardService{
	
	@Autowired
	private IGraphicsCardRepository graphicsCardRepo;
	
	
	
	@Override
	public List<Product> getAllGraphicsCard(){
		List<Product> list = new ArrayList<Product>();
		graphicsCardRepo.findAll().forEach(p -> list.add(p));
		return list;
	}
	
	@Override
	public Product getGraphicsCardById(int id) {
		Optional<GraphicsCard> opt =  graphicsCardRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if graphics card is not found : throw custom exception
		throw new ProductNotFoundException("No graphics card Not Found : Invalid ID " + id);
	}
	
	@Override
	public Product updateGraphicsCardById(GraphicsCard obj) {

		Optional<GraphicsCard> optional = graphicsCardRepo.findById(obj.getId());
		if (optional.isPresent())
			return graphicsCardRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Graphics card Not Found : Invalid graphics  id " + obj.getId());
	}
	
	@Override
	public Product deleteGraphicsCardById(int id) {
		// chk if graphics card exists : yes : delete , otherwise throw exc.
				Optional<GraphicsCard> optional = graphicsCardRepo.findById(id);
				if (optional.isPresent()) {
					graphicsCardRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Graphics  Card Not Found : Invalid graphics id " + id);
	}
	
	@Override
	public Product createGraphicsCard(GraphicsCard obj) {
		return graphicsCardRepo.save(obj);
		
	}

}
