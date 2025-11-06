package fatec.poo.model;

/**
 *
 * @author isaqu
 */
public class Exame {
    private int codigo;
    private String descricao;
    private String data;
    private String horario;
    private Double valor;
    // private Consulta consulta;
    
    public Exame(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public Double getValor() {
        return valor;
    }
    
//    public Consulta getConsulta(){
//        return this.consulta;
//    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
//    public void setConsulta(Consulta consulta) {;
//        this.consulta = consulta;
//    }
    
}
