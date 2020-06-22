/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skyress
 */
public class Curso{
    //Variáveis
    private String nomeCurso;
    private List<Disciplina> disciplinas = new ArrayList();


    //Inserir disciplina
    public void inserirDisciplinas(Disciplina disciplina){
        disciplinas.add(disciplina);
    }


    //Recuperar Disciplina
    public List<Disciplina> recuperarDisciplinas(){
        return disciplinas;
    }


    //Getters e Setters
    public String getNomeCurso(){
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
}
