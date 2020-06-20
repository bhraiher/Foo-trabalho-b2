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
 * @author bruni
 */
public class Curso {
    private String nomeCurso;
    private List<Disciplina> disciplinas = new ArrayList();

    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    
    public void inserirDisciplinas(Disciplina disciplina){
        disciplinas.add(disciplina);
    }
    
    public List recuperarDisciplinas(){
        return disciplinas;
    }
    
    
    
}
