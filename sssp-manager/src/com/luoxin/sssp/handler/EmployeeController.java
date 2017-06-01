package com.luoxin.sssp.handler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luoxin.sssp.entities.Employee;
import com.luoxin.sssp.service.DepartmentService;
import com.luoxin.sssp.service.EmployeeService;

@Controller
public class EmployeeController {

	// ��ȡEmployeeService
	@Autowired
	private EmployeeService employeeService;

	// ��ȡDepartmentService
	@Autowired
	private DepartmentService departmentService;

	// ��ȡInputStream��
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	@ModelAttribute
	private void getEmployee(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			Employee employee = employeeService.getEmployeeById(id);
			map.put("employee", employee);
		}
	}

	// ===========�������߼�ҵ����������Ҫ�Ĳ���===============================
	// �����Ա��ҳ���ȡ�����š���������
	@RequestMapping(value = "/emp-input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("employee", new Employee());
		return "emp-input";
	}

	// �����ӣ�
	@RequestMapping(value = "/emp-save", method = RequestMethod.POST)
	public String save(Employee employee) {
		employeeService.saveOrUpdate(employee);
		return "save";
	}

	// ʹ��Ajax ɾ��һ��Ա��
	@RequestMapping(value = "/emp-delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:/emp-list";
	}

	// �޸�Ա����Ϣ
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("employee", employeeService.getEmployeeById(id));
		return "emp-edit";
	}

	// ����޸ģ�
	@RequestMapping(value = "/emp-save", method = RequestMethod.PUT)
	public String update(Employee employee) {
		employeeService.saveOrUpdate(employee);
		return "redirect:/emp-list";
	}

	// ��ʾ���е�Ա��
	@RequestMapping(value = "/emp-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("employees", employeeService.getAll());
		return "emp-list";
	}
}
