package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoxin.sssp.dao.EmployeeDao;
import com.luoxin.sssp.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	// ��ѯ����Ա����Ϣ
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	// ͨ��IDɾ��Ա��
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

	// ͨ��ID��ѯһ��Ա��
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	// ����Ա����Ϣ
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}
}
