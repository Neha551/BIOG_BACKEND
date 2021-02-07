package com.app.entities;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.core.CPUCase;
import com.app.entities.core.CPUCooler;
import com.app.entities.core.Cpu;

import com.app.entities.core.GraphicsCard;
import com.app.entities.core.Monitor;
import com.app.entities.core.Motherboard;
import com.app.entities.core.OperatingSystem;
import com.app.entities.core.OpticalDrive;
import com.app.entities.core.PowerSupply;
import com.app.entities.core.RAMMemory;

import com.app.entities.core.Storage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="configured_pc")

public class ConfiguredPc implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6584642905656328185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="configured_pc_id")
	private Integer id;
	
	@Column(length=30)
	private String type;
	
	@Column
	private String imageUrl;
	
	@Column
	private double price;
	
//	  //PARENT SIDE OR ONE SIDE
      @JsonIgnoreProperties("pc")
     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
      @JsonManagedReference
     private List<RAMMemory> ramMemory=new ArrayList<>();
  

	  
	//PARENT SIDE OR ONE SIDE
	  @JsonIgnoreProperties("pc")
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) 
	  @JsonManagedReference
	  private List<GraphicsCard> graphicsCard= new ArrayList<>();	  
	
	 
	//PARENT SIDE OR ONE SIDE
      @JsonIgnoreProperties("pc")
	  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
      @JsonManagedReference
	  private List<Storage> storage= new ArrayList<>();	

	
	//@PrimaryKeyJoinColumn
	@OneToOne(orphanRemoval  = false)
	@JoinColumn(name="cpu_id") 
	private Cpu cpu;
	
	
	
	@OneToOne
	@JoinColumn(name="cpu_case_id") 
	private CPUCase cpuCase;
	  


	  @OneToOne
	  @JoinColumn(name="cooler_id") 
	  private CPUCooler cpuCooler;
	 
	  
	  @OneToOne
	  @JoinColumn(name="monitor_id") 
	  private Monitor monitor;
	  
	  
	  @OneToOne 
	  @JoinColumn(name="motherboard_id") 
	  private Motherboard motherBoard;
	  
	  @OneToOne
	  @JoinColumn(name="operating_system_id") 
	  private OperatingSystem operatingSystem;
	  
	  
	  @OneToOne 
	  @JoinColumn(name="optical_id") 
	  private OpticalDrive opticalDrive;
	  
	  
	  @OneToOne
	  @JoinColumn(name="psu_id") 
	  private PowerSupply powerSupply;
	  
	  
	  

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


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


   public List<RAMMemory> getRamMemory()
   {
		return ramMemory;
	}

	public void setRamMemory(List<RAMMemory> ramMemory) {
		this.ramMemory = ramMemory;
	}


	public List<GraphicsCard> getGraphicsCard() {
		return graphicsCard;
	}

	public void setGraphicsCard(List<GraphicsCard> graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	public List<Storage> getStorage() {
		return storage;
	}

	public void setStorage(List<Storage> storage) {
		this.storage = storage;
	}


	public Cpu getCpu() {
		return cpu;
	}


	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public CPUCase getCpuCase() {
		return cpuCase;
	}

	
	public void setCpuCase(CPUCase cpuCase) {
		this.cpuCase = cpuCase;
	}


	public CPUCooler getCpuCooler() {
		return cpuCooler;
	}

	
	public void setCpuCooler(CPUCooler cpuCooler) {
		this.cpuCooler = cpuCooler;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Motherboard getMotherBoard() {
		return motherBoard;
	}


	public void setMotherBoard(Motherboard motherBoard) {
		this.motherBoard = motherBoard;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public OpticalDrive getOpticalDrive() {
		return opticalDrive;
	}

	public void setOpticalDrive(OpticalDrive opticalDrive) {
		this.opticalDrive = opticalDrive;
	}

	public PowerSupply getPowerSupply() {
		return powerSupply;
	}


	public void setPowerSupply(PowerSupply powerSupply) {
		this.powerSupply = powerSupply;
	}

	
public ConfiguredPc() {
		super();
		
	}


@Override
public String toString() {
	return "ConfiguredPc [id=" + id + ", type=" + type + ", imageUrl=" + imageUrl + ", price=" + price + ", cpu=" + cpu
			+ ", cpuCase=" + cpuCase + ", cpuCooler=" + cpuCooler + ", monitor=" + monitor + ", motherBoard="
			+ motherBoard + ", operatingSystem=" + operatingSystem + ", opticalDrive=" + opticalDrive + ", powerSupply="
			+ powerSupply + "]";
}


//	public void saveRamMemory(RAMMemory ram) {
//		this.ramMemory.add(ram);
//		 ram.setPc(this);
//	     }
//	                
    

}