package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.Monitor;

public interface IMonitorRepository extends JpaRepository<Monitor, Integer>{

}
