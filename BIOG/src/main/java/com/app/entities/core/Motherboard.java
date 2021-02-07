package com.app.entities.core;

import javax.persistence.*;

import com.app.entities.enums.FormFactor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="motherboard")
@JsonPropertyOrder(alphabetic = true)
public class Motherboard extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8729569079807502357L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="motherboard_id")
	private Integer id;
	
	//AM1,AM2,AM3..
	@Column(length=50)
	private String socket;
	
	//ATX,min ATX,,micro ATX,mini ITX..
	@Enumerated(EnumType.STRING)
	@Column(name="form_factor",length=50)
	private FormFactor formFactor;
	
	//GB(ram size*no of sticks)
	@Column(name="max_memory")
	private int maxMemory;
	
	//2,4
	@Column(name="memory_slots")
	private int memorySlots;
	
	
	@Column(length=50)
	private String chipset;
	
	public Motherboard() {
		super();
	}


	public Motherboard(int id, String socket, FormFactor formFactor, int maxMemory, int memorySlots,
			String color,String chipset,String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		 
		this.id = id;
		this.socket = socket;
		this.formFactor = formFactor;
		this.maxMemory = maxMemory;
		this.memorySlots = memorySlots;
		 this.chipset=chipset;
		
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}



	public FormFactor getFormFactor() {
		return formFactor;
	}



	public void setFormFactor(FormFactor formFactor) {
		this.formFactor = formFactor;
	}



	public int getMaxMemory() {
		return maxMemory;
	}



	public void setMaxMemory(int maxMemory) {
		this.maxMemory = maxMemory;
	}



	public int getMemorySlots() {
		return memorySlots;
	}



	public void setMemorySlots(int memorySlots) {
		this.memorySlots = memorySlots;
	}

	

	public String getChipset() {
		return chipset;
	}


	public void setChipset(String chipset) {
		this.chipset = chipset;
	}


	@Override
	public String toString() {
		return "Motherboard [       "+super.toString()+"        id=" + id + ", socket=" + socket + ", formFactor=" + formFactor + ", maxMemory="
				+ maxMemory + ", memorySlots=" + memorySlots +  ", chipset=" + chipset + "]";
	}
	
	
	
	

}
