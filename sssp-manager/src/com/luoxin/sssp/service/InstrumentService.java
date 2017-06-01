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
	// ����һ��������Ϣ
	public void saveOrUpdate(Instrument instrument) {
		instrumentDao.saveOrUpdate(instrument);
	}

	@Transactional
	// ��ȡ���е�����
	public List<Instrument> getAll() {
		return instrumentDao.getAll();
	}

	@Transactional
	// ͨ��IDɾ��һ������
	public void delete(Integer id) {
		instrumentDao.delete(id);
	}

	@Transactional
	// ͨ��Id��ѯһ������
	public Instrument getInstrumentById(Integer id) {
		return instrumentDao.getInstrumentById(id);
	}

}
