package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Instrument;

@Repository
public class InstrumentDao {
	@PersistenceContext
	private EntityManager entityManager;

	// 保存仪器
	public void saveOrUpdate(Instrument instrument) {
		entityManager.persist(instrument);
	}

	// 获取所有的仪器信息

	@SuppressWarnings("unchecked")
	public List<Instrument> getAll() {
		String jpql = "FROM Instrument";
		return entityManager.createQuery(jpql).getResultList();

		// String sql = "select * from sssp_instrument";
		// return entityManager.createNativeQuery(sql).getResultList();

		// String sql = "select * from sssp_instrument";
		// return entityManager.createNativeQuery(sql, Instrument.class)
		// .getResultList();
	}

	// 通过ID删除一个仪器
	public void delete(Integer id) {
		String hql = "DELETE FROM Instrument i where i.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// 通过ID查询一个仪器
	public Instrument getInstrumentById(Integer id) {
		String hql = "FROM Instrument i left outer join fetch i.department where i.id=?";
		return (Instrument) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}
}
