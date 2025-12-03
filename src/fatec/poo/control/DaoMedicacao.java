package fatec.poo.control;

import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class DaoMedicacao {

    private Connection conn;

    public DaoMedicacao(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medicacao medicacao, int codConsulta) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tblMedicacao (nome, dosagem, qtde_dias, codigo_consulta) VALUES (?, ?, ?, ?)");

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, codConsulta);

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir medicacao: " + ex.toString());
        }
    }

    public void alterar(Medicacao medicacao) {

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tblMedicacao SET dosagem = ?, qtde_dias = ? WHERE nome = ?");

            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setString(3, medicacao.getNome());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar medicacao: " + ex.toString());
        }
    }

    public Medicacao consultar(String nomeMedicacao) {
        Medicacao medicacao = null;

        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tblMedicacao WHERE nome = ?"
            );

            ps.setString(1, nomeMedicacao);
            try {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    medicacao = new Medicacao(rs.getString("nome"));
                    medicacao.setDosagem(rs.getString("dosagem"));
                    medicacao.setQtdeDias(rs.getInt("qtde_dias"));
                }

                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar medicacao (ResultSet): " + ex.toString());
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar medicacao: " + ex.toString());
        }

        return medicacao;
    }
    
    public Integer consultarConsultaPorNome(String nome){
        Integer codigoConsulta = null;
        try {
            PreparedStatement ps = conn.prepareStatement(" SELECT codigo_consulta from tblMedicacao where nome = ?");
            
            ps.setString(1, nome);
            
            try {
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    codigoConsulta = rs.getInt("codigo_consulta");
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao pegar codigo da consulta por nome: " + ex.getMessage());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar codigo da consulta por nome: " + ex.getMessage());
        }
        return codigoConsulta;
    }


    public void excluir(String nomeMedicacao) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tblMedicacao WHERE nome = ?");

            ps.setString(1, nomeMedicacao);
            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir medicacao: " + ex.toString());
        }
    }
    
    public void excluirPorConsulta(int codigoConsulta) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tblMedicacao WHERE codigo_consulta = ?")){

            ps.setInt(1, codigoConsulta);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir medicacao: " + ex.toString());
        }
    }

    public ArrayList<Medicacao> listar() {
        ArrayList<Medicacao> lista = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tblMedicacao ORDER BY nome");

            try {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Medicacao medicacao = new Medicacao(rs.getString("nome"));
                    medicacao.setDosagem(rs.getString("dosagem"));
                    medicacao.setQtdeDias(rs.getInt("qtde_dias"));

                    lista.add(medicacao);
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao listar medicacoes: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao listar medicacoes: " + ex.toString());
        }

        return lista;
    }

}