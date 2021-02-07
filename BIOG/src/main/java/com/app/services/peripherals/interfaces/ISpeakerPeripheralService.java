package com.app.services.peripherals.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.peripherals.SpeakerPeripheral;

public interface ISpeakerPeripheralService {
	List<Product> getAllSpeakers();
	Product getSpeakerById(int id);
	Product updateSpeakerById(SpeakerPeripheral obj);
	Product deleteSpeakerById(int id);
	Product createSpeaker(SpeakerPeripheral obj);
}
