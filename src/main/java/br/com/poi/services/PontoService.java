package br.com.poi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poi.entity.Ponto;
import br.com.poi.pojo.PontoEspecifico;
import br.com.poi.repositories.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private PontoRepository pontoRepository;
	
	public Ponto inserir(Ponto ponto) {
		return pontoRepository.save(ponto);
	}
	
	public List<Ponto> listarTodos(){
		return (List<Ponto>) pontoRepository.findAll();
	}
	
	public List<Ponto> listarProximos(PontoEspecifico pontoEspecifico){
		return listarTodos().stream()
				.filter(p->calculaPontoProximo(pontoEspecifico, p.getCoordenadaX(), p.getCoordenadaY()))
				.collect(Collectors.toList());
	}
	
	public void removeTodosPontos() {
		pontoRepository.deleteAll();
	}
	
	public boolean calculaPontoProximo(PontoEspecifico origem, int posX, int posY) {
        int distanciaCalculada = (int) Math.sqrt((Math.pow((origem.getCoordenadaX()-posX), 2)
                + Math.pow((origem.getCoordenadaY() - posY), 2)));
        return distanciaCalculada <= origem.getDistancia();
    }
}
