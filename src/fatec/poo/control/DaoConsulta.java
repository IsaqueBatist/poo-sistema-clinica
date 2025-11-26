package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Exame;
import fatec.poo.model.Medicacao;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isaqu
 */
public class DaoConsulta {
    
    private Connection conn;
    
    public DaoConsulta(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Consulta consulta, Paciente paciente){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tblConsulta (codigo, data, valor, cpf_paciente, cpf_medico) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, paciente.getCpf());
            ps.setString(5, consulta.getMedico().getCpf()); 
        
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir consulta: " + ex.toString());
        }
    }
    
    public void alterar(Consulta consulta, Paciente paciente){
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tblConsulta set data = ?, valor = ?, cpf_paciente =?, cpf_medico = ? WHERE codigo = ?");
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setString(3, paciente.getCpf());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setInt(5, consulta.getCodigo());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar conulsta: " + ex.toString());
        }
    }
    
    
    public Consulta consultar(int codigo){
        Consulta consulta = null;
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from tblConsulta where codigo = ?");
            ps.setInt(1, codigo);
            
            try {
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    consulta = new Consulta(codigo, rs.getString("data"));
                    
                    String cpfMedico = rs.getString("cpf_medico");
                    String cpfPaciente = rs.getString("cpf_paciente");
                    
                    Medico medico = new DaoMedico(conn).consultar(cpfMedico);
                    Paciente paciente = new DaoPaciente(conn).consultar(cpfPaciente);
                    
                    consulta.setMedico(medico);
                    consulta.setValor(rs.getDouble("valor"));
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar consulta: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar consulta: " + ex.toString());
        }
        return consulta;
    }
    
    public void excluir(int codigoConsulta){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tblConsulta where codigo = ? ");
            ps.setInt(1, codigoConsulta);
            
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir consulta: " + ex.getMessage());
        }
    }
    
    public ArrayList<Exame> consultarExames(Consulta consulta){
        ArrayList<Exame> exames = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tblExame WHERE codigo_consulta = ?");
            ps.setInt(1, consulta.getCodigo());
            try {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Exame exame = new Exame(rs.getInt("codigo"), rs.getString("descricao"));
                    exame.setConsulta(consulta);
                    exame.setData(rs.getString("data"));
                    exame.setHorario(rs.getString("horario"));
                    exame.setValor(rs.getDouble("valor"));
                    
                    exames.add(exame);
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar exames da consulta: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar exames da consulta: " + ex.toString());
        }
        return exames;
    }
    
    public ArrayList<Medicacao> consultarMedicacoes(Consulta consulta){
        ArrayList<Medicacao> medicacoes = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tblMedicacao WHERE codigo_consulta = ?");
            ps.setInt(1, consulta.getCodigo());
            try {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Medicacao medicacao = new Medicacao(rs.getString("nome"));
                    medicacao.setDosagem(rs.getString("dosagem"));
                    medicacao.setQtdeDias(rs.getInt("qtde_dias"));
                    
                    medicacoes.add(medicacao);
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar exames da consulta: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar exames da consulta: " + ex.toString());
        }
        return medicacoes;
    }
    
    public ArrayList<Consulta> listarConsultasPaciente(String cpfPaciente){
        ArrayList<Consulta> consultas = new ArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from tblConsultas where cpf_paciente = ?");
            
            ps.setString(1, cpfPaciente);
            
            try {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){ // Alterado para while, pois pode retornar mais de uma
                    Consulta consulta = new Consulta(rs.getInt("codigo"), rs.getString("data"));
                    String cpfMedico = rs.getString("cpf_medico");
                    Medico medico = new DaoMedico(conn).consultar(cpfMedico);
                    
                    consulta.setMedico(medico);
                    consulta.setValor(rs.getDouble("valor"));
                    
                    consultas.add(consulta);
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar consultas do paciente: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar consultas do paciente: " + ex.toString());
        }
        
        return consultas;
    }
    
}