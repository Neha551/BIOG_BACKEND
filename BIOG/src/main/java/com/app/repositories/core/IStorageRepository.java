package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.Storage;

public interface IStorageRepository extends JpaRepository<Storage, Integer> {

}
