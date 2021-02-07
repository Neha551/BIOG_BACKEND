package com.app.repositories.core;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.core.Cpu;
import com.app.entities.core.Product;

public interface ICpuRepository extends JpaRepository<Cpu, Integer> {

	List<Product> findByBrand(String brand);

}
