/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;


public class Aula {
    private String lab;
    private Date dataHora;
    private Disciplina disciplina;
    private Map<String,Estudante> alunosAula;

    public String getLab() {
        return lab;
    }
    public void setLab(String lab) {
        this.lab = lab;
    }

    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    public void addAluno(Estudante aluno){
        
    }
    
    public Map<String,Estudante> getListaAlunos(){
        Map<String,Estudante> mapEstudante = new HashMap<>();
        Estudante aluno = new Estudante();
        String estudante;
        estudante = "Bruno";
        return mapEstudante; 
    }
    
    public Estudante getAluno(String RA){
        Estudante aluno = new Estudante();
        return aluno;
    }
}
