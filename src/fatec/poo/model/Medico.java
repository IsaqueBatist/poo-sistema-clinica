/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author isaqu
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
//    private List<Consulta> consultas;
    
    public Medico(String cpf,String nome, String crm, String especialidade){
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
//        this.consultas = new Arraylist<>();
    }
    
    public String getCrm(){
        return this.crm;
    }
    
    public String getEspecialidade(){
        return this.especialidade;
    }
    
//    public void addConsulta(Consulta consulta){;;
//        this.consultas.add(consulta);
//    }

//    public List<Consulta> getConsultas(){
//        return this.consultas;
//    }
}
