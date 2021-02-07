package com.app.repositories.networking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.networking.SoundCards;

public interface ISoundCardsRepository extends JpaRepository<SoundCards, Integer> {

}
