package com.app.entities.core;

import javax.persistence.*;

import com.app.entities.ConfiguredPc;
import com.app.entities.enums.RamType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="ram_memory")
@JsonPropertyOrder(alphabetic = true)
public class RAMMemory extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8194374587195453287L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="ram_id")
	private Integer id;
	
	//1,2
	@Column(name="no_of_sticks")
	private int noOfSticks;
	
	//8GB,1GB,2GB
	@Column(name="ram_size")
	private int ramSize;
	
	//total ram size will be=ramSize*noOfSticks
	@Column(name="total_ram_size")
	private int totalSize;
	
	//DDR4,DDR2,DDR..
	@Enumerated(EnumType.STRING)
	@Column(length=50)
	private RamType type;
	
	//megahertz
	private int speed;
	
	//nano seconds
	@Column(name="first_word_latency")
	private float firstWordLatency;
	
	//numbers
	@Column(name="cas_latency")
	private int columnAddressStrobe;
	
	//CHILD OR MANY SIDE
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "pc_id", nullable = false)
	 @JsonIgnoreProperties("ramMemory")
	 @JsonBackReference
     private ConfiguredPc pc;
	
	 
	 
	public RAMMemory() {
		super();
	}
	


	public RAMMemory(int id, int noOfSticks,int ramSize, RamType type, int speed, float firstWordLatency, int columnAddressStrobe,
			String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.noOfSticks =noOfSticks;
		this.ramSize=ramSize;
		this.type = type;
		this.speed = speed;
		this.firstWordLatency = firstWordLatency;
		this.columnAddressStrobe = columnAddressStrobe;
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getNoOfSticks() {
		return noOfSticks;
	}



	public void setNoOfSticks(int noOfSticks) {
		this.noOfSticks = noOfSticks;
	}



	public int getRamSize() {
		return ramSize;
	}



	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}



	public int getTotalSize() {
		return totalSize;
	}



	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}



	public RamType getType() {
		return type;
	}



	public void setType(RamType type) {
		this.type = type;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public float getFirstWordLatency() {
		return firstWordLatency;
	}



	public void setFirstWordLatency(float firstWordLatency) {
		this.firstWordLatency = firstWordLatency;
	}



	public int getColumnAddressStrobe() {
		return columnAddressStrobe;
	}



	public void setColumnAddressStrobe(int columnAddressStrobe) {
		this.columnAddressStrobe = columnAddressStrobe;
	}


	public ConfiguredPc getPc() {
		return pc;
	}



	public void setPc(ConfiguredPc pc) {
		this.pc = pc;
	}



	@Override
	public String toString() {
		return "RAMMemory [ "+super.toString()+"      id=" + id + ", noOfSticks=" + noOfSticks + ", ramSize=" + ramSize + ", totalSize="
				+ totalSize + ", type=" + type + ", speed=" + speed + ", firstWordLatency=" + firstWordLatency
				+ ", columnAddressStrobe=" + columnAddressStrobe +      "]";  //"pcid=    "+pc+ 
	}



	}
