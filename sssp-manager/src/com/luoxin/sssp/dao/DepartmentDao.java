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

	// ��ѯ���в���
	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		String sql = "FROM Department";
		return entityManager.createQuery(sql).getResultList();
	}

	// ��������
	public void saveOrUpdate(Department department) {
		entityManager.persist(department);
	}

	// ɾ������
	public void delete(Integer id) {
		String hql = "DELETE FROM Department d WHERE d.id=?";
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
	}

	// ͨ��ID��ѯһ������
	public Department getDepartmentById(Integer id) {
		String hql = "FROM Department d  WHERE d.id=?";
		return (Department) entityManager.createQuery(hql).setParameter(0, id)
				.getSingleResult();
	}
}
