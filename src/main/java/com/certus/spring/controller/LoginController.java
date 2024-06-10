package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Login;
import com.certus.spring.service.ILoginService;

@Controller
@RequestMapping("/Auth")
public class LoginController {
	
	@Autowired
	private ILoginService _loginService;
	
	@GetMapping("/Initial")
	public String login(Model model) {
		
		Login username = new Login();
		
		model.addAttribute("username",username);
		
		return "Administrador/login";
	}
	
	
	@PostMapping("/Auth")
	public String Auth(Login username, Model model) {
		
		Login userNew = new Login();
		
		model.addAttribute("username",userNew);
		
		return _loginService.obtenerUsuario(username);
	}
}
