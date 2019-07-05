package br.com.poi.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.poi.entity.Ponto;
import br.com.poi.pojo.PontoEspecifico;
import br.com.poi.services.PontoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PontoServiceTest {
	
	@Autowired
	private PontoService pontoService;
	private List<Ponto> pontos;
	
	
	@Before
	public void beforeTests() throws Exception {
		pontoService.removeTodosPontos();
		pontos=new ArrayList<>();
		pontos.add(pontoService.inserir(new Ponto("Lanchonete", 27, 12)));
		pontos.add(pontoService.inserir(new Ponto("Posto", 31, 18)));
		pontos.add(pontoService.inserir(new Ponto("Joalheria", 15, 12)));
		pontos.add(pontoService.inserir(new Ponto("Floricultura", 19, 21)));
		pontos.add(pontoService.inserir(new Ponto("Pub", 12, 8)));
		pontos.add(pontoService.inserir(new Ponto("Supermercado", 23, 6)));
		pontos.add(pontoService.inserir(new Ponto("Churrascaria", 28, 2)));
    }
	
	@After
	public void afterTests() throws Exception {
    	pontoService.removeTodosPontos();
    }
	
	@Test
	public void inserirTestReturnObject() {
		String nome="Pizzaria";
		int coordenadaX=35;
		int coordenadaY=26;
		Ponto pontoSalvo = pontoService.inserir(new Ponto(nome, coordenadaX, coordenadaY));
		assertThat(pontoSalvo.getId()).isNotNull();
		assertThat(pontoSalvo.getNome()).isEqualTo(nome);
		assertThat(pontoSalvo.getCoordenadaX()).isEqualTo(coordenadaX);
		assertThat(pontoSalvo.getCoordenadaY()).isEqualTo(coordenadaY);
	}
	
	@Test
	public void listarTodosTestObjectsReturned() {
		List<Ponto> pontosRetornados = pontoService.listarTodos();
		assertNotNull(pontosRetornados);
		assertFalse(pontosRetornados.isEmpty());
		assertThat(pontosRetornados.size()).isEqualTo(7);
		assertThat(pontosRetornados).containsAll(pontos);
	}
	
	@Test
	public void listarProximosTestObjectsReturned() {
		PontoEspecifico pontoOrigem = new PontoEspecifico(20, 10, 10);
		List<Ponto> pontosRetornados = pontoService.listarProximos(pontoOrigem);
		assertNotNull(pontosRetornados);
		assertFalse(pontosRetornados.isEmpty());
		assertThat(pontosRetornados.size()).isEqualTo(4);
		List<String> nomeDosPontos = pontosRetornados.stream().map(p->p.getNome()).collect(Collectors.toList());
		assertThat(nomeDosPontos).contains("Supermercado","Joalheria", "Lanchonete","Pub");
	}
}
