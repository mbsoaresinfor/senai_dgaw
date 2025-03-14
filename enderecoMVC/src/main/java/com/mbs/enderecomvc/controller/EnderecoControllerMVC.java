package com.mbs.enderecomvc.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbs.enderecomvc.entidades.Endereco;


@Controller
public class EnderecoControllerMVC {

	private List<Endereco> listaEndereco = new ArrayList<Endereco>();
	private static int id = 0;
	
	@GetMapping("/inicio_cadastrar")
	public String inicio( Model model) {
		model.addAttribute("endereco", 
				new Endereco());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvar(
			@ModelAttribute 
			Endereco endereco,
			Model model) {
		if(endereco.getRua().trim().length() <=3 ) {
			model.addAttribute("erro",
					"Valor  invalido para campo rua");			
			return "cadastrar";
		}
		if(endereco.getCep()
				.trim().contains("-")) {
			model.addAttribute("erro",
					"Cep invalido, não digite o caracter '-'");			
			return "cadastrar";
		}
		
		endereco.setCodigo(++id);
		listaEndereco.add(endereco); // adiciona na lista.
		System.out.println("cadastrado endereco: " + endereco.getRua());
		model.addAttribute("lista_endereco",listaEndereco); // adiciona na request para a view pegar.
		return "resultado";
	}
	
	@GetMapping("/deletar")
	public String deletar(@RequestParam String id,
			Model model) {
		System.out.println("Deletar: ID = " + id);
		listaEndereco.removeIf((obj)-> 
					obj.getCodigo()
					.equals(Integer.parseInt(id)));
		model.addAttribute("lista_endereco",listaEndereco); // adiciona na request para a view pegar.
		return "resultado";
	}
	
	@GetMapping("/inicio_buscar")
	public String inicioBuscar( Model model) {
		model.addAttribute("endereco", 
				new Endereco());
		return "buscar";
	}
	
	@GetMapping(path="/buscar")
	public String buscar(
			@ModelAttribute 
			Endereco endereco,
			Model model) {
		System.out.println("Buscar");
		StringBuilder resultado = new StringBuilder();
		
		for (Endereco end : listaEndereco) {
			if(end.getCodigo()
					.equals(endereco.getCodigo())) {
				resultado
				.append("cod:")
				.append(end.getCodigo())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");				
			}else if(end.getCep()
					.equals(endereco.getCep())) {
				resultado
				.append("cep:")
				.append(end.getCep())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");
			}
		}
		if(resultado.isEmpty()) {
			resultado.append("NÃO FOI POSSIVEL "
					+ "LOCALIZAR NENHUM ENDERECO");
		}
		model.addAttribute("resultado", 
				resultado.toString());
		return "buscar";
	}
	
	
	// CONTINUAR AS IMPLEMENTACOES
}
