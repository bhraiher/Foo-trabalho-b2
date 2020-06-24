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
public class TestaClasse4 {

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
        List<Professor> listaProfessor = new ArrayList<>();
        List<Professor> listaProfessor2 = new ArrayList<>();
        List<Disciplina> listaDisciplina = new ArrayList<>();
        List<Curso> listaCurso = new ArrayList<>();
        List<Colegiado> listaColegiado = new ArrayList();
        
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
        String nreg, titulacao, auxProfString;
        float hrssem;
        double precoHR;
        int auxProf = 0;
        boolean  auxProfMenu = true;
        
        //Disciplina  
        String nomeDisciplina;
        int cargaHoraria, aux;
        Professor professor;
        int auxDisc = 0;
        
        //Curso
        String nomeCurso, auxCursoMatricula;
        boolean auxCursoMenu = true;
        int auxCurso = 0;
        
        //Geral
        int opcaoMenu;
        boolean menu = true;
        /*--CADASTROS--*/
        while(menu == true){
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
        switch(opcaoMenu){
            case 1:
                while(auxProfMenu == true){
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

                    Professor prof = new Professor(nreg,titulacao,hrssem,precoHR,nomePessoa,CPF,dtNascimento);
                    listaProfessor.add(prof);
                    auxProf++;

                    System.out.print("\nDeseja cadastrar mais professor? S/N: ");
                    auxProfString = entrada.next();
                    if(!auxProfString.equals("S") && !auxProfString.equals("s") && !auxProfString.equals("N") && !auxProfString.equals("n")){
                        while(!auxProfString.equals("S") && !auxProfString.equals("N")){
                            System.out.print("Favor informar a letra S para Sim e N para Não: ");
                            auxProfString = entrada.next();
                        }
                    }                                     
                    if(auxProfString.equals("S") || auxProfString.equals("s")){
                        auxProfMenu = true;
                    }else if(auxProfString.equals("N") || auxProfString.equals("n")){
                        auxProfMenu = false;
                    } 
                }
                break;
            case 2:
                if(listaProfessor.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um professor, para depois cadastrar os cursos.","ERRO",JOptionPane.OK_OPTION);
                    break;
                }
                
                //Caso o primeiro cadastro
                if(listaCurso.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um professor, para depois cadastrar os cursos.","ERRO",JOptionPane.WARNING_MESSAGE);
                    System.out.println("Este é o cadastro do primeiro curso, necessitando preenchimento de ao menos uma disciplina e um colegiado.");
                    System.out.println("Informe o nome do Curso: ");
                    nomeCurso = entrada.next();
                    cursoCad.setNomeCurso(nomeCurso);
                    
                    System.out.println("Agora será realizado o cadastramento do Colegiado para este primeiro Curso.");
                    colegiado.setCurso(cursoCad);
                    System.out.println("Você deverá selecionar os professores deste colegiado:");
                    System.out.println("-- PROFESSORES --");
                    System.out.println("MATRICULA - NOME");
                    for(int i = 0; i < listaProfessor.size(); i++){
                        System.out.println(listaProfessor.get(i).getNRegistro()+" - "+listaProfessor.get(i).getNome());
                    }
                    System.out.print("\nInforme a matricula do Professor: ");
                    auxCursoMatricula = entrada.next();
                    Professor pp1, pp2 = profe;
                    for(int i = 0; i < listaProfessor.size(); i++){
                        pp1 = listaProfessor.get(i);
                        if(pp1.getNRegistro().equals(auxCursoMatricula)){
                            pp2 = pp1;
                        }
                    }
                   
         
                    colegiado.inserirProfessor(pp2);
                    listaProfessor2 = colegiado.recuperarProfessores();
                    listaColegiado.add(colegiado);
                    listaCurso.add(cursoCad);
                break;
                }
                        
                
                
                
            case 4:
                if(listaProfessor.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Primeiramente você precisa cadastrar um professor, para depois cadastrar um colegiado.","ERRO",JOptionPane.WARNING_MESSAGE);
                    break;
                }
                System.out.println("Informe o ");
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Sucesso",JOptionPane.PLAIN_MESSAGE);
                break;
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
