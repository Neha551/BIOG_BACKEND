package com.app.repositories.networking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.networking.WirelessNetworkAdapters;

public interface IWirelessNetworkAdaptersRepository extends JpaRepository<WirelessNetworkAdapters, Integer> {

}
