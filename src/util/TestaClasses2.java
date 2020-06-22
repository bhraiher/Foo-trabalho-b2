/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Colegiado;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Estudante;
import modelo.Professor;

/**
 *
 * @author Skyress
 */
public class TestaClasses2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        //Cadastro de curso.
        Estudante estudante = new Estudante();
        Professor prof1 = new Professor();
        Curso curso = new Curso();
        Disciplina disciplina = new Disciplina();
        Colegiado colegiado = new Colegiado();
        
        //Cadastro de estudante:
        estudante.setNome("Bruno Henrique");
        estudante.setCPF("234928347");
        String converte = "29/10/1997";
        Date dataNascimento;
        dataNascimento = df.parse(converte);
        estudante.setDtNascimento(dataNascimento);
        estudante.setRA("161819");
        estudante.setPeriodo(5);
        estudante.setCurso(curso);
        
        //Cadastro de profesor;
        String nome = ("Bruno Henrique");
        String CPF = ("234928347");
        String converteProf = "29/10/1997";
        Date dataNascimentoProf;
        dataNascimentoProf = df.parse(converte);
        Date dtnasc = dataNascimentoProf;
        

        prof1.setNRegistro("5497");
        prof1.setTitulacao("AAA");
        prof1.setHorasSemanais(36);
        prof1.setPrecoHora(15.50);
        
        //Cadastro no colegiado
        colegiado.inserirProfessor(prof1);
        
        //Cadastro de Disciplina
        disciplina.setNome("Matematica");
        disciplina.setCargaHoraria(40);
        disciplina.setProfessor(prof1);
        
        
        
        
        //Cadastro de curso
        curso.inserirDisciplinas(disciplina);
        
        System.out.println(disciplina.getProfessor());
        
    }
    
}
