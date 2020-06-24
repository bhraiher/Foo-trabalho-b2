/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Estudante;
import modelo.Professor;

/**
 *
 * @author bruni
 */
public class TestaClasses3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        //Instancias
        Scanner entrada = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Estudante aluno = new Estudante();
        Professor profe = new Professor();
        Curso cursoCad = new Curso();
        List<Professor> listaProfessor = new ArrayList<>();
        List<Disciplina> listaDisciplina = new ArrayList<>();
        
        /*VARIAVEIS*/
        //Pessoa
        String nomePessoa, CPF;
        String dtNascAux;
        Date dtNascimento;
        
        //Estudante
        String RA;
        int periodo;
        Curso curso;
        
        //Professor
        int auxProf;
        boolean  aa = false;
        String nreg, titulacao;
        float hrssem;
        double precoHR;
        
        //Disciplina
        int auxDisc;
        String nomeDisciplina;
        int cargaHoraria, aux;
        Professor professor;
        
        //Curso
        String nomeCurso;
        
        /*CADASTROS*/
        //Cadastro professores
        for(int i = 0; i< 2; i++){
            System.out.print("\nNome do Professor "+i+": ");
            nomePessoa = entrada.next();
            
            System.out.print("CPF do Professor "+i+": ");
            CPF = entrada.next();
            
            System.out.print("Data de nascimento do Professor (dd/mm/aaaa)"+i+": ");  
            dtNascAux = entrada.next();
            dtNascimento = df.parse(dtNascAux);
            
            System.out.print("Matricula Professor "+i+": ");
            nreg = entrada.next();
            
            System.out.print("Titulação Professor "+i+": ");
            titulacao = entrada.next();
            
            System.out.print("Horas semanais do Professor "+i+": ");
            hrssem = entrada.nextFloat();
            
            System.out.print("Preço da hora do Professor "+i+": ");
            precoHR = entrada.nextDouble();
            
            Professor prof = new Professor(nreg,titulacao,hrssem,precoHR,nomePessoa,CPF,dtNascimento);
            listaProfessor.add(prof);
        }System.out.println("\n");
        
 
        //Cadastro de Disciplinas
        
        System.out.println("-- Professores que podem ser cadastrados na disciplina --");
        for(int j = 0; j< 2; j++){
                profe = (Professor)listaProfessor.get(j);
                System.out.println("Professor "+j+": "+profe.getNome()+" - "+profe.getNRegistro());
            }
        for(int i = 0; i< 2; i++){           
            System.out.print("Nome da disciplina: ");
            nomeDisciplina = entrada.next();
            System.out.print("Carga horaria da disciplina: ");
            cargaHoraria = entrada.nextInt();
            System.out.print("Qual o código do professor: ");
            aux = entrada.nextInt();
            professor = (Professor)listaProfessor.get(aux);   
            System.out.println("\n");
            
            Disciplina dw = new Disciplina();
            dw.setNome(nomeDisciplina);
            dw.setCargaHoraria(cargaHoraria);
            dw.setProfessor(professor);
            listaDisciplina.add(dw);
        }System.out.println("\n");
        
        Disciplina dd;
        for(int j = 0; j< 2; j++){
                dd = (Disciplina)listaDisciplina.get(j);
                System.out.println("Professor "+j+": "+dd.getNome()+" - "+dd.getProfessor().getNome());
            }
        
        //Cadastro de 2 curso
        for(int i = 0; i<2;i++ ){
            System.out.println("Informe o nome do curso: ");
            nomeCurso = entrada.next();
            cursoCad.setNomeCurso("Tads");
            cursoCad.inserirDisciplinas(listaDisciplina.get(0));
        }
        
        Curso cc;
        Disciplina abc = cursoCad.recuperarDisciplinas().get(0);
        Disciplina def = cursoCad.recuperarDisciplinas().get(1);
        
    
        System.out.println(abc.getNome()+" "+def.getNome());
        //Cadastro de 3 alunos
        /*for(int i = 0; i< 3; i++){
            System.out.print("Nome do aluno "+i+": ");
            System.out.print("CPF do aluno "+i+": ");
            System.out.print("Data de nascimento do aluno "+i+": ");
            System.out.print("RA do aluno "+i+": ");
            System.out.print("Periodo do aluno "+i+": ");
            System.out.print("Curso do aluno "+i+": ");
        }*/
        
     
        
        
        //Menu de cadastro
    }
    
}
