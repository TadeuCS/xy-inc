package br.com.poi.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.poi.entity.Ponto;
import br.com.poi.pojo.PontoEspecifico;
import br.com.poi.services.PontoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PontoControllerTest {
	
	@MockBean
	private PontoService pontoService;
	
	@InjectMocks
	private PontoController pontoController;
	
	private MockMvc mockMvc;
	
	@Before
	public void beforeTests() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pontoController).build();
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Test
	public void cadastrarPOITestReturnOk() throws Exception {
		Ponto ponto = new Ponto("Escola", 17, 8);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/inserir/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isOk());
	}
	
	@Test
	public void cadastrarPOITestNoParametersReturnBadRequest() throws Exception {
		Ponto ponto = null;
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/inserir/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void cadastrarPOITestNameInvalidReturnBadRequest() throws Exception {
		Ponto ponto = new Ponto(null, 15, 10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/inserir/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void cadastrarPOITestCoordenadaXInvalidReturnBadRequest() throws Exception {
		Ponto ponto = new Ponto("Açougue", -12, 10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/inserir/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void cadastrarPOITestCoordenadaYInvalidReturnBadRequest() throws Exception {
		Ponto ponto = new Ponto("Açougue", 10, -7);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/inserir/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void listarPorDistanciaTestReturnOK() throws Exception {
		PontoEspecifico ponto = new PontoEspecifico(20, 10, 10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/listar/proximos/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andReturn();
	}
	
	

	@Test
	public void listarPorDistanciaTestInvalidParametersReturnBadRequest() throws Exception {
		PontoEspecifico ponto = null;
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/listar/proximos/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void listarPorDistanciaTestCoordenadaXInvalidReturnBadRequest() throws Exception {
		PontoEspecifico ponto = new PontoEspecifico(-10,15,10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/listar/proximos/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void listarPorDistanciaTestCoordenadaYInvalidReturnBadRequest() throws Exception {
		PontoEspecifico ponto = new PontoEspecifico(10,-13,10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/listar/proximos/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void listarPorDistanciaTestDistanciaInvalidReturnBadRequest() throws Exception {
		PontoEspecifico ponto = new PontoEspecifico(10,13,-10);
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/api/poi/listar/proximos/")
				.content(asJsonString(ponto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isBadRequest())
		.andReturn();
	}
	
	@Test
	public void listarTestReturnOk() throws Exception {
		List<Ponto> pontos = new ArrayList<Ponto>();
		when(pontoService.listarTodos()).thenReturn(pontos);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/poi/listar/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().json("[]"))
		.andReturn();
	}

}
