package com.mbs.bff.comunicacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ClienteController", url = "http://localhost:9003/")
public interface ClienteService {

@RequestMapping(value = "/v1/cliente/existe-cliente/{id}",method = RequestMethod.GET)
public ResponseEntity<Boolean> existeCliente(@PathVariable Long id);
}
