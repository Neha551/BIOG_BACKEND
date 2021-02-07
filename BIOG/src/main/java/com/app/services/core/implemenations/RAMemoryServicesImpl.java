package com.app.services.core.implemenations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.core.RAMMemory;
import com.app.repositories.core.IRamRepository;
import com.app.services.core.interfaces.IRAMemoryService;

@Service
@Transactional
public class RAMemoryServicesImpl implements IRAMemoryService {

	@Autowired
	private IRamRepository ramRepo;


	@Override
	public List<Product> getAllRAMMemory() {
		List<Product> list = new ArrayList<Product>();
		ramRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getRAMMemoryById(int id) {

		Optional<RAMMemory> opt = ramRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if ram is not found : throw custom exception
		throw new ProductNotFoundException(" Ram Not Found : Invalid ID " + id);
	
	}

	@Override
	public Product deleteRAMMemoryById(int id) {


		// chk if ram exists : yes : delete , otherwise throw exc.
		Optional<RAMMemory> optional = ramRepo.findById(id);
		if (optional.isPresent()) {
			ramRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("Ram Not Found : Invalid Ram id " + id);
	
	}

	@Override
	public Product updateRAMMemoryById(RAMMemory obj) {

		Optional<RAMMemory> optional =ramRepo.findById(obj.getId());
		if (optional.isPresent())
			return ramRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Ram Not Found : Invalid Ram id " + obj.getId());

	}

	@Override
	public Product createRAMMemory(RAMMemory obj) {

		return ramRepo.save(obj);
		
	}

}
