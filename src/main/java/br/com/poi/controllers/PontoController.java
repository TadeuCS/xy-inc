/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poi.controllers;

import br.com.poi.entity.Ponto;
import br.com.poi.pojo.PontoEspecifico;
import br.com.poi.services.PontoService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tadeu-PC
 */
@Controller
@RequestMapping(path = "/api/poi")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @PostMapping(path = "inserir/")
    public ResponseEntity<@Valid Ponto> cadastrarPOI(@Valid @RequestBody Ponto ponto, BindingResult snapshot) {
    	if(snapshot.hasErrors()) {
    		return ResponseEntity.badRequest().body(
    				snapshot.getAllErrors().stream().map(e->e.getDefaultMessage()));
    	}
    	return ResponseEntity.ok(pontoService.inserir(ponto));
    }
    
    @PostMapping(path = "listar/proximos/")
    public ResponseEntity<List<Ponto>> listarPorDistancia(@Valid @RequestBody PontoEspecifico pontoEspecifico, BindingResult snapshot) {
    	if(snapshot.hasErrors()) {
    		return ResponseEntity.badRequest().body(
    				snapshot.getAllErrors().stream().map(e->e.getDefaultMessage()));
    	}
        return ResponseEntity.ok(pontoService.listarProximos(pontoEspecifico));
    }

    @GetMapping(path = "listar/")
    public ResponseEntity<List<Ponto>> listarTodosPOIs() {
        return ResponseEntity.ok(pontoService.listarTodos());
    }
}
