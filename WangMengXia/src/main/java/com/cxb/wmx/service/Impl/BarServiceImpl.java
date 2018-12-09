package com.cxb.wmx.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.wmx.dao.BarRpository;
import com.cxb.wmx.entity.Bar;
import com.cxb.wmx.service.BarService;

@Service
public class BarServiceImpl implements BarService{

	@Autowired
	private BarRpository barRpository;
	@Override
	public List<Bar> selectAllBar() {
		return barRpository.findAll();
	}

	@Override
	public boolean addBar(Bar bar) {
		
		try {
			barRpository.save(bar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBar(Bar bar) {
		try {
			barRpository.save(bar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBar(Integer bid) {
		try {
			barRpository.deleteById(bid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
