package com.app.entities.peripherals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.core.Product;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="speaker_peripheral")
@JsonPropertyOrder(alphabetic = true)
public class SpeakerPeripheral extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2782603902115949906L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="speaker_id")
	private Integer id;
	
	private float configuration;
	
	//W
	@Column(name="total_watt")
	private int totalWattage;
	
	//(from Hz to kHz
	@Column(name="frequency_response")
	private int frequencyResponse;
	
	
	
	public SpeakerPeripheral() {
		super();
	}

	public SpeakerPeripheral(int id, float configuration, int totalWattage, int frequencyResponse, String color,String name, String manufacturer, String imageUrl,String brand, float price, boolean isAvailable) {
		super(name, manufacturer, brand, price, isAvailable,imageUrl,color);
		this.id = id;
		this.configuration = configuration;
		this.totalWattage = totalWattage;
		this.frequencyResponse = frequencyResponse;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getConfiguration() {
		return configuration;
	}

	public void setConfiguration(float configuration) {
		this.configuration = configuration;
	}

	public int getTotalWattage() {
		return totalWattage;
	}

	public void setTotalWattage(int totalWattage) {
		this.totalWattage = totalWattage;
	}

	public int getFrequencyResponse() {
		return frequencyResponse;
	}

	public void setFrequencyResponse(int frequencyResponse) {
		this.frequencyResponse = frequencyResponse;
	}

	@Override
	public String toString() {
		return "SpeakerPeripheral [   "+super.toString()+"       id=" + id + ", configuration=" + configuration + ", totalWattage=" + totalWattage
				+ ", frequencyResponse=" + frequencyResponse +  "]";
	}

	
	
	
}
