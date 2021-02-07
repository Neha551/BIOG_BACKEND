package com.app.repositories.core;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.ExternalStorage;

public interface IExternalStorageRepository extends JpaRepository<ExternalStorage, Integer>{

}
