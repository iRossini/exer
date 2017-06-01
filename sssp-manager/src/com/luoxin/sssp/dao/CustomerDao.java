package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Customer;

@Repository
public class CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;

	// ɾ���ͻ�ͨ��Id
	public void delete(Integer id) {
		String hql = "DELETE FROM Customer c where c.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ��Ա��
	public Customer getCustomerById(Integer id) {
		String hql = "FROM Customer c where c.id=?";
		return (Customer) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// ��ѯ����Ա����Ϣ
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		String hql = "FROM Customer c left outer join fetch c.order";
		return entityManager.createQuery(hql).getResultList();
	}

	// ����һ��Ա��
	public void saveOrUpdate(Customer customer) {
		entityManager.persist(customer);
	}
}
