/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 * Classe pronta. 
 */
public class Professor extends Pessoa {
    private String nRegistro;
    private String titulacao;
    private float horasSemanais;
    private double precoHora;
    
    //Construtor vazio
    public Professor(){    
    }
    //Construtor geral
    public Professor(String nRegistro, String titulacao, float horasSemanais, double precoHora, String nome, String CPF, Date dtNascimento){
        super(nome, CPF, dtNascimento);
        this.nRegistro = nRegistro;
        this.titulacao = titulacao;
        this.horasSemanais = horasSemanais;
        this.precoHora = precoHora;
    }

    public String getNRegistro() {
        return nRegistro;
    }
    public void setNRegistro(String nRegistro) {
        this.nRegistro = nRegistro;
    }

    
    public String getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    
    public float getHorasSemanais() {
        return horasSemanais;
    }
    public void setHorasSemanais(float horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    
    public double getPrecoHora() {
        return precoHora;
    }
    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }
    
    
    
}
