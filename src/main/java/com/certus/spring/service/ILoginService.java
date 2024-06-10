package com.certus.spring.service;

import org.springframework.stereotype.Service;

import com.certus.spring.models.Login;

@Service
public interface ILoginService {
	
	public String obtenerUsuario(Login username);

}
