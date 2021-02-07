package com.app.services.peripherals.interfaces;

import java.util.List;

import com.app.entities.core.Product;
import com.app.entities.peripherals.KeyboardPeripheral;

public interface IKeyboardPeripheralService {
	List<Product> getAllKeyboard();
	Product getKeyboardById(int id);
	Product updateKeyboardById(KeyboardPeripheral obj);
	Product deleteKeyboardById(int id);
	Product createKeyboard(KeyboardPeripheral obj);
}
