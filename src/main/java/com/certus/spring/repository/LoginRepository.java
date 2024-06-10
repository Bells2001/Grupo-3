package com.certus.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.Dao.ILoginDao;
import com.certus.spring.interfaces.ILoginRepository;
import com.certus.spring.models.Login;

@Repository
public class LoginRepository implements ILoginRepository{
	
	@Autowired
	private ILoginDao loginRepository;
	
	@Override
	public Login obtenerUsuario(String username) {
		
		return loginRepository.findByUsername(username);
	}
	//PREGUNTAR AL PROFE SOBRE EL PORCENTAJEEE DE PARTICIPACIÓN!!!
}
