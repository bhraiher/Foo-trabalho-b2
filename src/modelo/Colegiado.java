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
public class Colegiado {
    private Curso curso;
    private List<Professor> professores = new ArrayList();
    
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void inserirProfessor(Professor professor){
        professores.add(professor);
    }
    
    public List recuperarProfessores(){
        return professores;
    }
}
