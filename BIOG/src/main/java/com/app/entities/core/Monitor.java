package com.app.entities.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.enums.MonitorPanelType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "monitor")
@JsonPropertyOrder(alphabetic = true)
public class Monitor extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4012321564578049608L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="monitor_id")
	private Integer id;
	
	
	@Column(name="screen_size")
	private int screenSize;
	
	@Column(length=50)
	private String resultion;
	
	//in Hz
	@Column(name="refresh_rate")
	private int refreshRate;
	
	//in milli seconds(ms)
	@Column(name="response_time")
	private int responseTime;
	
	@Column(name="panel_type",length=30)
	private MonitorPanelType panelType;
	
	@Column(name="aspect_ration",length=50)
	private String aspectRatio;
	
	public Monitor() {
		super();
	}

	public Monitor(int id, int screenSize, String resultion, int refreshRate, int responseTime,
			MonitorPanelType panelType, String aspectRatio,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.screenSize = screenSize;
		this.resultion = resultion;
		this.refreshRate = refreshRate;
		this.responseTime = responseTime;
		this.panelType = panelType;
		this.aspectRatio = aspectRatio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public String getResultion() {
		return resultion;
	}

	public void setResultion(String resultion) {
		this.resultion = resultion;
	}

	public int getRefreshRate() {
		return refreshRate;
	}

	public void setRefreshRate(int refreshRate) {
		this.refreshRate = refreshRate;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public MonitorPanelType getPanelType() {
		return panelType;
	}

	public void setPanelType(MonitorPanelType panelType) {
		this.panelType = panelType;
	}

	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	@Override
	public String toString() {
		return "Monitor [    "+super.toString()+"      id=" + id + ", screenSize=" + screenSize + ", resultion=" + resultion + ", refreshRate="
				+ refreshRate + ", responseTime=" + responseTime + ", panelType=" + panelType + ", aspectRatio="
				+ aspectRatio + "]";
	}
	

}
