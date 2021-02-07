package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.CPUCooler;
import com.app.entities.core.Product;
import com.app.repositories.core.ICpuCoolerRepository;
import com.app.services.core.interfaces.ICpuCoolerService;

@Service
@Transactional
public class CpuCoolerServiceImpl implements ICpuCoolerService{
	
	@Autowired
	private ICpuCoolerRepository cpuCoolerRepo;
	
	
	@Override
	public List<Product> getAllCpuCooler(){
		List<Product> list = new ArrayList<Product>();
		cpuCoolerRepo.findAll().forEach(p -> list.add(p));
		return list;
	}
	
	@Override
	public Product getCpuCoolerById(int id) {

		Optional<CPUCooler> opt = cpuCoolerRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if cpu cooler is not found : throw custom exception
		throw new ProductNotFoundException("No Cpu cooler Not Found : Invalid ID " + id);
	}
	
	@Override
	public Product updateCpuCoolerById(CPUCooler obj) {
		Optional<CPUCooler> optional = cpuCoolerRepo.findById(obj.getId());
		if (optional.isPresent())
			return cpuCoolerRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Cpu  Cooler Not Found : Invalid Cpu cooler id " + obj.getId());
	}
	
	@Override
	public Product deleteCpuCoolerById(int id) {
		// chk if cpu cooler exists : yes : delete , otherwise throw exc.
				Optional<CPUCooler> optional = cpuCoolerRepo.findById(id);
				if (optional.isPresent()) {
					cpuCoolerRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Cpu cooler Not Found : Invalid Cpu Cooler id " + id);
	}
	
	@Override
	public Product createCpuCooler(CPUCooler obj) {
		return cpuCoolerRepo.save(obj);
		
	}

}
