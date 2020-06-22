/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Estudante;
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
    public static void main(String[] args) throws ParseException, IOException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");



        //Cadastro de profesor
        String nRegistro = "5497";
        String titulacao = "Meste";
        float horasSemanais = 36;
        double precoHora = 15.50;
        String nome = ("Bruno Henrique");
        String CPF = ("234928347");
        String converteProf = "29/10/1997";
        Date dataNascimentoProf;
        dataNascimentoProf = df.parse(converteProf);
        Date dtnasc = dataNascimentoProf;
        Professor prof1 = new Professor(nRegistro, titulacao, horasSemanais, precoHora, nome, CPF, dtnasc);

        System.out.println("PROFESSOR");
        System.out.println("getNRegistro: " + prof1.getNRegistro());
        System.out.println("getTitulacao: " + prof1.getTitulacao());
        System.out.println("getHorasSemanais: " + prof1.getHorasSemanais());
        System.out.println("getPrecoHora: " + prof1.getPrecoHora());
        System.out.println("getNome: " + prof1.getNome());
        System.out.println("getCPF: " + prof1.getCPF());
        System.out.println("getDtNascimento: " + prof1.getDtNascimento());
        System.out.println();



        //Cadastro no colegiado
        Colegiado colegiado = new Colegiado();
        colegiado.inserirProfessor(prof1);


        System.out.println("COLEGIADO");
        for (int i=0; i< colegiado.recuperarProfessores().size(); i++){
            System.out.println("recuperarProfessores: " + colegiado.recuperarProfessores().get(i).getNome());
        }
        System.out.println();



        //Disciplina
        Disciplina disciplina = new Disciplina();
        System.out.println("DISCIPLINA");
        if(colegiado.recuperarProfessores().contains(prof1)){
            disciplina.setNome("Matematica");
            disciplina.setCargaHoraria(40);
            disciplina.setProfessor(prof1);
        }else{
            System.out.println("AQUELA MENSAGEM DE ERRO");
        }
        System.out.println();



        //Cadastro de curso
        Curso curso = new Curso();
        System.out.println("CURSO");
        curso.inserirDisciplinas(disciplina);
        curso.setNomeCurso("LUIZ TADS TI");
        
        System.out.println(curso.recuperarDisciplinas().get(0).getNome());
        System.out.println();


        //Cadastro de estudante:
        String EstudanteRA = "161819";
        int EstudantePeriodo = 5;
        String Estudantenome = "Bruno Henrique";
        String EstudanteCPF = "234928347";
        String converte = "29/10/1997";
        Date EstudantedataNascimento;
        EstudantedataNascimento = df.parse(converte);


        Estudante estudante = new Estudante(EstudanteRA, EstudantePeriodo, curso, Estudantenome, EstudanteCPF, EstudantedataNascimento);


        System.out.println("ESTUDANTE");
        System.out.println("getRA: " + estudante.getRA());
        System.out.println("getPeriodo: " + estudante.getPeriodo());
        System.out.println("getCurso: " + estudante.getCurso().getNomeCurso());
        System.out.println("getNome: " + estudante.getNome());
        System.out.println("getCPF: " + estudante.getCPF());
        System.out.println("getIdade: " + estudante.getIdade());
    }
}