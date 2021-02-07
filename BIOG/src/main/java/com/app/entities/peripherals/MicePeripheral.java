package com.app.entities.peripherals;

import javax.persistence.*;

import com.app.entities.core.Product;
import com.app.entities.enums.MiceOrientation;
import com.app.entities.enums.MiceTrackingMethod;
import com.app.entities.enums.PeripheralConnectionType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="mice_peripheral")
@JsonPropertyOrder(alphabetic = true)
public class MicePeripheral extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1633218764704300450L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="mice_id")
	private Integer id;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="tracking_method")
	private MiceTrackingMethod trackingMethod;
	
	@Enumerated(EnumType.STRING)
	@Column(name="connection_type")
	private PeripheralConnectionType connectionType;
	
	@Column(name="maximum_dpi")
	private int maxDpi;
	
	@Enumerated(EnumType.STRING)
	@Column(name="hand_orientation")
	private MiceOrientation handOrientation;
	
	
	
	public MicePeripheral() {
		super();
	}


	public MicePeripheral(int id, MiceTrackingMethod trackingMethod, PeripheralConnectionType connectionType,
			int maxDpi, MiceOrientation handOrientation, String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable,imageUrl,color);
		this.id = id;
		this.trackingMethod = trackingMethod;
		this.connectionType = connectionType;
		this.maxDpi = maxDpi;
		this.handOrientation = handOrientation;
	
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public MiceTrackingMethod getTrackingMethod() {
		return trackingMethod;
	}


	public void setTrackingMethod(MiceTrackingMethod trackingMethod) {
		this.trackingMethod = trackingMethod;
	}


	public PeripheralConnectionType getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(PeripheralConnectionType connectionType) {
		this.connectionType = connectionType;
	}


	public int getMaxDpi() {
		return maxDpi;
	}


	public void setMaxDpi(int maxDpi) {
		this.maxDpi = maxDpi;
	}


	public MiceOrientation getHandOrientation() {
		return handOrientation;
	}


	public void setHandOrientation(MiceOrientation handOrientation) {
		this.handOrientation = handOrientation;
	}


	@Override
	public String toString() {
		return "MicePeripheral [    "+super.toString()+"         id=" + id + ", trackingMethod=" + trackingMethod + ", connectionType=" + connectionType
				+ ", maxDpi=" + maxDpi + ", handOrientation=" + handOrientation +  "]";
	}
	
	

}
