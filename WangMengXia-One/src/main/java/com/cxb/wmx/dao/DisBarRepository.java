package com.cxb.wmx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cxb.wmx.entity.Disbar;

public interface DisBarRepository extends JpaRepository<Disbar, Integer>,JpaSpecificationExecutor<Disbar>{

}
