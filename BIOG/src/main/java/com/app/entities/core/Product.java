package com.app.entities.core;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2055408887018984558L;
	private String name;
	private String manufacturer;
	private String brand;
	private float price;
	private boolean isAvailable;
    private String  imageUrl;
    private String color;
    
	public Product() {	
	}
	
	
	public Product(String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl,
			String color) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imageUrl = imageUrl;
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", manufacturer=" + manufacturer + ", brand=" + brand + ", price=" + price
				+ ", isAvailable=" + isAvailable + ", imageUrl=" + imageUrl + ", color=" + color + "]";
	}

	
	
	
}
