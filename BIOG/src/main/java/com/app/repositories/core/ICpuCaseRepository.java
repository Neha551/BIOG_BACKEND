package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.CPUCase;

public interface ICpuCaseRepository extends JpaRepository<CPUCase, Integer>{

}
