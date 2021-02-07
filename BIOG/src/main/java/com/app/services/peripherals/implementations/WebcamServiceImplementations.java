package com.app.services.peripherals.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.peripherals.WebcamPeripheral;
import com.app.repositories.peripherals.IWebCamPeripheralRepository;
import com.app.services.peripherals.interfaces.IWebcamPeripheralService;


@Service
@Transactional
public class WebcamServiceImplementations implements IWebcamPeripheralService {

	@Autowired
	private IWebCamPeripheralRepository webcamRepo;

	@Override
	public List<Product> getAllWebcams() {
		List<Product> list = new ArrayList<Product>();
		webcamRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getWebcamById(int id) {
		Optional<WebcamPeripheral> opt = webcamRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if WebcamPeripheralis not found : throw custom exception
		throw new ProductNotFoundException("No WebcamPeripheral Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateWebcamById(WebcamPeripheral obj) {
		Optional<WebcamPeripheral> optional = webcamRepo.findById(obj.getId());
		if (optional.isPresent())
			return webcamRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("WebcamPeripheralNot Found : Invalid WebcamPeripheral id " + obj.getId());
	}

	@Override
	public Product deleteWebcamById(int id) {
		// chk if WebcamPeripheral exists : yes : delete , otherwise throw exc.
				Optional<WebcamPeripheral> optional = webcamRepo.findById(id);
				if (optional.isPresent()) {
					webcamRepo.deleteById(id);

					return optional.get();
				} else
					// if product is not found : throw custom exception
					throw new ProductNotFoundException("Webcam Not Found : Invalid WebcamPeripheral id " + id);
	}

	@Override
	public Product createWebcam(WebcamPeripheral obj) {
		return webcamRepo.save(obj);
	}
}
