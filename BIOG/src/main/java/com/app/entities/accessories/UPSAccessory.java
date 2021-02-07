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
@Table(name="ups_accessory")
@JsonPropertyOrder(alphabetic = true)
public class UPSAccessory extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1553844330998382389L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ups_id")
	private Integer id;
	
	//W
	@Column(name="capacity_w")
	private int capacityInWatt;
	
	//VA
	@Column(name="capacity_va")
	private int cpapcityInVA;
	
	
	public UPSAccessory() {
		super();
	}


	public UPSAccessory(int id, int capacityInWatt, int cpapcityInVA,String name, String manufacturer, String brand, float price, boolean isAvailable,String  imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.capacityInWatt = capacityInWatt;
		this.cpapcityInVA = cpapcityInVA;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCapacityInWatt() {
		return capacityInWatt;
	}


	public void setCapacityInWatt(int capacityInWatt) {
		this.capacityInWatt = capacityInWatt;
	}


	public int getCpapcityInVA() {
		return cpapcityInVA;
	}


	public void setCpapcityInVA(int cpapcityInVA) {
		this.cpapcityInVA = cpapcityInVA;
	}


	@Override
	public String toString() {
		return "UPSAccessory [    "+super.toString()+"      id=" + id + ", capacityInWatt=" + capacityInWatt + ", cpapcityInVA=" + cpapcityInVA + "]";
	}
	
	

}
