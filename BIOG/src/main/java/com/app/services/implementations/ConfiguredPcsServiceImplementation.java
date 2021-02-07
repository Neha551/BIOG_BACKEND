package com.app.services.implementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.ConfiguredPc;
import com.app.repositories.IConfiguredPCsRepository;
import com.app.services.interfaces.IConfiguredPcsService;

@Service
@Transactional
public class ConfiguredPcsServiceImplementation implements IConfiguredPcsService {

	@Autowired
	private IConfiguredPCsRepository pcRepo;

	@Override
	public List<ConfiguredPc> getAllPcs() {
		List<ConfiguredPc> list = pcRepo.findAll();
		System.out.println(list);

		return list;
	}

	@Override
	public ConfiguredPc getPcsDetailsById(int pcId) {
		// invoke dao's method
		Optional<ConfiguredPc> optionalPc = pcRepo.findById(pcId);
		if (optionalPc.isPresent())
			return optionalPc.get();
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Pc Not Found : Invalid ID " + pcId);
	}

	@Override
	public List<ConfiguredPc> getAllPcsByType(String type) {
		// invoke repo's method

		List<ConfiguredPc> list = pcRepo.findByType(type);
		if (!list.isEmpty())
			return list;
		else
			// if pc is not found : throw custom exception
			throw new ProductNotFoundException("Pc Not Found : Invalid Pc Type " + type);

	}

	@Override
	public List<ConfiguredPc> getAllPcsByPrice(double strt, double end) {

		List<ConfiguredPc> list = pcRepo.findByPriceBetween(strt, end);
		if (!list.isEmpty())
			return list;
		else
			// if pc is not found : throw custom exception
			throw new ProductNotFoundException("Pc Not Found : Invalid Pc price range " + strt + " and  " + end);

	}

	@Override
	public List<ConfiguredPc> getAllPcsByPriceInAscOrder() {
		List<ConfiguredPc> list = pcRepo.findByOrderByPriceAsc();
		if (!list.isEmpty())
			return list;
		else
			// if pc is not found : throw custom exception
			throw new ProductNotFoundException("Pc Not Found : Invalid ");
	}

	@Override
	public ConfiguredPc savePcsDetails(ConfiguredPc obj) {
		return pcRepo.save(obj);
	}

	@Override
	public ConfiguredPc updateDetails(ConfiguredPc pc) {
		// chk if pc exists
		Optional<ConfiguredPc> optional = pcRepo.findById(pc.getId());
		if (optional.isPresent())
			return pcRepo.save(pc); // update
		// if pc is not found : throw custom exception
		throw new ProductNotFoundException("Pc Not Found : Invalid Pc id " + pc.getId());
	}

	@Override
	public ConfiguredPc deleteDetails(int pcId) {
		// chk if pc exists : yes : delete , otherwise throw exc.
		Optional<ConfiguredPc> optional = pcRepo.findById(pcId);
		if (optional.isPresent()) {
			pcRepo.deleteById(pcId);
			return optional.get();
		} else
			// if pc is not found : throw custom exception
			throw new ProductNotFoundException("Pc Not Found : Invalid Pc id " + pcId);
	}

}
