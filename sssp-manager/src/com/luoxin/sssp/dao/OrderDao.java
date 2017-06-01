package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Order;

@Repository
public class OrderDao {
	@PersistenceContext
	private EntityManager entityManager;

	// ɾ��Ա��ͨ��Id
	public void delete(Integer id) {
		String hql = "DELETE FROM Order o where o.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ��Ա��
	public Order geOrderById(Integer id) {
		String hql = "FROM Order o left outer join fetch o.cusInstruments and o.customer where o.id=?";
		return (Order) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// ��ѯ����Ա����Ϣ
	@SuppressWarnings("unchecked")
	public List<Order> getAll() {
		String hql = "FROM Order o left outer join fetch o.cusInstruments and o.customer ";
		return entityManager.createQuery(hql).getResultList();
	}

	// ����һ��Ա��
	public void saveOrUpdate(Order order) {
		entityManager.persist(order);
	}
}
