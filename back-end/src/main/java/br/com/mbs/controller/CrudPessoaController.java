package br.com.mbs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.api.CrudPessoaApi;
import br.com.mbs.model.Pessoa;

@RestController
public class CrudPessoaController 
	implements CrudPessoaApi{

	@Override
	public ResponseEntity<Void> atualizarPessoa(Pessoa body) {
		// TODO Auto-generated method stub
		return CrudPessoaApi.super.atualizarPessoa(body);
	}

	@Override
	public ResponseEntity<Pessoa> buscarPessoa(String id) {
		// TODO Auto-generated method stub
		return CrudPessoaApi.super.buscarPessoa(id);
	}

	@Override
	public ResponseEntity<Void> removerPessoa(String id) {
		// TODO Auto-generated method stub
		return CrudPessoaApi.super.removerPessoa(id);
	}

	@Override
	public ResponseEntity<Void> salvarPessoa(Pessoa body) {
		// TODO Auto-generated method stub
		return CrudPessoaApi.super.salvarPessoa(body);
	}

	
}
