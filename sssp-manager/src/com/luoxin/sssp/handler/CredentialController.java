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
	// 获取InstrumentService
	@Autowired
	private CredentialService credentialService;

	// 获取DepartmentSerive
	@Autowired
	private DepartmentService departmentService;

	// 获取InputStream流
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// ===========下面是逻辑业务，上面是需要的参数===============================

	// 显示所有的证书
	@RequestMapping(value = "/credential-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("credentials", credentialService.getAll());
		return "credential-list";
	}

	// 使用Ajax 删除一个证书
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
