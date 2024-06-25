package com.mbs.bff.comunicacao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mbs.bff.entidades.Cliente;



@FeignClient(value = "ClienteController", url = "http://localhost:9003/")
public interface ClienteService {

@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
public ResponseEntity<Boolean> existeCliente(@PathVariable Long id);

@RequestMapping(value = "/v1/cliente",method = RequestMethod.POST)
public ResponseEntity<Long> salvar(@RequestBody Cliente cliente);

@RequestMapping(value = "/v1/cliente/buscarPelonome/{nome}",method = RequestMethod.GET)
public ResponseEntity<List<Cliente>> buscarPeloNome(@PathVariable String nome);

}