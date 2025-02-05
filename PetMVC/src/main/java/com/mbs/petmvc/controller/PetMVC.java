package com.mbs.petmvc.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mbs.petmvc.entidades.Pet;


@Controller
public class PetMVC {

	private List<Pet> listaPet = new ArrayList<Pet>();
	private static int id = 0;
	
	@GetMapping("/inicio_cadastrar")
	public String inicio( Model model) {
		model.addAttribute("pet", new Pet());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvar(@ModelAttribute Pet pet,Model model) {
		pet.setCodPet(++id);
		listaPet.add(pet); // adiciona na lista.
		System.out.println("cadastrado pet: " + pet.getNome());
		model.addAttribute("lista_pet",listaPet); // adiciona na request para a view pegar.
		return "resultado";
	}
}
