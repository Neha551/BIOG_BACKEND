package com.app.services.networking.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.networking.WiredNetworkAdapters;
import com.app.repositories.networking.IWiredNetworkAdaptersRepository;
import com.app.services.networking.interfaces.IWiredNetworkAdapterService;


@Service
@Transactional
public class WiredNetworkAdapterServiceImplementation implements IWiredNetworkAdapterService {
	
	@Autowired
	private IWiredNetworkAdaptersRepository wiredNetworkRepo;
	

	@Override
	public List<Product> getAllWiredNetworkAdapters() {
		List<Product> list = new ArrayList<Product>();
		 wiredNetworkRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getWiredNetworkAdapterById(int id) {
		Optional<WiredNetworkAdapters> opt =wiredNetworkRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if Wired Network  is not found : throw custom exception
		throw new ProductNotFoundException("Wired Network Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateWiredNetworkAdapterById(WiredNetworkAdapters obj) {
		Optional<WiredNetworkAdapters> optional = wiredNetworkRepo.findById(obj.getId());
		if (optional.isPresent())
			return wiredNetworkRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("wiredNetwork Not Found : Invalid wiredNetwork id " + obj.getId());
	}

	@Override
	public Product deleteWiredNetworkAdapterById(int id) {
		// chk if wiredNetworkexists : yes : delete , otherwise throw exc.
				Optional<WiredNetworkAdapters> optional = wiredNetworkRepo.findById(id);
				if (optional.isPresent()) {
					wiredNetworkRepo.deleteById(id);
					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException(" wiredNetwork Not Found : Invali wiredNetwork id " + id);
			
	}

	@Override
	public Product createWiredNetworkAdapter(WiredNetworkAdapters obj) {
		return  wiredNetworkRepo.save(obj);

	}

}
