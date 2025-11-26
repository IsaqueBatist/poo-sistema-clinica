package fatec.poo.test; // Ajuste para o pacote onde você quer a main

import fatec.poo.control.DaoConsulta;
import fatec.poo.control.DaoExame;
import fatec.poo.control.DaoMedicacao;
import fatec.poo.control.DaoMedico;
import fatec.poo.control.DaoPaciente;
import fatec.poo.control.PreparaConexao;
import fatec.poo.model.Consulta;
import fatec.poo.model.Exame;
import fatec.poo.model.Medicacao;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe principal para popular o banco vazio e testar as DAOs
 */
public class Aplic {

    public static void main(String[] args) {
        // 1. Configuração da Conexão
        // Nota: O usuário e senha do Access geralmente são vazios, a menos que você tenha definido.
        PreparaConexao prepCon = new PreparaConexao("", ""); 
        
        // CUIDADO: Verifique se você está usando UCanAccess ou Ponte JDBC-ODBC antiga.
        // Exemplo moderno (UCanAccess): "net.ucanaccess.jdbc.UcanaccessDriver"
        // Exemplo antigo (Java 7 ou anterior): "sun.jdbc.odbc.JdbcOdbcDriver"
        prepCon.setDriver("net.ucanaccess.jdbc.UcanaccessDriver"); 
        
        // COLOQUE AQUI O CAMINHO DO SEU ARQUIVO DO ACCESS
        prepCon.setConnectionString("jdbc:ucanaccess://C:\\Users\\isaqu\\Desktop\\codes\\ProgBanco\\NeteBeansProjects\\prjPOOBeatrizIsaqueVictor\\prjPOO\\src\\fatec\\poo\\basededados\\DBClinica.accdb"); 
        
        Connection conn = prepCon.abrirConexao();
        
        if (conn != null) {
            // Instanciando as DAOs
            DaoPaciente daoPaciente = new DaoPaciente(conn);
            DaoMedico daoMedico = new DaoMedico(conn);
            DaoConsulta daoConsulta = new DaoConsulta(conn);
            DaoExame daoExame = new DaoExame(conn);
            DaoMedicacao daoMedicacao = new DaoMedicacao(conn);

            // ==================================================================
            // 2. Inserindo PACIENTE e MÉDICO (Independentes)
            // ==================================================================
            System.out.println("--- Inserindo Paciente e Médico ---");
            
            // Criando Paciente (Construtor baseado na sua DaoPaciente)
            // Formato data: YYYY-MM-DD para LocalDate
            Paciente p1 = new Paciente("11111111111", "Isaque Developer", LocalDate.of(2005, 9, 6));
            p1.setEndereco("Rua Java, 19");
            p1.setTelefone("11999999999");
            p1.setAltura(1.75);
            p1.setPeso(70.5);
            
            daoPaciente.inserir(p1);

            // Criando Médico
            Medico m1 = new Medico("22222222222", "Dr. House", "1234-SP", "Diagnóstico");
            m1.setEndereco("Hospital Princeton");
            m1.setTelefone("11888888888");
            
            daoMedico.inserir(m1);
            
            System.out.println("Paciente e Médico inseridos com sucesso.");

            // ==================================================================
            // 3. Inserindo CONSULTA (Depende de Médico e Paciente)
            // ==================================================================
            System.out.println("\n--- Inserindo Consulta ---");
            
            Consulta c1 = new Consulta(1, "25/11/2025"); // Codigo 1
            c1.setValor(350.00);
            c1.setMedico(m1); // Associa o médico objeto à consulta
            
            // O método inserir da DaoConsulta pede (Consulta, Paciente)
            daoConsulta.inserir(c1, p1);
            
            System.out.println("Consulta inserida com sucesso.");

            // ==================================================================
            // 4. Inserindo EXAMES e MEDICAÇÃO (Dependem da Consulta)
            // ==================================================================
            System.out.println("\n--- Inserindo Exames e Medicações ---");
            
            // Exame
            Exame e1 = new Exame(100, "Hemograma Completo");
            e1.setData("25/11/2025");
            e1.setHorario("14:30");
            e1.setValor(50.00);
            e1.setConsulta(c1); // Associa à consulta criada acima
            
            daoExame.inserir(e1);
            
            // Medicação
            Medicacao med1 = new Medicacao("Dipirona");
            med1.setDosagem("500mg");
            med1.setQtdeDias(5);
            
            // O DaoMedicacao pede (Medicacao, int codigoConsulta)
            daoMedicacao.inserir(med1, c1.getCodigo());
            
            System.out.println("Itens da consulta inseridos.");

            // ==================================================================
            // 5. TESTE DE CONSULTA (Leitura dos dados)
            // ==================================================================
            System.out.println("\n================ RELATÓRIO DO TESTE ================");
            
            // Buscando o paciente do banco
            Paciente pRetorno = daoPaciente.consultar("11111111111");
            if(pRetorno != null){
                System.out.println("Paciente Encontrado: " + pRetorno.getNome());
                
                // Listando as consultas desse paciente
                ArrayList<Consulta> listaConsultas = daoConsulta.listarConsultasPaciente(pRetorno.getCpf());
                
                for(Consulta c : listaConsultas){
                    System.out.println(" -> Consulta cód: " + c.getCodigo() + " | Data: " + c.getData());
                    System.out.println("    Médico responsável: " + c.getMedico().getNome());
                    
                    // Listando exames dessa consulta (Necessário setar o codigo na consulta recuperada se o DAO não trouxer preenchido, mas vamos testar o fluxo)
                    // Como o método listarConsultasPaciente preenche o básico, vamos garantir o codigo para buscar os exames
                    ArrayList<Exame> listaExames = daoConsulta.consultarExames(c);
                    for(Exame e : listaExames){
                        System.out.println("      * Exame: " + e.getDescricao() + " | R$ " + e.getValor());
                    }
                    
                    // Listando medicações
                    ArrayList<Medicacao> listaMeds = daoConsulta.consultarMedicacoes(c);
                    for(Medicacao med : listaMeds){
                        System.out.println("      * Medicação: " + med.getNome() + " (" + med.getDosagem() + ")");
                    }
                }
            } else {
                System.out.println("Erro: Paciente não encontrado.");
            }
            
            // Fechando conexão principal
            prepCon.fecharConexao();
        }
    }
}