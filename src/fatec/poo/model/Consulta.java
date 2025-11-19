package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Beatriz Camargo
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    private Medico medico;
    private ArrayList<Exame> exames;
    private ArrayList<Medicacao> medicacoes;;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void addMedicacao(Medicacao medicacao){
        this.medicacoes.add(medicacao);
    }

    public ArrayList<Medicacao> getMedicacoes() {
        return medicacoes;
    }
    
    public void addExame(Exame exame){
        this.exames.add(exame);
        exame.setConsulta(this);
    }
    
    public ArrayList<Exame> getExames(){
        return this.exames;
    }
    
    public double calcValorTotalPagar(){
        double valorExames = 0;
        for (Exame exame: exames) {
            valorExames += exame.getValor();
        }
        return valor + valorExames;
    }
}
