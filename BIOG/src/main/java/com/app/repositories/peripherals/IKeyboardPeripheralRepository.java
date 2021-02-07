package com.app.repositories.peripherals;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.peripherals.KeyboardPeripheral;

public interface IKeyboardPeripheralRepository extends JpaRepository<KeyboardPeripheral, Integer> {

}
