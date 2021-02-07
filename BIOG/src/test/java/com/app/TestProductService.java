package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entities.ConfiguredPc;
import com.app.entities.core.Product;
import com.app.services.core.interfaces.ICPUService;
import com.app.services.interfaces.IConfiguredPcsService;

@SpringBootTest
class TestProductService {
	
	@Autowired
	private IConfiguredPcsService pcService;
	
	
	@Autowired
	private ICPUService cpuService;
	

	@Test
	public void testGetPcDetails()
	{
		ConfiguredPc p=pcService.getPcsDetailsById(4);
		assertEquals(67899, p.getPrice());
	}
       
	
	
	@Test
	public void testGetCpuDetails()
	{
		Product p=cpuService.getCpuById(4);
		assertEquals(23745.400390625, p.getPrice());
	}
}
