package com.app.repositories.accessories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.accessories.FanControllerAccessory;

public interface IFanControllerAccessoryRepository extends JpaRepository<FanControllerAccessory, Integer> {

}
