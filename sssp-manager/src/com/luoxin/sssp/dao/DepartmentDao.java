package com.luoxin.sssp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.luoxin.sssp.entities.Department;

@Repository
public class DepartmentDao {
	@PersistenceContext
	private EntityManager entityManager;

	// 查询所有部门
	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		String sql = "FROM Department";
		return entityManager.createQuery(sql).getResultList();
	}

	// 新增部门
	public void saveOrUpdate(Department department) {
		entityManager.persist(department);
	}

	// 删除部门
	public void delete(Integer id) {
		String hql = "DELETE FROM Department d WHERE d.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// 通过ID查询一个部门
	public Department getDepartmentById(Integer id) {
		String hql = "FROM Department d  WHERE d.id=?";
		return (Department) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}
}
