package fatec.poo.model;

import java.util.List;

/**
 *
 * @author Beatriz Camargo
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    private Medico medico;
    private List<Exame> exames;
    private List<Medicacao> medicacoes;;

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
    
    public double calcValorTotalPagar(){
        double valorExames;
        for (Exame exame: exames) {
            valorExames += exame.getValor();
        }
        return valor 
    }
}
