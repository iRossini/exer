package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luoxin.sssp.dao.EmployeeDao;
import com.luoxin.sssp.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	// 查询所有员工信息
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Transactional
	// 通过ID删除员工
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	@Transactional
	// 通过ID查询一个员工
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@Transactional
	// 保存员工信息
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}
}
