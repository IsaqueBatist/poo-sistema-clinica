package fatec.poo.model;


/**
 *
 * @author Victor Leonardo
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Paciente extends Pessoa {
    
    private LocalDate dataNascimento;
    private double altura;
    private double peso;
 
    // private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    
    public Paciente(String cpf, String nome, LocalDate dataNascimento){
        super(cpf, nome); 
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }

    public double getAltura(){
        return altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    
    public double calcIMC(){
        return peso / Math.pow(altura, 2);
    }
    
    public int calcIdade(LocalDate dataAtual) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }
    
    /*
    public void addConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }
    
    public ArrayList<Consulta> getConsultas(){
        return this.consultas;
    }
    */
}
