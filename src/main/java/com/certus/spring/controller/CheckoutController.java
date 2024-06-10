package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.CheckOut;
import com.certus.spring.service.ICheckOutService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/pangea")
public class CheckoutController{
	
	@Autowired
	private ICheckOutService checkOutService;

	@GetMapping("/checkout")
	public String checkout(Model model) {
		CheckOut numTarjeta = new CheckOut();
		
		model.addAttribute("numTarjeta",numTarjeta);
		
		return "checkout";
	}
	
	@PostMapping("/tarjeta")
	public String registroTarjeta(CheckOut numTarjeta, Model model) {
		
		CheckOut newTarjeta = new CheckOut();
		
		model.addAttribute("numTarjeta",newTarjeta);
		
		return checkOutService.obtenerTarjeta(numTarjeta);
	}	
}
