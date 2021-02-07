package com.app.services.networking.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.networking.SoundCards;
import com.app.repositories.networking.ISoundCardsRepository;
import com.app.services.networking.interfaces.ISoundCardService;


@Service
@Transactional
public class SoundCardServiceImplementations implements ISoundCardService {

	@Autowired
	private ISoundCardsRepository soundCardRepo;

	@Override
	public List<Product> getAllSoundCards() {
		List<Product> list = new ArrayList<Product>();
		soundCardRepo.findAll().forEach(p -> list.add(p));
		return list;
		
	}

	@Override
	public Product getSoundCardById(int id) {
		Optional<SoundCards> opt = soundCardRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if Sound card is not found : throw custom exception
		throw new ProductNotFoundException("Sound card Not Found : Invalid ID " + id);
	
	}

	@Override
	public Product updateSoundCardById(SoundCards obj) {
		Optional<SoundCards> optional = soundCardRepo.findById(obj.getId());
		if (optional.isPresent())
			return soundCardRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("Sound card Not Found : Invalid Sound card id " + obj.getId());
	}

	@Override
	public Product deleteSoundCardById(int id) {
		// chk if Sound card exists : yes : delete , otherwise throw exc.
				Optional<SoundCards> optional =soundCardRepo.findById(id);
				if (optional.isPresent()) {
					soundCardRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Sound card Not Found : Invalid Sound card id " + id);
	}

	@Override
	public Product createSoundCard(SoundCards obj) {
		return soundCardRepo.save(obj);
	}

}
