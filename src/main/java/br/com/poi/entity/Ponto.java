/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tadeu-PC
 */
@Entity
@Table(name="ponto")
public class Ponto implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message="Informe o atributo nome")
    private String nome;
    @NotNull(message="Informe o atributo coordenadaX")
    @Min(value=0, message="Informe um número inteiro não negativo para o atributo coordenadaX")
    @Column(name="coordenada_x")
    private int coordenadaX;
    @NotNull(message="Informe o atributo coordenadaX")
    @Min(value=0, message="Informe um número inteiro não negativo para o atributo coordenadaY")
    @Column(name="coordenada_y")
    private int coordenadaY;

    public Ponto() {
    	
    }
    
    public Ponto(String nome, int coordenadaX, int coordenadaY) {
    	this.nome=nome;
    	this.coordenadaX=coordenadaX;
    	this.coordenadaY=coordenadaY;
	}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponto)) {
            return false;
        }
        Ponto other = (Ponto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.poi.entity.Ponto[ id=" + id + ", nome="+nome+", coordenaX="+coordenadaX+", coordenadaY="+coordenadaY+" ]";
    }
    
}
