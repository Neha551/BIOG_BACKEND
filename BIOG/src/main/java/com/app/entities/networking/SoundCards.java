package com.app.entities.networking;
import com.app.entities.core.*;
import com.app.entities.enums.SoundCardInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="sound_card")
@JsonPropertyOrder(alphabetic = true)
public class SoundCards extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3811423431652683587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="soundcard_id")
	private Integer id;

	private float channels;
	
	//bit
	@Column(name="digital_audio")
	private int digitalAudio;
	
	//dB
	@Column(name="snr")
	 private int signalToNoiseRatio;
	
	//kilohertz(kHz)
	@Column(name="sample_rate")
	 private int sampleRate;
	 
	 @Column(name="chipset",length=50)
	 private String chipSet;
	 
	 @Enumerated(EnumType.STRING)
	 @Column(name="interface")
	 private SoundCardInterface interFace;
	 
	 
	public SoundCards() {
		super();
	}

	

	


	public SoundCards(int id, float channels, int digitalAudio, int signalToNoiseRatio, int sampleRate, String chipSet,
			SoundCardInterface interFace,String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl,
			String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.channels = channels;
		this.digitalAudio = digitalAudio;
		this.signalToNoiseRatio = signalToNoiseRatio;
		this.sampleRate = sampleRate;
		this.chipSet = chipSet;
		this.interFace = interFace;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public float getChannels() {
		return channels;
	}



	public void setChannels(float channels) {
		this.channels = channels;
	}



	public int getDigitalAudio() {
		return digitalAudio;
	}



	public void setDigitalAudio(int digitalAudio) {
		this.digitalAudio = digitalAudio;
	}



	public int getSignalToNoiseRatio() {
		return signalToNoiseRatio;
	}



	public void setSignalToNoiseRatio(int signalToNoiseRatio) {
		this.signalToNoiseRatio = signalToNoiseRatio;
	}



	public int getSampleRate() {
		return sampleRate;
	}



	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate;
	}



	public String getChipSet() {
		return chipSet;
	}



	public void setChipSet(String chipSet) {
		this.chipSet = chipSet;
	}



	public SoundCardInterface getInterFace() {
		return interFace;
	}



	public void setInterFace(SoundCardInterface interFace) {
		this.interFace = interFace;
	}



	@Override
	public String toString() {
		return "SoundCards [    "+super.toString()+"       id=" + id + ", channels=" + channels + ", digitalAudio=" + digitalAudio
				+ ", signalToNoiseRatio=" + signalToNoiseRatio + ", sampleRate=" + sampleRate + ", chipSet=" + chipSet
				+ ", interFace=" + interFace + "]";
	}

	
}
