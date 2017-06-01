package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.CusInstrument;

@Repository
public class CusInstrumentDao {
	@PersistenceContext
	private EntityManager entityManager;

	// ɾ���ͻ�ͨ��Id
	public void delete(Integer id) {
		String hql = "DELETE FROM CusInstrument c where c.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ������
	public CusInstrument getCusInstrumentById(Integer id) {
		String hql = "FROM CusInstrument c left outer join fetch c.customer where c.id=?";
		return (CusInstrument) entityManager.createQuery(hql)
				.setParameter(0, id).getSingleResult();
	}

	// ��ѯ����������Ϣ
	@SuppressWarnings("unchecked")
	public List<CusInstrument> getAll() {
		String hql = "FROM CusInstrument e left outer join fetch c.customer ";
		return entityManager.createQuery(hql).getResultList();
	}

	// ����һ��Ա��
	public void saveOrUpdate(CusInstrument cusInstrument) {
		entityManager.persist(cusInstrument);
	}
}
