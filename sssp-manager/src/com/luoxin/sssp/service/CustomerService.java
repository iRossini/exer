package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luoxin.sssp.dao.CustomerDao;
import com.luoxin.sssp.entities.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	// 查询所有员工信息
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Transactional
	// 通过ID删除员工
	public void delete(Integer id) {
		customerDao.delete(id);
	}

	@Transactional
	// 通过ID查询一个员工
	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}

	@Transactional
	// 保存员工信息
	public void saveOrUpdate(Customer Customer) {
		customerDao.saveOrUpdate(Customer);
	}
}
