package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author isaqu
 */
public class Medico extends Pessoa {

    private String crm;
    private String especialidade;
    private ArrayList<Consulta> consultas;

    public Medico(String cpf, String nome, String crm, String especialidade) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public String getCrm() {
        return this.crm;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void addConsulta(Consulta consulta) {
        this.consultas.add(consulta);
        consulta.setMedico(this);
    }

    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }
}
