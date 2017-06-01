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

import com.luoxin.sssp.entities.Instrument;
import com.luoxin.sssp.service.DepartmentService;
import com.luoxin.sssp.service.InstrumentService;

@Controller
public class InstrumentController {

	// ��ȡInstrumentService
	@Autowired
	private InstrumentService instrumentService;

	// ��ȡDepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	// ��ȡInputStream��
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	@ModelAttribute
	public void getInstrument(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			Instrument instrument = instrumentService.getInstrumentById(id);
			map.put("instrument", instrument);
		}
	}

	// ===========�������߼�ҵ����������Ҫ�Ĳ���===============================
	// ��ȡ����ҳ������ݲ�ת��������ҳ��
	@RequestMapping(value = "/instrument-input", method = RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("instrument", new Instrument());
		return "instrument-input";
	}

	// �����ӣ�
	@RequestMapping(value = "/instrument", method = RequestMethod.POST)
	public String save(Instrument instrument) {
		instrumentService.saveOrUpdate(instrument);
		return "redirect:/instrument-list";
	}

	// ʹ��Ajax ɾ��һ������
	@RequestMapping(value = "/instrument/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			instrumentService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:/instrument-list";
	}

	// ��ȡ��Ҫ���޸���������Ϣ
	@RequestMapping(value = "/instrument/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("departments", departmentService.getAll());
		map.put("instrument", instrumentService.getInstrumentById(id));
		return "instrument-edit";
	}

	// ����޸ģ�
	@RequestMapping(value = "/instrument", method = RequestMethod.PUT)
	public String update(Instrument instrument) {
		instrumentService.saveOrUpdate(instrument);
		return "redirect:/instrument-list";
	}

	// ��ʾ���е����� OK
	@RequestMapping(value = "/instrument-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		List<Instrument> list = instrumentService.getAll();
		System.out.println(list.size());
		map.put("instruments", list);
		return "instrument-list";
	}

}
