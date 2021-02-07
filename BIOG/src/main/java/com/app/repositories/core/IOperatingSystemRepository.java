package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.OperatingSystem;

public interface IOperatingSystemRepository extends JpaRepository<OperatingSystem, Integer>{

}
