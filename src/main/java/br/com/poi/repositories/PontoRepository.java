/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poi.repositories;

import br.com.poi.entity.Ponto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Tadeu-PC
 */
public interface PontoRepository extends CrudRepository<Ponto, Integer> {   
}
