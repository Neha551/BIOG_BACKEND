package com.app.services.networking.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.networking.WirelessNetworkAdapters;
import com.app.repositories.networking.IWirelessNetworkAdaptersRepository;
import com.app.services.networking.interfaces.IWirelessNetworkAdapterService;


@Service
@Transactional
public class WirelessNetworkAdapterServiceImplementation implements IWirelessNetworkAdapterService {

	@Autowired
	private IWirelessNetworkAdaptersRepository wirelessNetworkRepo;

	@Override
	public List<Product> getAllWireLessNetworkAdapters() {
		List<Product> list = new ArrayList<Product>();
		wirelessNetworkRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getWireLessNetworkAdapterById(int id) {
		Optional<WirelessNetworkAdapters> opt = wirelessNetworkRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if WirelessNetworkAdapters is not found : throw custom exception
		throw new ProductNotFoundException("WirelessNetworkAdapters Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateWireLessNetworkAdapterById(WirelessNetworkAdapters obj) {
		Optional<WirelessNetworkAdapters> optional = wirelessNetworkRepo.findById(obj.getId());
		if (optional.isPresent())
			return wirelessNetworkRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("WirelessNetworkAdapters Not Found : Invalid WirelessNetworkAdapters id " + obj.getId());
	}

	@Override
	public Product deleteWireLessNetworkAdapterById(int id) {
		// chk if WirelessNetworkAdapters exists : yes : delete , otherwise throw exc.
		Optional<WirelessNetworkAdapters> optional = wirelessNetworkRepo.findById(id);
		if (optional.isPresent()) {
			wirelessNetworkRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("WirelessNetworkAdapters Not Found : Invalid WirelessNetworkAdapters id " + id);
	}

	@Override
	public Product createWireLessNetworkAdapter(WirelessNetworkAdapters obj) {
		return wirelessNetworkRepo.save(obj);
	}

}
