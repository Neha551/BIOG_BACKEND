package com.app.entities.core;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "cpu_case")
@JsonPropertyOrder(alphabetic = true)
public class CPUCase extends Product
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4167658282024153046L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpu_case_id")
	private Integer id;
	
	
	
	//ATX Mid Tower,ATX Full Tower,MicroATX Mini Tower
	@Column(length=50)
	private String type;
	
	@Column(name = "power_supply")
	private boolean powerSupply;
	
	@Column(name = "sidepanel_type",length=50)
	private String sidePanelType;

	// number if internal/external bays + type ie. 1x3.5" and 3x2.5"
	//3.5inch size
	@Column(name = "internal_bays")
	private int internalBay;
	
	//5.25
	@Column(name = "external_bays")
	private int externalBay;

	public CPUCase() {
		super();
		
	}

	

	public CPUCase(int id, String type, boolean powerSupply, String sidePanelType, int internalBay, int externalBay,String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl,
			String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.type = type;
		this.powerSupply = powerSupply;
		this.sidePanelType = sidePanelType;
		this.internalBay = internalBay;
		this.externalBay = externalBay;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(boolean powerSupply) {
		this.powerSupply = powerSupply;
	}

	public String getSidePanelType() {
		return sidePanelType;
	}

	public void setSidePanelType(String sidePanelType) {
		this.sidePanelType = sidePanelType;
	}

	public int getInternalBay() {
		return internalBay;
	}

	public void setInternalBay(int internalBay) {
		this.internalBay = internalBay;
	}

	public int getExternalBay() {
		return externalBay;
	}

	public void setExternalBay(int externalBay) {
		this.externalBay = externalBay;
	}

	@Override
	public String toString() {
		return "CPUCase [      "+super.toString()+ "     id=" + id +  ", type=" + type + ", powerSupply=" + powerSupply
				+ ", sidePanelType=" + sidePanelType + ", internalBay=" + internalBay + ", externalBay=" + externalBay
				+ "]";
	}

	
}
