package com.certus.spring.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Login;

@Repository
public interface ILoginRepository {

	@Autowired
	Login obtenerUsuario(String username);
}
