package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Beatriz-Camargo
 */
public class DaoPaciente {

    private Connection conn;

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Paciente paciente) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO tblPaciente(cpf, nome, endereco, telefone, data_nascimento, altura, peso) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getDataNascimento());
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir paciente: " + ex.getMessage());
        }
    }

    public void alterar(Paciente paciente) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE tblPaciente set nome = ?, endereco = ?, telefone = ?, data_nascimento = ?, altura = ?, peso = ? where cpf = ?");
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getDataNascimento());
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar paciente: " + ex.getMessage());
        }
    }

    public Paciente consultar(String cpf) {
        Paciente paciente = null;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            PreparedStatement ps = conn.prepareStatement("Select * from tblPaciente where cpf = ?");
            ps.setString(1, cpf);

            try {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    paciente = new Paciente(cpf, rs.getString("nome"), LocalDate.parse(rs.getString("data_nascimento"), formatador));

                    paciente.setEndereco("endereco");
                    paciente.setTelefone("telefone");
                    paciente.setAltura(rs.getDouble("altura"));
                    paciente.setPeso(rs.getDouble("peso"));
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar paciente: " + ex.getMessage());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar paciente: " + ex.getMessage());
        }
        return paciente;
    }

    public void excluir(Paciente paciente) {
        try {
            PreparedStatement ps = conn.prepareStatement("Delete from tblPaciente where cpf = ?");
            ps.setString(1, paciente.getCpf());

            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir paciente: " + ex.getMessage());
        }
    }

    public ArrayList<Paciente> consultarPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from tblPaciente order by nome");
            try {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Paciente paciente = new Paciente(rs.getString("cpf"), rs.getString("nome"), rs.getDate("data_nascimento").toLocalDate());

                    paciente.setEndereco("endereco");
                    paciente.setTelefone("telefone");
                    paciente.setAltura(rs.getDouble("altura"));
                    paciente.setPeso(rs.getDouble("peso"));

                    pacientes.add(paciente);
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao consultar pacientes: " + ex.getMessage());
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar pacientes: " + ex.getMessage());
        }
        return pacientes;
    }
}