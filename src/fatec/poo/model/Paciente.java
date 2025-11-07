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
 
    
    public Paciente(String cpf, String nome, LocalDate dataNascimento){
        super(cpf, nome); // Chamada do método construtor da superclasse
        this.dataNascimento = dataNascimento;
    }

    // Getter DataNascimento formatada no padrão dia/mês/ano
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

    // Método para calcular o IMC
    public double calcIMC(){
        if (altura > 0){
            return peso / (altura * altura);
        }
        return 0;
    }

    // Método para calcular idade usando a data informada pelo LocalDate
    public int calcIdade(LocalDate dataAtual) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }
    
}
