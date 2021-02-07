package com.app.entities.peripherals;

import javax.persistence.*;

import com.app.entities.core.Product;
import com.app.entities.enums.OSType;
import com.app.entities.enums.WebcamFocusType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="webcam_peripheral")
@JsonPropertyOrder(alphabetic = true)
public class WebcamPeripheral extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1227096088701217221L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="webcam_id")
	private Integer id;
	
	
	//in pixel
	private int resolution;
	
	@Column(length=50)
	private String connection;
	
	@Enumerated(EnumType.STRING)
	@Column(name="focus_type")
	private WebcamFocusType focusType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="operating_system")
	private OSType operatingSystem;
	
	//in degrees
	@Column(name="fov_angle",length=10)
	private String fovAngle;
	
	public WebcamPeripheral() {
		super();
	}

	public WebcamPeripheral(int id, int resolution, String connection, WebcamFocusType focusType,
			OSType operatingSystem, String fovAngle,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable,imageUrl,color);
		this.id = id;
		this.resolution = resolution;
		this.connection = connection;
		this.focusType = focusType;
		this.operatingSystem = operatingSystem;
		this.fovAngle = fovAngle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public WebcamFocusType getFocusType() {
		return focusType;
	}

	public void setFocusType(WebcamFocusType focusType) {
		this.focusType = focusType;
	}

	public OSType getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OSType operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getFovAngle() {
		return fovAngle;
	}

	public void setFovAngle(String fovAngle) {
		this.fovAngle = fovAngle;
	}

	@Override
	public String toString() {
		return "WebcamPeripheral [     "+super.toString()+"      id=" + id + ", resolution=" + resolution + ", connection=" + connection
				+ ", focusType=" + focusType + ", operatingSystem=" + operatingSystem + ", fovAngle=" + fovAngle + "]";
	}
	
	
	

}
