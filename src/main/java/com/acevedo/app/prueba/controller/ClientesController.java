package com.acevedo.app.prueba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.acevedo.app.prueba.models.Cliente;
import com.acevedo.app.prueba.service.IClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	@Autowired
	private IClientesService clientesService;
	
	@GetMapping(value="/api/listadoClientes",
			produces = {"application/json"})
	//api para devolver la lista de cliente
	public @ResponseBody Map<String, List<Cliente>> apiListar() throws InterruptedException{
		Map<String, List<Cliente>> map= new HashMap<String, List<Cliente>>();
		map.put("data", clientesService.getAll());
		return map;
	}
	
	@GetMapping(value="/listar")
	public String listar(Model model) throws InterruptedException{ 
		List<Cliente> clientes = clientesService.getAll();
		//atravez del objeto model le pasamos la lista de clientes a la vista
		return "Cliente/index";
	} 
	
	@GetMapping(value="/create")
	public String create(Model model) {
		//creamos el objeto con el que vamos a trabajar en la vista
		Cliente cliente = new Cliente();
		//pasamos el objeto cliente a la vista
		model.addAttribute("cliente", cliente);
		return "Cliente/create";
	}
	
	@PostMapping(value="/insert")
	public String insert(@Valid @ModelAttribute("cliente")
	Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return "Cliente/create";
		}
		clientesService.save(cliente);
		return "redirect:/cliente/listar";
	}
	
	@DeleteMapping(value="/api/delete/{id}", produces= {"application/json"})
	public @ResponseBody Map<String, String> apiDelete(@PathVariable(value="id") Long id, Model model) {
		clientesService.delete(id);
		Map<String, String> resultados= new HashMap<String, String>();
		resultados.put("success", "true");
		resultados.put("message", "Cliente Borrada Correctamente");
		return resultados;
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable(value="id") Long id, Model model) {
		Cliente cliente = null;
		if(id>0) {
			//recuperamos el objeto cliente que queremos editar
			cliente = clientesService.getById(id);
			if(cliente==null) {
				return "redirect:/clientes/listarAsync";
			}
		}
		else {
			return "redirect:/clientes/listarAsync";
		}
		//le pasamos el objeto a la vista
		model.addAttribute("cliente", cliente);
		return "Clientes/create";
	}
}
