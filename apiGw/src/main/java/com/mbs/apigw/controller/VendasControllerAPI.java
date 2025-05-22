package com.mbs.apigw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.apigw.comunicacao.ClienteServiceRoteamento;
import com.mbs.apigw.comunicacao.VendasServiceRoteamento;
import com.mbs.apigw.entidades.Cliente;
import com.mbs.apigw.entidades.Venda;

@RestController
public class VendasControllerAPI {

	@Autowired
	private ClienteServiceRoteamento 
			clienteServiceRoteamento;
	
	@Autowired
	private VendasServiceRoteamento 
			vendasServiceRoteamento;
	
	@RequestMapping(value = "/v1/processarVenda",
			method = RequestMethod.POST)
	public ResponseEntity<String> 
			processarVenda(@RequestBody Venda venda){
		System.out.println("processando venda");
		ResponseEntity<Boolean> existeCliente = 
					clienteServiceRoteamento
			.existeCliente(venda.getCodCliente());
		if(existeCliente.getBody().equals(false)) {
			// cliente não existe.
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("cliente não existe");
		}

		// chegando aqui, eu tenho um cliente.
		ResponseEntity<String> resultadoVenda =
				vendasServiceRoteamento.salvar(venda);
		if(resultadoVenda.getStatusCode() 
				!= HttpStatus.OK) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body("Não foi possível realizar a venda");
		}
		
		// TODO aqui, eu devo enviar uma mensagem para
		// servidor de mensageria( vamos fazer nas
		// proximas AULAS.
		System.out.println("mockando envia de "
				+ "mensagem para o servidor de mensageria..");
		
		// retorno o id da venda realizada no body.
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(resultadoVenda.getBody());
		
	}
}
