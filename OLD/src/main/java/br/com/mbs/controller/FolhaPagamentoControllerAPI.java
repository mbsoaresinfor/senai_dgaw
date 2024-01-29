package br.com.mbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.modelos.Pessoa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@Api(value="Api de folha de pagamento")
public class FolhaPagamentoControllerAPI {

	HashMap<Integer,Pessoa> mapaPessoa = new HashMap<>();
	
	public FolhaPagamentoControllerAPI() {
		Pessoa p1 = new Pessoa();
		p1.setId("1");
		p1.setSalario(200f);
		
		Pessoa p2 = new Pessoa();
		p2.setId("2");
		p2.setSalario(300f);
		
		mapaPessoa.put(1, p1);
		mapaPessoa.put(2, p2);
		
	}
	
	
	@ApiOperation(value="busca o salario de uma pessoa")
	@ApiResponses(value= {
			@ApiResponse(code = 200 , message = "sucesso ao buscar o salario"),
			@ApiResponse(code = 404 , message = "deu erro, nao encontrou  nada")
	})
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/{id}", 
			method = RequestMethod.GET)	 
	public ResponseEntity<Float> buscarSalarioPessoa(@PathVariable Integer id){		 
		Pessoa pessoa = mapaPessoa.getOrDefault(id, new Pessoa());
		if(pessoa == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Float salario = pessoa.getSalario();
		
		return ResponseEntity.ok(salario);
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/", 
			method = RequestMethod.GET)	 
	public ResponseEntity<List<Float>> buscarSalariosPessoa(){		 
		 
//		List<Float> listaSalario = mapaPessoa
//								  .values()
//								  .stream()
//								  .map(pessoa -> pessoa.getSalario())
//								  .toList();
		
		//return ResponseEntity.ok(listaSalario);
		return null;
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/", 
			method = RequestMethod.POST)	 
	public ResponseEntity<Integer>
			salvarPessoa(@RequestBody Pessoa pessoa){		 
		 
		mapaPessoa.put(Integer.parseInt(pessoa.getId()), pessoa);
		
		return ResponseEntity.ok(Integer.parseInt(pessoa.getId()));
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/{id}", 
			method = RequestMethod.DELETE)	 
	public ResponseEntity<String> removerSalarioPessoa(@PathVariable Integer id){		 
		mapaPessoa.remove(id);		
		return ResponseEntity.ok("sucesso :)");
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/", 
			method = RequestMethod.PUT)	 
	public ResponseEntity<Integer>
			alterarPessoa(@RequestBody Pessoa pessoa){		 
		 
		mapaPessoa.put(Integer.parseInt(pessoa.getId()), pessoa);
		
		return ResponseEntity.ok(Integer.parseInt(pessoa.getId()));
	}
	
}
