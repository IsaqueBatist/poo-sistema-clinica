package fatec.poo.control;

import fatec.poo.model.Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoExame {

    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Exame exame) {
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tblExame (codigo, descricao, data, horario, valor, codConsulta) "
                + "VALUES (?, ?, ?, ?, ?, ?)"
        )) {

            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, exame.getConsulta().getCodigo());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir exame: " + ex.toString());
        }
    }

    public void alterar(Exame exame) {
        try (PreparedStatement ps = conn.prepareStatement(
                "UPDATE tblExame SET descricao = ?, data = ?, horario = ?, valor = ?, codConsulta = ? "
                + "WHERE codigo = ?"
        )) {

            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getConsulta().getCodigo());
            ps.setInt(6, exame.getCodigo());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar exame: " + ex.toString());
        }
    }

    public Exame consultar(int codigo) {
        Exame exame = null;

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tblExame WHERE codigo = ?"
        )) {

            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    exame = new Exame(
                            rs.getInt("codigo"),
                            rs.getString("descricao")
                    );

                    exame.setData(rs.getString("data"));
                    exame.setHorario(rs.getString("horario"));
                    exame.setValor(rs.getDouble("valor"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar exame: " + ex.toString());
        }

        return exame;
    }

    public void excluir(Exame exame) {
        try (PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM tblExame WHERE codigo = ?"
        )) {

            ps.setInt(1, exame.getCodigo());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir exame: " + ex.toString());
        }
    }

    public ArrayList<Exame> consultarExames() {
        ArrayList<Exame> lista = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM tblExame ORDER BY descricao"
        )) {

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Exame exame = new Exame(
                            rs.getInt("codigo"),
                            rs.getString("descricao")
                    );

                    exame.setData(rs.getString("data"));
                    exame.setHorario(rs.getString("horario"));
                    exame.setValor(rs.getDouble("valor"));

                    lista.add(exame);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar exames: " + ex.toString());
        }

        return lista;
    }
}
