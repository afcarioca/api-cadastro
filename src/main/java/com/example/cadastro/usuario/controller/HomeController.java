package com.example.cadastro.usuario.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HomeController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("home")
	public String home() {
		return "Hello, World!";
	}
}
