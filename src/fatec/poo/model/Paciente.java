package fatec.poo.model;

/**
 *
 * @author Victor Leonardo
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.ArrayList;


public class Paciente extends Pessoa {
    
    private LocalDate dataNascimento;
    private double altura;
    private double peso;
    private ArrayList<Consulta> consultas;
    
    public Paciente(String cpf, String nome, LocalDate dataNascimento){
        super(cpf, nome); 
        this.dataNascimento = dataNascimento;
        this.consultas = new ArrayList<>();
    }

    public String getDataNascimento(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern
        ("dd/MM/yyyy");
        return dataNascimento.format(formatador);
    }

    public double getAltura(){
        return altura;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    
    public void addConsulta(Consulta consulta){
        this.consultas.add(consulta);
    }
    
    public ArrayList<Consulta> getConsultas(){
        return this.consultas;
    }
}