package com.app.services.peripherals.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.peripherals.SpeakerPeripheral;
import com.app.repositories.peripherals.ISpeakerPeripheralRepository;
import com.app.services.peripherals.interfaces.ISpeakerPeripheralService;


@Service
@Transactional
public class SpeakerServiceImplementations implements ISpeakerPeripheralService {

	@Autowired
	private ISpeakerPeripheralRepository speakerRepo;

	@Override
	public List<Product> getAllSpeakers() {
		List<Product> list = new ArrayList<Product>();
		speakerRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getSpeakerById(int id) {
		Optional<SpeakerPeripheral> opt = speakerRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if SpeakerPeripheral is not found : throw custom exception
		throw new ProductNotFoundException("SpeakerPeripheral Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateSpeakerById(SpeakerPeripheral obj) {
		Optional<SpeakerPeripheral> optional = speakerRepo.findById(obj.getId());
		if (optional.isPresent())
			return speakerRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("SpeakerPeripheral Not Found : Invalid SpeakerPeripheral id " + obj.getId());
	}

	@Override
	public Product deleteSpeakerById(int id) {
		// chk if SpeakerPeripheral exists : yes : delete , otherwise throw exc.
		Optional<SpeakerPeripheral> optional = speakerRepo.findById(id);
		if (optional.isPresent()) {
			speakerRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("SpeakerPeripheralNot Found : Invalid SpeakerPeripheral id " + id);
	}

	@Override
	public Product createSpeaker(SpeakerPeripheral obj) {
		return speakerRepo.save(obj);
	}

}
