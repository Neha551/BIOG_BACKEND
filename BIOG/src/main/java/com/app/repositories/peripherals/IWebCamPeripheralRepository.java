package com.app.repositories.peripherals;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.peripherals.WebcamPeripheral;

public interface IWebCamPeripheralRepository extends JpaRepository<WebcamPeripheral, Integer> {

}
