package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Beatriz-Camargo
 */
public class DaoMedico {

    private final Connection conn;

    public DaoMedico(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Medico medico) {

        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO tblMedico(cpf, nome, endereco, telefone, crm, especialidade) VALUES(?,?,?,?,?,?)")) {
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir médico: " + ex.getMessage());
        }
    }

    public void alterar(Medico medico) {

        try (PreparedStatement ps = conn.prepareStatement("UPDATE tblMedico set nome = ?, endereco = ?, telefone = ?, crm = ?, especialidade = ? where cpf = ?")) {
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEndereco());
            ps.setString(3, medico.getTelefone());
            ps.setString(4, medico.getCrm());
            ps.setString(5, medico.getEspecialidade());
            ps.setString(6, medico.getCpf());

            ps.execute();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar médico: " + ex.getMessage());
        }
    }

    public Medico consultar(String cpf) {
        Medico medico = null;

        try (PreparedStatement ps = conn.prepareStatement("Select * from tblMedico where cpf = ?")) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico(cpf, rs.getString("nome"), rs.getString("crm"), rs.getString("especialidade"));

                    medico.setEndereco("endereco");
                    medico.setTelefone("telefone");
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar médico: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar médico: " + ex.getMessage());
        }
        return medico;
    }

    public void excluir(Medico medico) {

        try (PreparedStatement ps = conn.prepareStatement("Delete from tblMedico where cpf = ?")) {
            ps.setString(1, medico.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir médico: " + ex.getMessage());
        }
    }
}
