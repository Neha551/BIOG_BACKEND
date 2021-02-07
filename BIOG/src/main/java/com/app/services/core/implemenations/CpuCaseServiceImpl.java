package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.CPUCase;
import com.app.entities.core.Product;
import com.app.repositories.core.ICpuCaseRepository;
import com.app.services.core.interfaces.ICpuCaseService;

@Service
@Transactional
public class CpuCaseServiceImpl implements ICpuCaseService{
	
	@Autowired
	private ICpuCaseRepository cpuCaseRepo;
	
	
	
	@Override
	public List<Product> getAllCpuCase(){
		
		List<Product> list = new ArrayList<Product>();
		cpuCaseRepo.findAll().forEach(p -> list.add(p));
		return list;
	}
	
	@Override
	public Product getCpuCaseById(int id){
		Optional<CPUCase> opt = cpuCaseRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		
		// if cpu  case is not found : throw custom exception
		throw new ProductNotFoundException("No Cpu Case Not Found : Invalid ID " + id);
		
	}
	
	@Override
	public Product updateCpuCaseById(CPUCase obj) {
		Optional<CPUCase> optional = cpuCaseRepo.findById(obj.getId());
		if (optional.isPresent())
			return cpuCaseRepo.save(obj); // update
		// if cpu case is not found : throw custom exception
		throw new ProductNotFoundException("Cpu case Not Found : Invalid Cpu  Case id " + obj.getId());

		
		
	}
	
	@Override
	public Product deleteCpuCaseById(int id) {
		// chk if cpu case exists : yes : delete , otherwise throw exc.
				Optional<CPUCase> optional = cpuCaseRepo.findById(id);
				if (optional.isPresent()) {
					cpuCaseRepo.deleteById(id);

					return optional.get();
				} else
					// if cpu case is not found : throw custom exception
					throw new ProductNotFoundException("Cpu Case Not Found : Invalid Cpu Case id " + id);

	}
	
	@Override
	public Product createCpuCase(CPUCase obj) {
		
		return cpuCaseRepo.save(obj);
		
	}
	

}
