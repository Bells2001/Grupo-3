package com.certus.spring.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.certus.spring.models.Login;


@Repository
public interface ILoginDao extends CrudRepository<Login, Integer>{

	Login findByUsername(String username);
}
