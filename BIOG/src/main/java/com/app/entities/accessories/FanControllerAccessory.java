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
@Table(name="fancontroller_accessory")
@JsonPropertyOrder(alphabetic = true)
public class FanControllerAccessory extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2285873838409725314L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="fancontroller_id")
	private Integer id;
	
	
	
	private int channels;
	
	//W
	@Column(name="channel_wattage")
	private int channelWattage;
	
	@Column(name="form_factor")
	private float formFactor;
	
	
	
	//PWM(4 pin) 
	private boolean pwn;
	
	
	public FanControllerAccessory() {
		super();
	}


	

	public FanControllerAccessory(int id, int channels, int channelWattage, float formFactor, String color,
			boolean pwn,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.channels = channels;
		this.channelWattage = channelWattage;
		this.formFactor = formFactor;
		
		this.pwn = pwn;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getChannels() {
		return channels;
	}




	public void setChannels(int channels) {
		this.channels = channels;
	}




	public int getChannelWattage() {
		return channelWattage;
	}




	public void setChannelWattage(int channelWattage) {
		this.channelWattage = channelWattage;
	}




	public float getFormFactor() {
		return formFactor;
	}




	public void setFormFactor(float formFactor) {
		this.formFactor = formFactor;
	}




	public boolean isPwn() {
		return pwn;
	}




	public void setPwn(boolean pwn) {
		this.pwn = pwn;
	}




	@Override
	public String toString() {
		return "FanControllerAccessory [       "+super.toString()+"       id=" + id + ", channels=" + channels + ", channelWattage=" + channelWattage
				+ ", formFactor=" + formFactor +  ", pwn=" + pwn + "]";
	}
	
	

}
