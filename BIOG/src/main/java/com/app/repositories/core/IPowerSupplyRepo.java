package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.PowerSupply;

public interface IPowerSupplyRepo extends JpaRepository<PowerSupply, Integer> {

}
