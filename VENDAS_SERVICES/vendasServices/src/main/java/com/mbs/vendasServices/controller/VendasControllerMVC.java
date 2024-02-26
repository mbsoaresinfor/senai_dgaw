package com.mbs.vendasServices.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mbs.vendasServices.entidades.Venda;


@Controller
public class VendasControllerMVC {

	
	@GetMapping("/inicio_cadastrar")
	public String greeting( Model model) {
		model.addAttribute("venda", new Venda());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvarVenda(@ModelAttribute Venda venda,Model model) {		
		System.out.println(venda.getNomeProduto());
		return "resultado";
	}
}
