package com.mbs.apigw.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.apigw.entidades.Cliente;

 

@FeignClient(value = "ClienteService",
url = "http://localhost:9003/")
public interface ClienteServiceRoteamento {

	@RequestMapping(value = "/v1/cliente/existe_cliente/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<Boolean> 
	existeCliente(@PathVariable Integer id);

	@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
	public ResponseEntity<String> salvar(@RequestBody Cliente cliente);
	
	@RequestMapping(value = "/v1/cliente",method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar();
	
	@RequestMapping(value = "/v1/cliente/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) ;
	
}
