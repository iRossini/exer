package com.luoxin.sssp.handler;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luoxin.sssp.service.OrderService;

@Controller
public class OrderController {

	// 获取OrderService
	private OrderService orderService;

	// 获取InputStream流
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// ===========下面是逻辑业务，上面是需要的参数===============================

	// 显示所有的订单
	@RequestMapping(value = "/order-list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("orders", orderService.getAll());
		return "order-list";
	}

	// 使用Ajax 删除一个仪器
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		try {
			orderService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "rederect:order-list";
	}

}
