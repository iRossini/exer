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

	// 查询所有部门
	@Transactional
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	// 保存一个部门
	@Transactional
	public void saveOrUpdate(Department department) {
		departmentDao.saveOrUpdate(department);
	}

	// 删除一个部门
	@Transactional
	public void delete(Integer id) {
		departmentDao.delete(id);
	}

	// 查询一个部门
	@Transactional
	public Department getDepartmentById(Integer id) {
		return departmentDao.getDepartmentById(id);
	}
}
