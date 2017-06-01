package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luoxin.sssp.dao.InstrumentDao;
import com.luoxin.sssp.entities.Instrument;

@Service
public class InstrumentService {
	@Autowired
	private InstrumentDao instrumentDao;

	@Transactional
	// 保存一个仪器信息
	public void saveOrUpdate(Instrument instrument) {
		instrumentDao.saveOrUpdate(instrument);
	}

	@Transactional
	// 获取所有的仪器
	public List<Instrument> getAll() {
		return instrumentDao.getAll();
	}

	@Transactional
	// 通过ID删除一个仪器
	public void delete(Integer id) {
		instrumentDao.delete(id);
	}

	@Transactional
	// 通过Id查询一个仪器
	public Instrument getInstrumentById(Integer id) {
		return instrumentDao.getInstrumentById(id);
	}

}
