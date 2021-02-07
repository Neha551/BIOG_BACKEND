package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.Software;

public interface ISoftwareRepository extends JpaRepository<Software, Integer>{

}
