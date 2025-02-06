package com.mbs.enderecomvc.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mbs.enderecomvc.entidades.Endereco;


@Controller
public class EnderecoControllerMVC {

	private List<Endereco> listaEndereco = new ArrayList<Endereco>();
	private static int id = 0;
	
	@GetMapping("/inicio_cadastrar")
	public String inicio( Model model) {
		model.addAttribute("endereco", new Endereco());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvar(@ModelAttribute Endereco endereco,Model model) {
		endereco.setCodigo(++id);
		listaEndereco.add(endereco); // adiciona na lista.
		System.out.println("cadastrado endereco: " + endereco.getRua());
		model.addAttribute("lista_endereco",listaEndereco); // adiciona na request para a view pegar.
		return "resultado";
	}
	
	// CONTINUAR AS IMPLEMENTACOES
}
