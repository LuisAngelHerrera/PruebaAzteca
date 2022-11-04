package com.acevedo.app.prueba.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.acevedo.app.prueba.models.Cliente;

@Component
public interface IClienteDao extends CrudRepository<Cliente, Long>{
	

}
