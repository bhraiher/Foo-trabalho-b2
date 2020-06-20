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
import modelo.Estudante;
import modelo.Pessoa;
import modelo.AlunosCurso;
import modelo.Aula;
import modelo.Curso;
import modelo.Colegiado;
import modelo.Disciplina;
import modelo.Professor;
/**
 *
 * @author bruni
 */
public class TestaClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        //Cadastro de curso.
        Estudante estudante = new Estudante();
        
        //Cadastro de profesor;
        String nome = ("Henrique");
        String CPF = ("464587678");
        String converteProf = "01/05/1977";
        Date dataNascimentoProf;
        dataNascimentoProf = df.parse(converteProf);
        Date dtnasc = dataNascimentoProf;
        String nregistro = ("5497");
        String titulacao = ("AAA");
        float horassem = 36;
        double precohr = 15.50;
        
        
        
        Professor prof1 = new Professor(nregistro,titulacao,horassem,precohr,nome,CPF,dataNascimentoProf);
        
        String nome2 = ("Andre");
        String CPF2 = ("464587678");
        String converteProf2 = "05/07/1987";
        Date dataNascimentoProf2;
        dataNascimentoProf2 = df.parse(converteProf);
        Date dtnasc2 = dataNascimentoProf2;
        String nregistro2 = ("5497");
        String titulacao2 = ("AAA");
        float horassem2 = 36;
        double precohr2 = 15.50;
        Curso curso = new Curso();
        Disciplina disciplina = new Disciplina();
        Colegiado colegiado = new Colegiado();
        
        Professor prof2 = new Professor(nregistro2,titulacao2,horassem2,precohr2,nome2,CPF2,dtnasc2);
        
        
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
        


        
        
        //Cadastro no colegiado
        colegiado.inserirProfessor(prof1);
        colegiado.inserirProfessor(prof2);
        
        //Cadastro de Disciplina
        disciplina.setNome("Matematica");
        disciplina.setCargaHoraria(40);
        disciplina.setProfessor(prof1);
        
        
        
        
        //Cadastro de curso
        curso.inserirDisciplinas(disciplina);
        
        System.out.println(disciplina.getProfessor().getNome());
        colegiado.recuperarProfessores().get(0);
        for(int i=0;i<colegiado.recuperarProfessores().size();i++){
            System.out.println(colegiado.recuperarProfessores().get(i));
        }
        
        
    }
    
}
