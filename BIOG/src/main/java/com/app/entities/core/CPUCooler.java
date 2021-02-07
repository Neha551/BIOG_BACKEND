package com.app.entities.core;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@Table(name="cpu_cooler")
@JsonPropertyOrder(alphabetic = true)
public class CPUCooler extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582354397481546541L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="cooler_id")
	private Integer id;
	
	//it can be in rpm (no ranges allow in database)
	@Column(name="fan_rpm")
	private int fanRpm;
	
	//unit in db
	@Column(name="noise_level")
	private float noiseLevel;
	
	//unit in mm
	@Column(name="radiator_size")
	private int radiatorSize;
	
	
	
	public CPUCooler() {
          
		super();
	}


	public CPUCooler(int id, int fanRpm, float noiseLevel, int radiatorSize,String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl,
			String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.fanRpm = fanRpm;
		this.noiseLevel = noiseLevel;
		this.radiatorSize = radiatorSize;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	public float getNoiseLevel() {
		return noiseLevel;
	}


	public void setNoiseLevel(float noiseLevel) {
		this.noiseLevel = noiseLevel;
	}


	public int getFanRpm() {
		return fanRpm;
	}


	public void setFanRpm(int fanRpm) {
		this.fanRpm = fanRpm;
	}


	public int getRadiatorSize() {
		return radiatorSize;
	}


	public void setRadiatorSize(int radiatorSize) {
		this.radiatorSize = radiatorSize;
	}


	

	@Override
	public String toString() {
		return "CPUCooler [  " +super.toString()+ "   id=" + id + ", fanRpm=" + fanRpm + ", noiseLevel=" + noiseLevel + ", radiatorSize="
				+ radiatorSize + "]";
	}


	

}
