package com.app.repositories.peripherals;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.peripherals.SpeakerPeripheral;

public interface ISpeakerPeripheralRepository extends JpaRepository<SpeakerPeripheral, Integer> {

}
