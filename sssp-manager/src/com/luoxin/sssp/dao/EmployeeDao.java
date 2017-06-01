package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Employee;

@Repository
public class EmployeeDao {
	@PersistenceContext
	private EntityManager entityManager;

	// ɾ��Ա��ͨ��Id
	public void delete(Integer id) {
		String hql = "DELETE FROM Employee e where e.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ��Ա��
	public Employee getEmployeeById(Integer id) {
		String hql = "FROM Employee e left outer join fetch e.department where e.id=?";
		return (Employee) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// ��ѯ����Ա����Ϣ
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		String hql = "FROM Employee e left outer join fetch e.department";
		return entityManager.createQuery(hql).getResultList();
	}

	// ����һ��Ա��
	public void saveOrUpdate(Employee employee) {
		entityManager.persist(employee);
	}
}
