/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skyress
 */
public class Colegiado{
    //Variáveis
    private Curso curso;
    private List<Professor> professores = new ArrayList();


    //Inserir professor
    public void inserirProfessor(Professor professor){
        professores.add(professor);
    }


    //Listra de Professores
    public List<Professor> recuperarProfessores(){
        return professores;
    }


    //Getters e Setters
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
