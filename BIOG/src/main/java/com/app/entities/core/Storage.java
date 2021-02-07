package com.app.entities.core;

import javax.persistence.*;

import com.app.entities.ConfiguredPc;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="storage")
@JsonPropertyOrder(alphabetic = true)
public class Storage extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4901471568265260604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="storage_id")
	 private Integer id;
	
	//GB/TB
	private int capacity;
	
	//ssd,hybrid,rpm
	@Column(length=20)
	private String type;
	
	//megabytes(mb)
	private int cache;
	
	// size, configuration or physical arrangement of solid state storage (SSS) media
	//filter size on the basis of inch/else
	@Column(name="form_factor")
	private String formFactor;
	
	//sata,pata,msata...
	@Column(length=30,name="interface")
	private String interFace;
	
	@Column(name="price_per_gb")
    private float pricePerGb;
	

	//CHILD OR MANY SIDE
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "pc_id", nullable = false)
	 @JsonIgnoreProperties("storage")
	 @JsonBackReference
	 private ConfiguredPc pc;
	
	
	
	
	
      
	public Storage() {
		super();
	}

	public Storage(int id, int capacity, String type, int cache, String formFactor, String interFace,
			float pricePerGb,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.capacity = capacity;
		this.type = type;
		this.cache = cache;
		this.formFactor = formFactor;
		this.interFace = interFace;
		this.pricePerGb = pricePerGb;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getCache() {
		return cache;
	}


	public void setCache(int cache) {
		this.cache = cache;
	}


	public String getFormFactor() {
		return formFactor;
	}


	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}


	public String getInterFace() {
		return interFace;
	}


	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}


	public float getPricePerGb() {
		return pricePerGb;
	}


	public void setPricePerGb(float pricePerGb) {
		this.pricePerGb = pricePerGb;
	}



	public ConfiguredPc getPc() {
		return pc;
	}

	public void setPc(ConfiguredPc pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return "Storage [   "+super.toString()+ "   id=" + id + ", capacity=" + capacity + ", type=" + type + ", cache=" + cache + ", formFactor="
				+ formFactor + ", interFace=" + interFace + ", pricePerGb=" + pricePerGb + "]";
	}
	

}
