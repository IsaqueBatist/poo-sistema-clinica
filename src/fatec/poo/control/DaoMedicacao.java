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
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tblMedicacao (nome, dosagem, qtdeDias, codConsulta) "
                + "VALUES (?, ?, ?, ?)"
        )) {

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, codConsulta);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir medicacao: " + ex.toString());
        }
    }

    public void alterar(int idMedicacao, Medicacao medicacao, int codConsulta) {

        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE tblMedicacao SET nome = ?, dosagem = ?, qtdeDias = ?, codConsulta = ? "
                + "WHERE idMedicacao = ?"
        )) {

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, codConsulta);
            ps.setInt(5, idMedicacao);

            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar medicacao: " + ex.toString());
        }
    }

    public Medicacao consultar(int idMedicacao) {
        Medicacao medicacao = null;

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tblMedicacao WHERE idMedicacao = ?"
        )) {

            ps.setInt(1, idMedicacao);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    medicacao = new Medicacao(rs.getString("nome"));
                    medicacao.setDosagem(rs.getString("dosagem"));
                    medicacao.setQtdeDias(rs.getInt("qtdeDias"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar medicacao: " + ex.toString());
        }

        return medicacao;
    }

    public void excluir(int idMedicacao) {
        try (PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM tblMedicacao WHERE idMedicacao = ?"
        )) {

            ps.setInt(1, idMedicacao);
            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir medicacao: " + ex.toString());
        }
    }

    public ArrayList<Medicacao> listar() {
        ArrayList<Medicacao> lista = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tblMedicacao ORDER BY nome"
        )) {

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Medicacao medicacao = new Medicacao(rs.getString("nome"));
                    medicacao.setDosagem(rs.getString("dosagem"));
                    medicacao.setQtdeDias(rs.getInt("qtdeDias"));
                    lista.add(medicacao);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar medicacoes: " + ex.toString());
        }

        return lista;
    }
}
