package com.acevedo.app.prueba.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ55")
	@SequenceGenerator(sequenceName = "customer_seq55", allocationSize = 1, name= "CUST_SEQ55")
	private Long id;
	
	@Column(name="nombre")
	@NotEmpty()
	@Size(max=60)
	private String nombre;
	
	@Column(name="FNacimiento")
	private LocalDate fechaNacimiento;
	
	@Pattern(regexp="^[0-9]{10}", message="El numero de telefono no debe superar a los 10 digitos")
	@Column(name="celular")
	private String celular;
	
	private Integer edad;
	
	@Column(name="correo")
	@Email(message="Correo es requerido")
	private String correo;

	public Cliente() {
		super();
	}

	

	public Cliente(Long id, @NotEmpty @Size(max = 60) String nombre, LocalDate fechaNacimiento,
			@Size(max = 10) @Size(min = 10) String celular, Integer edad,
			@Email(message = "Correo es requerido") String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.edad = edad;
		this.correo = correo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento; 
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	

	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
