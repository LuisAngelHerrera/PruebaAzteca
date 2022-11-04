package com.acevedo.app.prueba.service;

import java.util.List;

import com.acevedo.app.prueba.models.Cliente;

public interface IClientesService {
	public List<Cliente> getAll();
	public void save(Cliente cliente);
	public Cliente getById(Long id);
	public void delete(Long id);
}
