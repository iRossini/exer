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

import com.luoxin.sssp.entities.Department;
import com.luoxin.sssp.service.DepartmentService;

@Controller
public class DepartmentController {

	// ��ȡInputStream��
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// ��ȡDepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	@ModelAttribute
	public void getDepartment(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			Department department = departmentService.getDepartmentById(id);
			map.put("department", department);
		}
	}

	// ===========�������߼�ҵ����������Ҫ�Ĳ���===============================
	// ����һ������
	@RequestMapping(value = "/department-input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("department", new Department());
		return "department-input";
	}

	// ���������Ĳ���
	@RequestMapping(value = "/department-save", method = RequestMethod.POST)
	public String save(Department department) {
		departmentService.saveOrUpdate(department);
		return "redirect:/department-list";
	}

	// ��ʾ���еĲ���
	@RequestMapping(value = "/department-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		List<Department> list = departmentService.getAll();
		System.out.println(list.size());
		map.put("departments", list);
		return "department-list";
	}

	// ʹ��Ajax ɾ��һ������
	@RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			departmentService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:department-list";
	}

}
