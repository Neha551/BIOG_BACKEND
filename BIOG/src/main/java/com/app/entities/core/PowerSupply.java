package com.app.entities.core;

import javax.persistence.*;

import com.app.entities.enums.PowerEfficiencyType;
import com.app.entities.enums.PowerModularType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "power_supply")
@JsonPropertyOrder(alphabetic = true)
public class PowerSupply extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6249176144988458564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "psu_id")
	private Integer id;
	
	//ATX
	@Column(name = "form_factor")
	private String formFactor;
	
	//Watt
	private int wattage;
	
	// semi/fully/none
	@Enumerated(EnumType.STRING)
	private PowerModularType modular;  
	
	//80+gold,80+silver //Enum
	@Enumerated(EnumType.STRING)
	private PowerEfficiencyType efficiency;
	
	
	public PowerSupply() {
		super();
	}

	public PowerSupply(int id, String formFactor, int wattage, PowerModularType modular, PowerEfficiencyType efficiency, String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.formFactor = formFactor;
		this.wattage = wattage;
		this.modular = modular;
		this.efficiency = efficiency;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public int getWattage() {
		return wattage;
	}

	public void setWattage(int wattage) {
		this.wattage = wattage;
	}

	public   PowerModularType getModular() {
		return modular;
	}

	public void setModular(PowerModularType modular) {
		this.modular = modular;
	}

	public PowerEfficiencyType getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(PowerEfficiencyType efficiency) {
		this.efficiency = efficiency;
	}

	
	@Override
	public String toString() {
		return "PowerSupply [    "+super.toString()+ "      id=" + id + ", formFactor=" + formFactor + ", wattage=" + wattage + ", modular=" + modular
				+ ", efficiency=" + efficiency +  "]";
	}

	

}
