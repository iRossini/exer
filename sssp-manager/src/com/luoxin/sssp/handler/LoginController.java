package com.luoxin.sssp.handler;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	// -------------------------------
	public String login() {
		System.out.println("��¼�ɹ�");

		return "login";
	}

	public String logout() {

		System.out.println("�˳��ɹ�");
		return "logout";
	}

}
