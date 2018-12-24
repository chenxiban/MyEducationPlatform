package com.cxb.wmx.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cxb.wmx.entity.Reportcount;

public interface ReportcountRpository extends JpaRepository<Reportcount, Integer>, JpaSpecificationExecutor<Reportcount>{

}
