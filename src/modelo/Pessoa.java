
package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Classe mãe de Estudante e Professor.
* Classe pronta.
*/
public class Pessoa {
    private String nome;
    private String CPF;
    private Date dtNascimento;
    
    //Construtor vazio
    public Pessoa(){      
    }
    //Construtor geral
    public Pessoa(String nome, String CPF, Date dtNascimento){
        this.nome = nome;
        this.CPF = CPF;
        this.dtNascimento = dtNascimento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    
    public Date getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    public int getIdade() throws ParseException { 
         
        
        //Instancia para formatar data
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        
        //Obtem data atual
        String dtAtual = df.format(new Date());
        
        //Declara a data inicial e data final como variavel do tipo Data.
       //Date dataInicio = df.parse(dtNascimento);
        Date dataFim = df.parse(dtAtual);
        
        //Obtem a diferença entre datas e obtem o intervalo de dias entre elas.
        long dt = (dataFim.getTime() - dtNascimento.getTime()) + 3600000;  
        Long diasCorridosAnoLong = (dt / 86400000L);  
        Integer diasDecorridosInt = Integer.valueOf(diasCorridosAnoLong.toString());  
        String diasDecorridos = String.valueOf(diasDecorridosInt);
        
        //Calcula a idade
        BigDecimal qtdDias = new BigDecimal(diasDecorridos);
        BigDecimal anoA = new BigDecimal(365.25);
        BigDecimal idade = qtdDias.divide(anoA,0, RoundingMode.DOWN);
        
        //Converte BigDecimal para int, para retornar inteiro no metodo.
        Integer idadeInt = Integer.valueOf(idade.toString());
       
        
        return idadeInt;
    
    }
    
    
    
    
    
}
