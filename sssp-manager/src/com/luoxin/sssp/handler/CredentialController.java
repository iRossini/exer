package com.luoxin.sssp.handler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luoxin.sssp.service.CredentialService;
import com.luoxin.sssp.service.DepartmentService;

public class CredentialController {
	// ��ȡInstrumentService
	@Autowired
	private CredentialService credentialService;

	// ��ȡDepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	// ��ȡInputStream��
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// ===========�������߼�ҵ����������Ҫ�Ĳ���===============================

	// ��ʾ���е�֤��
	@RequestMapping(value = "/credential-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("credentials", credentialService.getAll());
		return "credential-list";
	}

	// ʹ��Ajax ɾ��һ��֤��
	@RequestMapping(value = "/credential/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			credentialService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "redirect:credential-list";
	}

}
