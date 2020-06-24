/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Aula{
    //Variáveis
    private String lab;
    private Date dataHora;
    private Disciplina disciplina;
    private Map<String,Estudante> alunosAula = new HashMap<>();


    //Construtor Padrão
    public void addAluno(Estudante aluno){
    }


    //Get Lista Alunos
    public Map<String,Estudante> getListaAlunos(){
        Map<String,Estudante> mapEstudante = new HashMap<>();
        Estudante aluno = new Estudante();
        return mapEstudante;
    }


    //Get Aluno
    public Estudante getAluno(String RA){
        Estudante aluno = new Estudante();
        return aluno;
    }


    //Getters e Setters
    public String getLab(){
        return lab;
    }
    public void setLab(String lab){
        this.lab = lab;
    }

    public Date getDataHora(){
        return dataHora;
    }
    public void setDataHora(Date dataHora){
        this.dataHora = dataHora;
    }
}
