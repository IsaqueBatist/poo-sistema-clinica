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

    public void alterar(Medicacao medicacao, int codConsulta) {

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tblMedicacao SET nome = ?, dosagem = ?, qtde_dias = ?, codigo_consulta = ? WHERE nome = ?");

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, codConsulta);
            ps.setString(5, medicacao.getNome());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar medicacao: " + ex.toString());
        }
    }

    public Medicacao consultar(String nomeMedicacao) {
        Medicacao medicacao = null;

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tblMedicacao WHERE nome = ?");

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
                System.out.println("Erro ao consultar medicacao: " + ex.toString());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar medicacao: " + ex.toString());
        }

        return medicacao;
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
}