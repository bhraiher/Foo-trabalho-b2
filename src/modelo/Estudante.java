/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

public class Estudante extends Pessoa{
    //Variáveis
    private String RA;
    private int Periodo;
    private Curso curso;


    //Construtor Padrão
    public Estudante(){
    }


    //Construtor geral
    public Estudante(String RA, int Periodo, Curso curso, String nome, String CPF, Date dtNascimento){
        super(nome, CPF, dtNascimento);
        this.RA = RA;
        this.Periodo = Periodo;
        this.curso = curso;
    } 


    //Getters e Setters
    public String getRA(){
        return RA;
    }
    public void setRA(String RA){
        this.RA = RA;
    }

    public int getPeriodo(){
        return Periodo;
    }
    public void setPeriodo(int Periodo){
        this.Periodo = Periodo;
    }

    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
