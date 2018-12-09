package com.cxb.wmx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cxb.wmx.entity.Bar;


public interface BarRpository extends JpaRepository<Bar, Integer>, JpaSpecificationExecutor<Bar>{

	
}
