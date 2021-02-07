package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.core.interfaces.ICPUService;

//##########################      TO FILTER CPU TYPE BY BRAND EITHER BY AMD OR INTEL ####################################################

@RestController
@RequestMapping("/cpu")
@CrossOrigin
public class CPUController {

	@Autowired
	private ICPUService cpuService;
	
	
	public CPUController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	
	
	@GetMapping("/byBrand")
	public ResponseEntity<?> getPcDetailsByType(@RequestParam String brand) {
		System.out.println("in get pc dtls " + brand);
		try {
			return ResponseEntity.ok(cpuService.getCpuByBrand(brand));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}