package co.edu.uco.pch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadController {
	
	@GetMapping
	public String saludar() {
		return "Hola mundo!!!!!!!";
	}

}
