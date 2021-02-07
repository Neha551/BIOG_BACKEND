package com.app.services.networking.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.networking.SoundCards;

public interface ISoundCardService {
	List<Product> getAllSoundCards();
	Product getSoundCardById(int id);
	Product updateSoundCardById(SoundCards obj);
	Product deleteSoundCardById(int id);
	Product createSoundCard(SoundCards obj);
}
