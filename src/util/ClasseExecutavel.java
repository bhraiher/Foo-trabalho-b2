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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Colegiado;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Estudante;
import modelo.Professor;

/**
 *
 * @author bruni
 */
public class ClasseExecutavel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        //Instancias
        Scanner entrada = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Estudante aluno = new Estudante();
        Professor profe = new Professor();
        Colegiado colegiado = new Colegiado();
        Curso cursoCad = new Curso();
        Disciplina disciplina = new Disciplina();
        List<Professor> listaProfessor = new ArrayList<>();
        List<Disciplina> listaDisciplina = new ArrayList<>();
        List<Curso> listaCurso = new ArrayList<>();
        List<Colegiado> listaColegiado = new ArrayList();

        /*--VARIAVEIS--*/
        //Pessoa
        String nomePessoa, CPF;
        String dtNascAux;
        Date dtNascimento;

        //Estudante
        String RA;
        int periodo;
        Curso curso;

        //Professor
        String nreg, titulacao, auxProfString;
        float hrssem;
        double precoHR;
        int auxProf = 0;
        boolean auxProfMenu = true;

        //Disciplina  
        String nomeDisciplina;
        int cargaHoraria, aux;
        Professor professor;
        int auxDisc = 0;

        //Curso
        String nomeCurso, auxCursoMatricula, auxCursoString;
        boolean auxCursoMenu = true;
        int auxCurso = 0;

        //Colegiado
        String auxColegiadoString;
        boolean auxColegiado = true;
        int auxColInt;

        //Geral
        int opcaoMenu;
        boolean menu = true;

        /*--CADASTROS--*/
        while (menu == true) {
            System.out.println("1 - Cadastro de professor");
            System.out.println("2 - Cadastro de curso");
            System.out.println("3 - Cadastro de alunos no curso");
            System.out.println("4 - Cadastro de colegiado");
            System.out.println("5 - Cadastro das disciplinas do curso");
            System.out.println("6 - Cadastro de aula do curso");
            System.out.println("7 - Lista alunos do curso");
            System.out.println("8 - Lista disciplinas do curso");
            System.out.println("9 - Lista colegiado do curso");
            System.out.println("10 - SAIR");
            System.out.print("Resposta: ");
            opcaoMenu = entrada.nextInt();
            System.out.println("\n");
            switch (opcaoMenu) {
                case 1:
                    while (auxProfMenu == true) {
                        System.out.print("\nNome do Professor: ");
                        nomePessoa = entrada.next();

                        System.out.print("CPF do Professor: ");
                        CPF = entrada.next();

                        System.out.print("Data de nascimento do Professor (dd/mm/aaaa): ");
                        dtNascAux = entrada.next();
                        dtNascimento = df.parse(dtNascAux);

                        System.out.print("Matricula Professor: ");
                        nreg = entrada.next();

                        System.out.print("Titulação Professor: ");
                        titulacao = entrada.next();

                        System.out.print("Horas semanais do Professor: ");
                        hrssem = entrada.nextFloat();

                        System.out.print("Preço da hora do Professor: ");
                        precoHR = entrada.nextDouble();

                        Professor prof = new Professor(nreg, titulacao, hrssem, precoHR, nomePessoa, CPF, dtNascimento);
                        listaProfessor.add(prof);
                        auxProf++;

                        System.out.print("\nDeseja cadastrar mais professor? S/N: ");
                        auxProfString = entrada.next();
                        if (!auxProfString.equals("S") && !auxProfString.equals("s") && !auxProfString.equals("N") && !auxProfString.equals("n")) {
                            while (!auxProfString.equals("S") && !auxProfString.equals("N") && !auxProfString.equals("s") && !auxProfString.equals("n")) {
                                System.out.print("Favor informar a letra S para Sim e N para Não: ");
                                auxProfString = entrada.next();
                            }
                        }
                        if (auxProfString.equals("S") || auxProfString.equals("s")) {
                            auxProfMenu = true;
                        } else if (auxProfString.equals("N") || auxProfString.equals("n")) {
                            auxProfMenu = false;
                        }
                    }
                    break;
                case 2:
                    if (listaProfessor.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um professor, para depois cadastrar os cursos.", "ERRO", JOptionPane.OK_OPTION);
                        break;
                    }

                    //Caso o primeiro cadastro
                    if (listaCurso.isEmpty()) {
                        //Curso
                        JOptionPane.showMessageDialog(null, "Este é o cadastro do primeiro curso, necessitando preenchimento de ao menos uma disciplina e um colegiado.", "AVISO", JOptionPane.WARNING_MESSAGE);
                        System.out.println("Informe o nome do Curso: ");
                        nomeCurso = entrada.next();
                        cursoCad.setNomeCurso(nomeCurso);

                        //Colegiado
                        System.out.println("\nAgora será realizado o cadastramento do Colegiado para este primeiro Curso.");
                        colegiado.setCurso(cursoCad);
                        System.out.println("Selecione abaixo os professores que iram compor o colegiado: ");
                        System.out.println("-- PROFESSORES CADASTRADOS--");
                        System.out.println("MATRICULA - NOME");
                        for (int i = 0; i < listaProfessor.size(); i++) {
                            System.out.println(listaProfessor.get(i).getNRegistro() + " - " + listaProfessor.get(i).getNome());
                        }
                        while (auxColegiado == true) {
                            System.out.print("\nInforme a matricula do Professor: ");
                            auxCursoMatricula = entrada.next();
                            Professor pp1, pp2 = new Professor();
                            for (int i = 0; i < listaProfessor.size(); i++) {
                                pp1 = listaProfessor.get(i);
                                if (pp1.getNRegistro().equals(auxCursoMatricula)) {
                                    pp2 = pp1;
                                }
                            }
                            colegiado.inserirProfessor(pp2);
                            System.out.print("\n Deseja vincular mais algum professor? S/N:");
                            auxColegiadoString = entrada.next();
                            if (auxColegiadoString.equals("S") || auxColegiadoString.equals("s")) {
                                auxColegiado = true;
                            } else if (auxColegiadoString.equals("N") || auxColegiadoString.equals("n")) {
                                auxColegiado = false;
                            }
                        }

                        //Disciplina 
                        System.out.print("Informe o nome da disciplina:  ");
                        nomeDisciplina = entrada.next();
                        disciplina.setNome(nomeDisciplina);
                        System.out.print("Informe a carga horária da disciplina: ");
                        cargaHoraria = entrada.nextInt();
                        disciplina.setCargaHoraria(cargaHoraria);
                        System.out.println("-- PROFESSORES CADASTRADOS--");
                        System.out.println("MATRICULA - NOME");
                        for (int i = 0; i < listaProfessor.size(); i++) {
                            System.out.println(listaProfessor.get(i).getNRegistro() + " - " + listaProfessor.get(i).getNome());
                        }
                        System.out.print("\nMatricula do professor: ");
                        auxCursoMatricula = entrada.next();
                        Professor pp1, pp2 = new Professor();
                        for (int i = 0; i < listaProfessor.size(); i++) {
                            pp1 = listaProfessor.get(i);
                            if (pp1.getNRegistro().equals(auxCursoMatricula)) {
                                pp2 = pp1;
                            }
                        }
                        Professor ra, ra2 = new Professor();
                        for (int i = 0; i < colegiado.recuperarProfessores().size(); i++) {
                            ra = colegiado.recuperarProfessores().get(i);
                            if (ra.getNRegistro().equals(pp2.getNRegistro())) {
                                ra2 = ra;
                            }
                        }
                        if (ra2.getNRegistro().equals(pp2.getNRegistro())) {
                            disciplina.setProfessor(pp2);
                        }
                        listaDisciplina.add(disciplina);
                        listaColegiado.add(colegiado);
                        cursoCad.inserirDisciplinas(disciplina);
                        listaCurso.add(cursoCad);
                        break;
                    } else {
                        auxCursoMenu = true;
                        cursoCad = new Curso();
                        System.out.println("Informe o nome do Curso: ");
                        nomeCurso = entrada.next();
                        cursoCad.setNomeCurso(nomeCurso);

                        System.out.println("--DISCIPLINAS CADASTRADAS--");
                        Disciplina cc;
                        for (int i = 0; i < listaDisciplina.size(); i++) {
                            cc = listaDisciplina.get(i);
                            System.out.println("Disciplina " + i + " - " + cc.getNome());
                        }
                        while(auxCursoMenu == true){
                        System.out.print("Informe o CÓDIGO da disciplina: ");
                        auxDisc = entrada.nextInt();
                        cursoCad.inserirDisciplinas(listaDisciplina.get(auxDisc));
                        System.out.print("\n Deseja vincular mais alguma disciplina?? S/N:");
                        auxCursoString = entrada.next();
                        if (auxCursoString.equals("S") || auxCursoString.equals("s")) {
                            auxCursoMenu = true;
                        } else if (auxCursoString.equals("N") || auxCursoString.equals("n")) {
                            auxCursoMenu = false;
                        }
                        }
                        listaCurso.add(cursoCad);
                        break;
                    }

                case 3:
                    if (aluno.getRA() == null) {
                        JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um aluno, para depois cadastrar ele no curso.", "ERRO", JOptionPane.OK_OPTION);
                        break;
                    }
                    if (cursoCad.getNomeCurso() == null) {
                        JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um curso, para depois cadastrar os alunos.", "ERRO", JOptionPane.OK_OPTION);
                        break;
                    }
                    System.out.println("Informe o nome do Curso: ");
                    nomeCurso = entrada.next();
                    if (cursoCad.getNomeCurso().contains(nomeCurso)) {
                        //
                    } else {
                        JOptionPane.showMessageDialog(null, "Curso não encontrado.", "ERRO", JOptionPane.OK_OPTION);
                        break;
                    }
                    
                 case 4:
                    if (listaProfessor.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um professor, para depois cadastrar um colegiado.", "ERRO", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    if (listaCurso.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um curso, para depois cadastrar um colegiado.", "ERRO", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                     //Colegiado
                    auxColegiado = true;
                    System.out.println("\n--CADASTRO DE CURSOS--");
                    for (int i = 0; i < listaCurso.size(); i++) {
                        System.out.println("Curso "+i+" - "+listaCurso.get(i).getNomeCurso());
                    }
                    System.out.print("Informe o código do curso: ");
                    auxColInt = entrada.nextInt();
                    colegiado.setCurso(listaCurso.get(auxColInt));
                    System.out.println("Selecione abaixo os professores que iram compor o colegiado: ");
                    System.out.println("-- PROFESSORES CADASTRADOS--");
                    System.out.println("MATRICULA - NOME");
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        System.out.println(listaProfessor.get(i).getNRegistro() + " - " + listaProfessor.get(i).getNome());
                    }
                    while (auxColegiado == true) {
                    System.out.print("\nInforme a matricula do Professor: ");
                    auxCursoMatricula = entrada.next();
                    Professor pp1, pp2 = new Professor();
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        pp1 = listaProfessor.get(i);
                        if (pp1.getNRegistro().equals(auxCursoMatricula)) {
                            pp2 = pp1;
                        }
                    }
                    colegiado.inserirProfessor(pp2);
                            System.out.print("\n Deseja vincular mais algum professor? S/N:");
                            auxColegiadoString = entrada.next();
                            if (auxColegiadoString.equals("S") || auxColegiadoString.equals("s")) {
                                auxColegiado = true;
                            } else if (auxColegiadoString.equals("N") || auxColegiadoString.equals("n")) {
                                auxColegiado = false;
                            }
                    }
                    
                  
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                    break;
                    
                    
                    
                case 5: 
                    //Disciplina 
                    disciplina = new Disciplina(); 
                    System.out.print("Informe o nome da disciplina:  ");
                    nomeDisciplina = entrada.next();
                    disciplina.setNome(nomeDisciplina);
                    System.out.print("Informe a carga horária da disciplina: ");
                    cargaHoraria = entrada.nextInt();
                    disciplina.setCargaHoraria(cargaHoraria);
                    if(listaProfessor.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não existe professor cadastrado, favor cadastrar um primeiramente!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    System.out.println("-- PROFESSORES CADASTRADOS--");
                    System.out.println("MATRICULA - NOME");
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        System.out.println(listaProfessor.get(i).getNRegistro() + " - " + listaProfessor.get(i).getNome());
                    }

                    System.out.print("\nMatricula do professor: ");
                    auxCursoMatricula = entrada.next();
                    Professor pp1, pp2 = profe;
                    for (int i = 0; i < listaProfessor.size(); i++) {
                        pp1 = listaProfessor.get(i);
                        if (pp1.getNRegistro().equals(auxCursoMatricula)) {
                            pp2 = pp1;
                        }
                    }
                    if(listaColegiado.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não existe nem um colegiado cadastrado, favor cadastrar um primeiramente!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    Professor ra, ra2 = profe;
                    for (int i = 0; i < colegiado.recuperarProfessores().size(); i++) {
                        ra = colegiado.recuperarProfessores().get(i);
                        if (ra.getNRegistro().equals(pp2.getNRegistro())) {
                            ra2 = ra;
                        }
                    }
                    if (ra2.getNRegistro().equals(pp2.getNRegistro())) {
                        disciplina.setProfessor(pp2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Professor não cadastrado no colegiado. Cadastre-o primeiramente no colegiado.", "ERRO", JOptionPane.WARNING_MESSAGE);
                    }
                    listaDisciplina.add(disciplina);
                    break;
                case 8:
                    Curso cc = new Curso();
                    List<Disciplina> ddList = new ArrayList<>();
                    
                    
                    for(int i = 0; i<listaCurso.size();i++){
                        cc = listaCurso.get(i);
                        System.out.println("--CURSO "+cc.getNomeCurso()+"--");
                        ddList = cc.recuperarDisciplinas();
                        for(int j = 0; j<cc.recuperarDisciplinas().size();j++){
                            Collections.sort(ddList, new Comparator<Disciplina>() {
                                @Override
                                public int compare(Disciplina o1, Disciplina o2) {
                                   return  o1.getNome().compareTo(o2.getNome());
                                }
                            });
                            System.out.println("Disciplina: "+cc.recuperarDisciplinas().get(j).getNome());
                            System.out.println("Carga Horaria: "+cc.recuperarDisciplinas().get(j).getCargaHoraria());
                            System.out.println("Nome do professor: "+cc.recuperarDisciplinas().get(j).getProfessor().getNome());
                            System.out.println("Nome do professor: "+cc.recuperarDisciplinas().get(j).getProfessor().getTitulacao());
                        }
                        
                    }
                    for(int i = 0; i<listaCurso.size();i++){
                        
                    }
                    
                    
                    break;
                case 9:
                    Colegiado col;
                    List<Professor> proList = new ArrayList<>();
                    for(int i=0; i<listaColegiado.size();i++){
                        col = listaColegiado.get(i);
                        System.out.println("--CURSO "+col.getCurso().getNomeCurso()+"--");
                        proList = col.recuperarProfessores();
                        for(int j = 0; j<col.recuperarProfessores().size();j++){
                            System.out.println("Professores do curso: "+proList.get(j).getNome());
                            System.out.println("Horas semanais do professor: "+proList.get(j).getHorasSemanais());
                            System.out.println("Titulacao: "+proList.get(j).getTitulacao());
                        }
                        
                    }
                case 10:
                    menu = false;
                    break;
                default:
                    System.out.println("Você não digitou um codigo do menu valido.");
            }
            //Cadastro Professor .    

        }

    }
}
