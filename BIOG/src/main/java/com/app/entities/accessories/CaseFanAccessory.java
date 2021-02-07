package com.app.entities.accessories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.core.Product;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="casefan_accessory")
@JsonPropertyOrder(alphabetic = true)
public class CaseFanAccessory extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3180900986800259691L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="casefan_accid")
	private Integer id;
	
	//mm
	private int size;
	
	private int rpm;
	
	//CFM
	@Column(name="air_flow")
	private float airFlow;
	
	//db
	@Column(name="noise_level")
	private float noiseLevel;
	
	private boolean  pwm;

	public CaseFanAccessory() {
		super();
	}


	public CaseFanAccessory(int id, int size, int rpm, float airFlow, float noiseLevel, boolean pwm, String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String  imageUrl) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.size = size;
		this.rpm = rpm;
		this.airFlow = airFlow;
		this.noiseLevel = noiseLevel;
		this.pwm = pwm;
	
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getRpm() {
		return rpm;
	}


	public void setRpm(int rpm) {
		this.rpm = rpm;
	}


	public float getAirFlow() {
		return airFlow;
	}


	public void setAirFlow(float airFlow) {
		this.airFlow = airFlow;
	}


	public float getNoiseLevel() {
		return noiseLevel;
	}


	public void setNoiseLevel(float noiseLevel) {
		this.noiseLevel = noiseLevel;
	}


	public boolean isPwm() {
		return pwm;
	}


	public void setPwm(boolean pwm) {
		this.pwm = pwm;
	}


	@Override
	public String toString() {
		return "CaseFanAccessory [     "+super.toString()+"      id=" + id + ", size=" + size + ", rpm=" + rpm + ", airFlow=" + airFlow
				+ ", noiseLevel=" + noiseLevel + ", pwm=" + pwm +  "]";
	}
	
	

}
