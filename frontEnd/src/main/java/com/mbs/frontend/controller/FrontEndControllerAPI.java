package com.mbs.frontend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontEndControllerAPI {


   @GetMapping("/cliente")
	public String cliente( Model model) {		
		return "cliente";
	}
   
   @GetMapping("/vendas")
	public String venda( Model model) {		
		return "vendas";
	}
   
}