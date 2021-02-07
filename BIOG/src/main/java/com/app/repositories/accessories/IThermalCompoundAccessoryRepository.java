package com.app.repositories.accessories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.accessories.ThermalCompoundAccessory;

public interface IThermalCompoundAccessoryRepository extends 
JpaRepository<ThermalCompoundAccessory, Integer> {

}
