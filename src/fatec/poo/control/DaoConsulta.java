package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author isaqu
 */
public class DaoConsulta {

    private Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta, Paciente paciente) {

        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO tblConsulta (codigo, data, valor, cpf_paciente, cpf_medico) VALUES (?, ?, ?, ?, ?)")) {
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, paciente.getCpf());
            ps.setString(5, consulta.getMedico().getCpf());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir consulta: " + ex.toString());
        }
    }

    public void alterar(Consulta consulta) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tblConsulta set data = ?, valor = ? WHERE codigo = ?");
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar conulsta: " + ex.toString());
        }
    }

    public Consulta consultar(int codigo) {
        Consulta consulta = null;

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from tblConsulta where codigo = ?");
            ps.setInt(1, codigo);

            try {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    consulta = new Consulta(codigo, rs.getString("data"));

                    String cpfMedico = rs.getString("cpf_medico");
                    String cpfPaciente = rs.getString("cpf_paciente");

                    Medico medico = new DaoMedico(conn).consultar(cpfMedico);
                    Paciente paciente = new DaoPaciente(conn).consultar(cpfPaciente);

                    consulta.setMedico(medico);
                    consulta.setValor(rs.getDouble("valor"));
                    if (paciente != null) {

                        paciente.addConsulta(consulta);
                    }
                }

            } catch (SQLException ex) {
                System.out.println("Erro ao consultar consulta: " + ex.toString());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar consulta: " + ex.toString());
        }
        return consulta;
    }

    public String consultarCpfDePacientePorCodigoConsulta(int codigoConsulta) {
        String cpf = null;

        try (PreparedStatement ps = conn.prepareStatement("Select cpf_paciente from tblConsulta where codigo = ?")) {
            ps.setInt(1, codigoConsulta);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cpf = (rs.getString("cpf_paciente"));
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao buscar cpf de paciente: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cpf de paciente: " + ex.getMessage());
        }
        return cpf;
    }

    public void excluir(int codigoConsulta) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tblConsulta where codigo = ?")) {
            ps.setInt(1, codigoConsulta);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir consulta: " + ex.getMessage());
        }
    }
}
