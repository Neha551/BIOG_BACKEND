package com.app.entities.core;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="cpu")
@JsonPropertyOrder(alphabetic = true)
public class Cpu extends Product{
		/**
	 * 
	 */
	private static final long serialVersionUID = -8948817357493797643L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		@Column(name="cpu_id")
		private Integer id;
		
		//6,8,12,10..
		@Column(name="core_count")
		private int coreCount;
		
		//GHz
		@Column(name="core_clock",length=50)
		private float coreClock;
		
		//watt
		private int tdp;
		
		@Column(name="integrated_graphics")  //yes
		private boolean integratedGraphics;
		
		//Simultaneous multithreading
		@Column(name="smt")
		private boolean simMultiThread;
		
		//Intel HD Graphics,Radeon HD 8240,Intel UHD Graphics 610
		@Column(name="graphics_type",length=50)
		private String graphicsType;
		
		
		@Column(name="socket_type",length=50)
		private String socketType;
		
		public Cpu() {
			super();
		}
		


		public Cpu(int id, int coreCount, float coreClock, int tdp, boolean integratedGraphics,String socketType,
				boolean simMultiThread, String graphicsType,String name, String manufacturer, String brand, float price, boolean isAvailable, String imageUrl,
				String color) {
			super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
			this.id = id;
			this.coreCount = coreCount;
			this.coreClock = coreClock;
			this.tdp = tdp;
			this.integratedGraphics = integratedGraphics;
			this.simMultiThread = simMultiThread;
			this.graphicsType = graphicsType;
			this.socketType=socketType;
		}



		
		
		public String getSocketType() {
			return socketType;
		}



		public void setSocketType(String socketType) {
			this.socketType = socketType;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCoreCount() {
			return coreCount;
		}

		public void setCoreCount(int coreCount) {
			this.coreCount = coreCount;
		}

		public float getCoreClock() {
			return coreClock;
		}

		public void setCoreClock(float coreClock) {
			this.coreClock = coreClock;
		}

		public int getTdp() {
			return tdp;
		}

		public void setTdp(int tdp) {
			this.tdp = tdp;
		}

		public boolean isIntegratedGraphics() {
			return integratedGraphics;
		}

		public void setIntegratedGraphics(boolean integratedGraphics) {
			this.integratedGraphics = integratedGraphics;
		}


		public boolean isSimMultiThread() {
			return simMultiThread;
		}


		public void setSimMultiThread(boolean simMultiThread) {
			this.simMultiThread = simMultiThread;
		}


		public String getGraphicsType() {
			return graphicsType;
		}


		public void setGraphicsType(String graphicsType) {
			this.graphicsType = graphicsType;
		}


		@Override
		public String toString() {
			return "Cpu [   "+super.toString()+ "      id=" + id + ", coreCount=" + coreCount + ", coreClock=" + coreClock + ", tdp=" + tdp
					+ ", integratedGraphics=" + integratedGraphics + ", simMultiThread=" + simMultiThread
					+ ", graphicsType=" + graphicsType + "socketType="   +socketType+  "]";
		}

		
		
	}



