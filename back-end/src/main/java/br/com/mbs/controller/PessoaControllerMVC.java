package br.com.mbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.mbs.modelos.Pessoa;


@Controller
public class PessoaControllerMVC {

	// exemplo de mvc
	  
	private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
   
   @GetMapping("/tela-cadastrar-pessoa")
   public String telaCadastroPessoa(Model model) {
       model.addAttribute("pessoa", new Pessoa());
       return "tela-cadastrar-pessoa";
   }
   
   @PostMapping("/processa-cadastrar-pessoa")
   public String processaCadastrarPessoa(@ModelAttribute("pessoa") Pessoa pessoa, Model model) {
	   listaPessoa.add(pessoa);
	   model.addAttribute("listaPessoa", listaPessoa);      
      return "listar-pessoa";
   }
   
}
