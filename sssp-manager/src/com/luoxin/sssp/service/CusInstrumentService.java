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

	// ��ѯ����Ա����Ϣ
	public List<CusInstrument> getAll() {
		return cusInstrumentDao.getAll();
	}

	// ͨ��IDɾ��Ա��
	public void delete(Integer id) {
		cusInstrumentDao.delete(id);
	}

	// ͨ��ID��ѯһ��Ա��
	public CusInstrument getCusInstrumentById(Integer id) {
		return cusInstrumentDao.getCusInstrumentById(id);
	}

	// ����Ա����Ϣ
	public void saveOrUpdate(CusInstrument cusInstrument) {
		cusInstrumentDao.saveOrUpdate(cusInstrument);
		;
	}
}
