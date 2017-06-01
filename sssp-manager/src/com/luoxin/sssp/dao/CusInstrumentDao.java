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

	// 删除客户通过Id
	public void delete(Integer id) {
		String hql = "DELETE FROM CusInstrument c where c.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// 通过ID查询一个仪器
	public CusInstrument getCusInstrumentById(Integer id) {
		String hql = "FROM CusInstrument c left outer join fetch c.customer where c.id=?";
		return (CusInstrument) entityManager.createQuery(hql)
				.setParameter(0, id).getSingleResult();
	}

	// 查询所有仪器信息
	@SuppressWarnings("unchecked")
	public List<CusInstrument> getAll() {
		String hql = "FROM CusInstrument e left outer join fetch c.customer ";
		return entityManager.createQuery(hql).getResultList();
	}

	// 保存一个员工
	public void saveOrUpdate(CusInstrument cusInstrument) {
		entityManager.persist(cusInstrument);
	}
}
