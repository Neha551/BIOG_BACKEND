package com.app.entities.peripherals;

import javax.persistence.*;

import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.core.Product;
import com.app.entities.enums.KeyboardStyle;
import com.app.entities.enums.PeripheralConnectionType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="keyboard_peripheral")
@JsonPropertyOrder(alphabetic = true)
public class KeyboardPeripheral extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1295670903604995088L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="keyboard_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private KeyboardStyle style;
	
	@Column(name="switch_type")
	private String switchType;
	
	@Column(name="is_tenkeyless")
	private boolean isTenkeyLess;
	
	@Enumerated(EnumType.STRING)
	@Column(name="connection_type")
	private PeripheralConnectionType connectionType;
	
	//RGB,.
	@Column(name="backlit")
	private String backlit;
	
	
	public KeyboardPeripheral() {
		super();
	}

	public KeyboardPeripheral(int id, KeyboardStyle style, String switchType, boolean isTenkeyLess,
			 PeripheralConnectionType connectionType, String backlit, String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable,imageUrl,color);
		this.id = id;
		this.style = style;
		this.switchType = switchType;
		this.isTenkeyLess = isTenkeyLess;
		this.connectionType = connectionType;
		this.backlit = backlit;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KeyboardStyle getStyle() {
		return style;
	}

	public void setStyle(KeyboardStyle style) {
		this.style = style;
	}

	public String getSwitchType() {
		return switchType;
	}

	public void setSwitchType(String switchType) {
		this.switchType = switchType;
	}

	public boolean isTenkeyLess() {
		return isTenkeyLess;
	}

	public void setTenkeyLess(boolean isTenkeyLess) {
		this.isTenkeyLess = isTenkeyLess;
	}

	public  PeripheralConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType( PeripheralConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public String getBacklit() {
		return backlit;
	}

	public void setBacklit(String backlit) {
		this.backlit = backlit;
	}

	@Override
	public String toString() {
		return "KeyboardPeripheral [    "+super.toString()+"        id=" + id + ", style=" + style + ", switchType=" + switchType + ", isTenkeyLess="
				+ isTenkeyLess + ", connectionType=" + connectionType + ", backlit=" + backlit 
				+ "]";
	}

	
	

}
