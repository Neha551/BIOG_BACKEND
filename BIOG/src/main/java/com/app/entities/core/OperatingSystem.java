package com.app.entities.core;

import javax.persistence.*;

import com.app.entities.enums.ArchType;
import com.app.entities.enums.OSType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="operating_system")
@JsonPropertyOrder(alphabetic = true)
public class OperatingSystem extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6140833423098643658L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="operating_system_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=50)
	private OSType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="mode")
	private ArchType architecture;
	
	//GB
	@Column(name="maximum_memory_support")
	private int maxMemSupport;
	


	public OperatingSystem() {
		super();
	}



	public OperatingSystem(int id, OSType type, ArchType architecture, int maxMemSupport,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl, String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.type = type;
		this.architecture = architecture;
		this.maxMemSupport = maxMemSupport;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public OSType getType() {
		return type;
	}



	public void setType(OSType type) {
		this.type = type;
	}



	public ArchType getArchitecture() {
		return architecture;
	}



	public void setArchitecture(ArchType architecture) {
		this.architecture = architecture;
	}



	public int getMaxMemSupport() {
		return maxMemSupport;
	}



	public void setMaxMemSupport(int maxMemSupport) {
		this.maxMemSupport = maxMemSupport;
	}



	@Override
	public String toString() {
		return "OperatingSystem [     "+super.toString()+"     id=" + id + ", type=" + type + ", architecture=" + architecture + ", maxMemSupport="
				+ maxMemSupport + "]";
	}

	
	

}




