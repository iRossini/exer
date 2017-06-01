package com.luoxin.sssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoxin.sssp.dao.CustomerDao;
import com.luoxin.sssp.entities.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	// ��ѯ����Ա����Ϣ
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	// ͨ��IDɾ��Ա��
	public void delete(Integer id) {
		customerDao.delete(id);
	}

	// ͨ��ID��ѯһ��Ա��
	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}

	// ����Ա����Ϣ
	public void saveOrUpdate(Customer Customer) {
		customerDao.saveOrUpdate(Customer);
	}
}
