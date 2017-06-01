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

	// 删除员工通过Id
	public void delete(Integer id) {
		String hql = "DELETE FROM Employee e where e.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// 通过ID查询一个员工
	public Employee getEmployeeById(Integer id) {
		String hql = "FROM Employee e left outer join fetch e.department where e.id=?";
		return (Employee) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}

	// 查询所有员工信息
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		String hql = "FROM Employee e left outer join fetch e.department";
		return entityManager.createQuery(hql).getResultList();
	}

	// 保存一个员工
	public void saveOrUpdate(Employee employee) {
		entityManager.persist(employee);
	}
}
