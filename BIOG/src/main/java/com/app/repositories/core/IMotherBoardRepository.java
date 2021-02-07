package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.Motherboard;

public interface IMotherBoardRepository extends JpaRepository<Motherboard, Integer> {

}
