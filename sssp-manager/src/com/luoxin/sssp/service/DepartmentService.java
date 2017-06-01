package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luoxin.sssp.dao.DepartmentDao;
import com.luoxin.sssp.entities.Department;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;

	// ��ѯ���в���
	@Transactional
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	// ����һ������
	@Transactional
	public void saveOrUpdate(Department department) {
		departmentDao.saveOrUpdate(department);
	}

	// ɾ��һ������
	@Transactional
	public void delete(Integer id) {
		departmentDao.delete(id);
	}

	// ��ѯһ������
	@Transactional
	public Department getDepartmentById(Integer id) {
		return departmentDao.getDepartmentById(id);
	}
}
