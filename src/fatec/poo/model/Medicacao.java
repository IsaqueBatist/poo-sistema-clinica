package fatec.poo.model;

/**
 *
 * @author Beatriz Camargo
 */
public class Medicacao {
    private String nome;
    private String dosagem;
    private int qtdeDias;
    
    public Medicacao(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    public String getNome() {
        return nome;
    }
}
