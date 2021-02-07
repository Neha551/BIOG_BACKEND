package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.CPUCooler;

public interface ICpuCoolerRepository extends JpaRepository<CPUCooler, Integer>{

}
