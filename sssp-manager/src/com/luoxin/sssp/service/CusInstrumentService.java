package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoxin.sssp.dao.CusInstrumentDao;
import com.luoxin.sssp.entities.CusInstrument;

@Service
public class CusInstrumentService {
	@Autowired
	private CusInstrumentDao cusInstrumentDao;

	// 查询所有员工信息
	public List<CusInstrument> getAll() {
		return cusInstrumentDao.getAll();
	}

	// 通过ID删除员工
	public void delete(Integer id) {
		cusInstrumentDao.delete(id);
	}

	// 通过ID查询一个员工
	public CusInstrument getCusInstrumentById(Integer id) {
		return cusInstrumentDao.getCusInstrumentById(id);
	}

	// 保存员工信息
	public void saveOrUpdate(CusInstrument cusInstrument) {
		cusInstrumentDao.saveOrUpdate(cusInstrument);
		;
	}
}
