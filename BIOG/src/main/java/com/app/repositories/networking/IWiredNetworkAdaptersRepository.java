package com.app.repositories.networking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.networking.WiredNetworkAdapters;

public interface IWiredNetworkAdaptersRepository extends JpaRepository<WiredNetworkAdapters, Integer> {

}
