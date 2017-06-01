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

import com.luoxin.sssp.entities.CusInstrument;
import com.luoxin.sssp.service.CusInstrumentService;
import com.luoxin.sssp.service.DepartmentService;

@Controller
public class CusInstrumentController {

	// 获取InstrumentService
	@Autowired
	private CusInstrumentService cusInstrumentService;

	// 获取DepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	// 获取InputStream流
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	@ModelAttribute
	public void getCusInstrument(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			CusInstrument cusInstrument = cusInstrumentService
					.getCusInstrumentById(id);
			map.put("cusInstruments", cusInstrument);
		}
	}

	// ===========下面是逻辑业务，上面是需要的参数===============================
	// 获取输入页面的数据并转发的输入页面
	@RequestMapping(value = "/cusInstrument-input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("cusInstruments", new CusInstrument());
		return "cusInstrument-input";
	}

	// 完成添加：
	@RequestMapping(value = "/cusInstrument", method = RequestMethod.POST)
	public String save(CusInstrument cusInstrument) {
		cusInstrumentService.saveOrUpdate(cusInstrument);
		return "redirect:/cusInstrument-list";
	}

	// 使用Ajax 删除一个仪器
	@RequestMapping(value = "/cusInstrument/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			cusInstrumentService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:/cusInstrument-list";
	}

	// 获取需要被修改仪器的信息
	@RequestMapping(value = "/cusInstrument/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("cusInstruments", cusInstrumentService.getCusInstrumentById(id));
		return "cusInstrument-edit";
	}

	// 完成修改：
	@RequestMapping(value = "/cusInstrument", method = RequestMethod.PUT)
	public String update(CusInstrument cusInstrument) {
		cusInstrumentService.saveOrUpdate(cusInstrument);
		return "redirect:/cusInstrument-list";
	}

	// 显示所有的仪器 OK
	@RequestMapping(value = "/cusInstrument-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		List<CusInstrument> list = cusInstrumentService.getAll();
		System.out.println(list.size());
		map.put("cusnstruments", list);
		return "cusInstrument-list";
	}

}
