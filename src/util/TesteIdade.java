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


public class TesteIdade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
        //SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
        String dataNasc;
       // dataNasc = df.format(date);
        Estudante estu = new Estudante();
        estu.setNome("Bruno");
        estu.setCPF("10019788645");
        estu.setRA("101059");
        estu.setPeriodo(5);
        String converte = "29/10/1997";
        Date kk;
        kk = df.parse(converte);        
        estu.setDtNascimento(kk);
        
        System.out.println(estu.getCPF()+" "+estu.getPeriodo()+" "+estu.getNome() + " "+estu.getIdade());
    }
    
}
