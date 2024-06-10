package com.certus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certus.spring.interfaces.ILoginRepository;
import com.certus.spring.models.Login;

@Service
public class LoginService implements ILoginService{
	
	@Autowired
	public ILoginRepository _loginRepository;
	
	@Override
	public String obtenerUsuario(Login username) {
		
		String responseView = "Administrador/login";
		
		Login _login = _loginRepository.obtenerUsuario(username.getUsername());
		
		if (_login !=null) {
			if (username.getPassword().equals(_login.getPassword())) {
				responseView = "/Administrador/dashboard";
			}
		}else {
			return responseView;
		}
		
		return responseView;
	}
}
