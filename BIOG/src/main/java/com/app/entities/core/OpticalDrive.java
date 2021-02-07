package com.app.entities.core;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "optical_drive")
@JsonPropertyOrder(alphabetic = true)
public class OpticalDrive extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2335716564976175012L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "optical_id")
	private Integer id;

	@Column(name="blu_ray")
	private int bluRayDisc;
	
	private int dvd;
	private int cd;
	
	@Column(name="bd_write",length=50)
	private String bdWrite;
	
	@Column(name="dvd_write",length=50)
	private String dvdWrite;
	
	@Column(name="cd_write",length=50)
	private String cdWrite;

	public OpticalDrive() {
		super();
		
	}

	public OpticalDrive(int id, int bluRayDisc, int dvd, int cd, String bdWrite, String dvdWrite, String cdWrite,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.bluRayDisc = bluRayDisc;
		this.dvd = dvd;
		this.cd = cd;
		this.bdWrite = bdWrite;
		this.dvdWrite = dvdWrite;
		this.cdWrite = cdWrite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBluRayDisc() {
		return bluRayDisc;
	}

	public void setBluRayDisc(int bluRayDisc) {
		this.bluRayDisc = bluRayDisc;
	}

	public int getDvd() {
		return dvd;
	}

	public void setDvd(int dvd) {
		this.dvd = dvd;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getBdWrite() {
		return bdWrite;
	}

	public void setBdWrite(String bdWrite) {
		this.bdWrite = bdWrite;
	}

	public String getDvdWrite() {
		return dvdWrite;
	}

	public void setDvdWrite(String dvdWrite) {
		this.dvdWrite = dvdWrite;
	}

	public String getCdWrite() {
		return cdWrite;
	}

	public void setCdWrite(String cdWrite) {
		this.cdWrite = cdWrite;
	}

	@Override
	public String toString() {
		return "OpticalDrive [     "+super.toString()+ "      id=" + id + ", bluRayDisc=" + bluRayDisc + ", dvd=" + dvd + ", cd=" + cd + ", bdWrite="
				+ bdWrite + ", dvdWrite=" + dvdWrite + ", cdWrite=" + cdWrite + "]";
	}
	
	
	
}
