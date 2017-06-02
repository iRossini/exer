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
	// ��ѯ����Ա����Ϣ
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Transactional
	// ͨ��IDɾ��Ա��
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	@Transactional
	// ͨ��ID��ѯһ��Ա��
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@Transactional
	// ����Ա����Ϣ
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}
}
