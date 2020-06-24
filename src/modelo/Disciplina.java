/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Disciplina{
    //Variáveis
    private String nome;
    private int cargaHoraria;
    private Professor professor;


//Getters e Setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor(){
        return professor;
    }
    public void setProfessor(Professor professor){
        //Regra de negocio 1 de cadastro de disciplinas
        this.professor = professor;
    }
    
        //Regra de negócio 01
    /*Para cadastrar um professor para a disciplina, o professor deve pertencer ao colegiado*/
    public void validaProfessor(String nome, int cargaHoraria, Professor professor){
        Colegiado colegiado = new Colegiado();
        if(colegiado.recuperarProfessores().contains(professor)){
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setProfessor(professor);
        }else{
            System.out.println("Falha no cadastro, Professor deve pertencer ao colegiado antes");
        }
    }
}
