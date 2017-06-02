package com.luoxin.sssp.handler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luoxin.sssp.entities.Customer;
import com.luoxin.sssp.service.CustomerService;
import com.luoxin.sssp.service.DepartmentService;

@Controller
public class CustomerController {

	// 获取CustomerService
	@Autowired
	private CustomerService customerService;

	// 获取DepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	// 获取InputStream流
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	@ModelAttribute
	private void getCustomer(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			Customer customer = customerService.getCustomerById(id);
			map.put("customer", customer);
		}
	}

	// ===========下面是逻辑业务，上面是需要的参数===============================
	// 新增客户
	@RequestMapping(value = "/customer-input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("customer", new Customer());
		return "customer-input";
	}

	// 完成添加：
	@RequestMapping(value = "/customer-save", method = RequestMethod.POST)
	public String save(Customer customer) {

		customerService.saveOrUpdate(customer);

		return "redirect:/customer-list";
	}

	// 修改客户信息
	@RequestMapping(value = "customer/{id}", method = RequestMethod.PUT)
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("customer", customerService.getCustomerById(id));
		return "customer-edit";
	}

	// 完成修改：
	@RequestMapping(value = "/customer-save", method = RequestMethod.PUT)
	public String update(Customer customer) {
		customerService.saveOrUpdate(customer);
		return "redirect:customer-list";
	}

	// 显示所有的客户
	@RequestMapping(value = "/customer-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		List<Customer> list = customerService.getAll();
		System.out.println(list.size());
		map.put("customers", list);
		return "customer-list";
	}

	// 使用Ajax 删除一个客户
	@RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			customerService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:customer-list";
	}

}
