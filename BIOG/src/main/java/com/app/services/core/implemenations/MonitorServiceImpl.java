package com.app.services.core.implemenations;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Monitor;
import com.app.entities.core.Product;
import com.app.repositories.core.IMonitorRepository;
import com.app.services.core.interfaces.IMonitorService;

@Service
@Transactional
public class MonitorServiceImpl implements IMonitorService{

	@Autowired
	private IMonitorRepository monitorRepo;
	
	@Override
	public List<Product> getAllMonitor(){
		List<Product> list = new ArrayList<Product>();
		monitorRepo.findAll().forEach(p -> list.add(p));
		return list;
	}
	
	@Override
	public Product getMonitorById(int id) {
		Optional<Monitor> opt = monitorRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if monitor is not found : throw custom exception
		throw new ProductNotFoundException("Monitor Not Found : Invalid ID " + id);
	}
	
	@Override
	public Product updateMonitorById(Monitor obj) {
		Optional<Monitor> optional = monitorRepo.findById(obj.getId());
		if (optional.isPresent())
			return monitorRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Monitor Not Found : Invalid Monitor id " + obj.getId());
	}
	
	@Override
	public Product deleteMonitorById(int id) {
		
		// chk if cpu exists : yes : delete , otherwise throw exc.
				Optional<Monitor> optional = monitorRepo.findById(id);
				if (optional.isPresent()) {
					monitorRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Monitor Not Found : Invalid Monitor id " + id);
	}
	
	@Override
	public Product createMonitor(Monitor obj) {
		return monitorRepo.save(obj);
	}
}
