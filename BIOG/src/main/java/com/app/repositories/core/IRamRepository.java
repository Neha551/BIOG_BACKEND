package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.RAMMemory;

public interface IRamRepository extends JpaRepository<RAMMemory, Integer> {

}
