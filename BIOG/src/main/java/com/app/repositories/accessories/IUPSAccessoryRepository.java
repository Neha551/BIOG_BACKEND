package com.app.repositories.accessories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.accessories.UPSAccessory;

public interface IUPSAccessoryRepository extends
JpaRepository<UPSAccessory, Integer> {

}
