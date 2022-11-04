package com.acevedo.app.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acevedo.app.prueba.Dao.IClienteDao;
import com.acevedo.app.prueba.models.Cliente;

@Component
public class ClientesService implements IClientesService{
	@Autowired
	IClienteDao clienteDao;

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.save(cliente);
	}

	@Override
	public Cliente getById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}
}
