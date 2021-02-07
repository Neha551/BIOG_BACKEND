package com.app.repositories.peripherals;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.peripherals.MicePeripheral;

public interface IMicePeripheralRepository extends JpaRepository<MicePeripheral, Integer> {

}
