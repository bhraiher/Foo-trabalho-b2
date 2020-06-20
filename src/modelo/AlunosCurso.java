/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Map;

/**
 *
 * @author bruni
 */
public class AlunosCurso {
    private Curso curso;
    private Map<String, Estudante> alunosCurso;

    public Map<String, Estudante> getAlunosCurso() {
        return alunosCurso;
    }
    public void setAlunosCurso(Map<String, Estudante> alunosCurso) {
        this.alunosCurso = alunosCurso;
    }
    
    
    public void inserirAluno(Estudante estudante){
        alunosCurso.put(estudante.getRA(), estudante); 
    }
    
    /*public Map<String,Estudante> recuperarListaAlunos(){
        return Map<RA,alunosCurso>;
    }*/
    
   public Estudante recuperarAluno(String RA){
        return alunosCurso.get(RA);
    }
    
    
}
