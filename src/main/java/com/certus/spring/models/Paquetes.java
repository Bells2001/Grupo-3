package com.certus.spring.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paquetes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaquete;
	private String titulo;
	private String descripcion;
	private int cantPersonas;
	private int duracionDias;
	private int duracionNoches;
	private String categoria;
	private double precioOferta;
	private double precioRegular;
	private double descuento;
	private int dia;
	private String mes;
	private int anio;
	private String ubicacion;
}
