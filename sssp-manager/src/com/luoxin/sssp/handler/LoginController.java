package com.luoxin.sssp.handler;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	// -------------------------------
	public String login() {
		System.out.println("登录成功");

		return "login";
	}

	public String logout() {

		System.out.println("退出成功");
		return "logout";
	}

}
