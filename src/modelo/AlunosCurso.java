/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

public class AlunosCurso{
    //Variáveis
    private Curso curso;
    private Map<String,Estudante> alunosCurso = new HashMap<>();


    //Iserir aluno
    public void inserirAluno(Estudante estudante){
        alunosCurso.put(estudante.getRA(), estudante); 
    }


    //Recuperar Aluno
    public Estudante recuperarAluno(String RA){
        return alunosCurso.get(RA);
    }


    //Recuperar Lista Alunos
    public Map<String,Estudante> recuperarListaAlunos(){
        return alunosCurso;
    }


    //Getters e Setters
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
