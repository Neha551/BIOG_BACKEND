package com.app.services.peripherals.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProductNotFoundException;
import com.app.entities.core.Product;
import com.app.entities.peripherals.KeyboardPeripheral;
import com.app.repositories.peripherals.IKeyboardPeripheralRepository;
import com.app.services.peripherals.interfaces.IKeyboardPeripheralService;


@Service
@Transactional
public class KeyboardServiceImplementations implements IKeyboardPeripheralService {

	@Autowired
	private IKeyboardPeripheralRepository keyboardRepo;

	@Override
	public List<Product> getAllKeyboard() {
		List<Product> list = new ArrayList<Product>();
		keyboardRepo.findAll().forEach(p -> list.add(p));
		return list;
	}

	@Override
	public Product getKeyboardById(int id) {
		Optional<KeyboardPeripheral> opt = keyboardRepo.findById(id);
		if (opt.isPresent())
			return opt.get();
		// if KeyboardPeripheral is not found : throw custom exception
		throw new ProductNotFoundException("KeyboardPeripheral Not Found : Invalid ID " + id);
	}

	@Override
	public Product updateKeyboardById(KeyboardPeripheral obj) {

		Optional<KeyboardPeripheral> optional =keyboardRepo.findById(obj.getId());
		if (optional.isPresent())
			return keyboardRepo.save(obj); // update
		// if product is not found : throw custom exception
		throw new ProductNotFoundException("KeyboardPeripheral Not Found : Invalid KeyboardPeripheral id " + obj.getId());
	}

	@Override
	public Product deleteKeyboardById(int id) {
		// chk if keyboard exists : yes : delete , otherwise throw exc.
		Optional<KeyboardPeripheral> optional = keyboardRepo.findById(id);
		if (optional.isPresent()) {
			keyboardRepo.deleteById(id);

			return optional.get();
		} else
			// if product is not found : throw custom exception
			throw new ProductNotFoundException("KeyboardPeripheralNot Found : Invalid KeyboardPeripheralid " + id);
	}

	@Override
	public Product createKeyboard(KeyboardPeripheral obj) {

		return keyboardRepo.save(obj);
	}

}
