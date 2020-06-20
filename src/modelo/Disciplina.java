/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author bruni
 */
public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
    public void setProfessor(Professor professor) {
        //1. Regra de negocio 1 de cadastro de disciplinas.
        Colegiado col = new Colegiado();
        if(professor.equals(col.recuperarProfessores()) ){
            this.professor = professor;
        }else{
            System.out.println("Impossivel cadastrar! Professor não cadastrado no colegiado.");
        }
    
    }
    public Professor getProfessor() {
        return professor;
    }   
    
    
}
