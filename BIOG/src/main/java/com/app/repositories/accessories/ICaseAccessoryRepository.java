package com.app.repositories.accessories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.accessories.CaseAccessory;

public interface ICaseAccessoryRepository extends JpaRepository<CaseAccessory, Integer> {

}
