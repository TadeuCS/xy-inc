package br.com.poi.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PontoEspecifico{
	
	@NotNull(message = "Informe o atributo distancia")
	@Min(value = 0, message = "Informe um número inteiro não negativo para o atributo distancia")
	private Integer distancia;
	@NotNull(message="Informe o atributo coordenadaX")
    @Min(value = 0, message = "Informe um número inteiro não negativo para o atributo coordenadaX")
	private Integer coordenadaX;
	@NotNull(message="Informe o atributo coordenadaY")
    @Min(value = 0, message = "Informe um número inteiro não negativo para o atributo coordenadaY")
	private Integer coordenadaY;
	
	public PontoEspecifico() {
		
	}
	
	public PontoEspecifico(int coordenadaX, int coordenadaY, int distancia) {
		this.coordenadaX=coordenadaX;
		this.coordenadaY=coordenadaY;
		this.distancia=distancia;
	}
	
	public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    public Integer getDistancia() {
		return distancia;
	}
    public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
}
