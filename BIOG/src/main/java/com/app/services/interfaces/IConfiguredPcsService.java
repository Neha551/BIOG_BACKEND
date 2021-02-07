package com.app.services.interfaces;

import java.util.List;

import com.app.entities.ConfiguredPc;

public interface IConfiguredPcsService {
	    
	     
	
	    //List all pcs
		List<ConfiguredPc> getAllPcs();
		
		//get pcs details by id
		ConfiguredPc getPcsDetailsById(int pcId);
		
		 //List all pc by pctype 
		 List<ConfiguredPc> getAllPcsByType(String type);
		
		//List all pcs having price within a range
		List<ConfiguredPc> getAllPcsByPrice(double strt,double end);
		
		//List all pcs in  ascending order of price
		List<ConfiguredPc> getAllPcsByPriceInAscOrder();
		
		//insert new record
		 ConfiguredPc  savePcsDetails(ConfiguredPc transientPc);

		 //update pc details
		 ConfiguredPc updateDetails(ConfiguredPc pc);
			
		 //delete a record
		 ConfiguredPc deleteDetails(int pcId);
		  		   
		  
}
