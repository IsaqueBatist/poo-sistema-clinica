/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.DaoConsulta;
import fatec.poo.control.DaoMedicacao;
import fatec.poo.control.DaoPaciente;
import fatec.poo.control.PreparaConexao;
import fatec.poo.model.Consulta;
import fatec.poo.model.Medicacao;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Victorleonardo
 */
public class GuiPrescreverMedicacao extends javax.swing.JFrame {

    /**
     * Creates new form GuiPrescreverMedicacao
     */
    public GuiPrescreverMedicacao() {
        initComponents();
       // === PREPARA A CONEXÃO COM ACCESS ===
    PreparaConexao pc = new PreparaConexao("", ""); // Access não usa usuário/senha
    pc.setDriver("net.ucanaccess.jdbc.UcanaccessDriver");
    pc.setConnectionString("jdbc:ucanaccess://C:\\Users\\Victorleonardo\\Documents\\NetBeansProjects\\prjPOOBeatrizIsaqueVictor\\src\\fatec\\poo\\basededados\\DBClinica.accdb");

    Connection conn = pc.abrirConexao();

    daoConsulta = new DaoConsulta(conn);
    daoMedicacao = new DaoMedicacao(conn);

    txtCodigoConsulta.setEnabled(false);
    btnCodigoConsulta.setEnabled(false);
    txtDosagem.setEnabled(false);
    txtQuantidadeDias.setEnabled(false);
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCodigoConsulta = new javax.swing.JLabel();
        lblDosagem = new javax.swing.JLabel();
        lblQuantidadeDias = new javax.swing.JLabel();
        txtCodigoConsulta = new javax.swing.JTextField();
        txtDosagem = new javax.swing.JTextField();
        txtQuantidadeDias = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnCodigoConsulta = new javax.swing.JButton();
        lblMedicoTexto = new javax.swing.JLabel();
        lblMedico = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prescrever Medicação");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setText("Nome");

        lblCodigoConsulta.setText("Código Consulta ");

        lblDosagem.setText("Dosagem");

        lblQuantidadeDias.setText("Quantidade Dias");

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnCodigoConsulta.setText("...");
        btnCodigoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoConsultaActionPerformed(evt);
            }
        });

        lblMedicoTexto.setText("Médico");

        lblMedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigoConsulta)
                    .addComponent(lblNome)
                    .addComponent(lblDosagem)
                    .addComponent(lblQuantidadeDias))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQuantidadeDias, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtCodigoConsulta)
                    .addComponent(txtDosagem))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnCodigoConsulta)
                .addGap(18, 18, 18)
                .addComponent(lblMedicoTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMedico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigoConsulta)
                        .addComponent(txtCodigoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCodigoConsulta)
                        .addComponent(lblMedicoTexto)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDosagem)
                    .addComponent(txtDosagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadeDias)
                    .addComponent(txtQuantidadeDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
  
    medicacao = new Medicacao(txtNome.getText());
  
    medicacao.setDosagem(txtDosagem.getText());
    medicacao.setQtdeDias(Integer.parseInt(txtQuantidadeDias.getText()));
    
    daoMedicacao.inserir(medicacao, Integer.parseInt(txtCodigoConsulta.getText()));
    
    JOptionPane.showMessageDialog(this, "Medicação cadastrada com sucesso!");
   
    txtNome.setText(null);
    txtDosagem.setText(null);
    txtQuantidadeDias.setText(null);
    txtCodigoConsulta.setText(null);
    
    txtNome.setEnabled(false);
    txtDosagem.setEnabled(false);
    txtQuantidadeDias.setEnabled(false);
    txtCodigoConsulta.setEnabled(true);
    
    txtCodigoConsulta.requestFocus();
   
    btnInserir.setEnabled(false);
    btnAlterar.setEnabled(false);
    btnExcluir.setEnabled(false);
    btnConsultar.setEnabled(true);

    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
         if (JOptionPane.showConfirmDialog(null, "Confirma Alteração?") == 0) { 
        
        medicacao.setDosagem((txtDosagem.getText()));
        medicacao.setQtdeDias(Integer.parseInt(txtQuantidadeDias.getText()));

        daoMedicacao.alterar(medicacao, Integer.parseInt(txtCodigoConsulta.getText()));
    }

    txtNome.setText(null);
    txtCodigoConsulta.setText(null);
    txtDosagem.setText(null);
    txtQuantidadeDias.setText(null);

    lblMedico.setText(null);

    
    txtNome.setEnabled(true);
    txtCodigoConsulta.setEnabled(true);
    btnCodigoConsulta.setEnabled(true);

    txtDosagem.setEnabled(false);
    txtQuantidadeDias.setEnabled(false);

    btnConsultar.setEnabled(true);
    btnInserir.setEnabled(false);
    btnAlterar.setEnabled(false);
    btnExcluir.setEnabled(false);

    txtNome.requestFocus();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão?") == 0) {
        daoMedicacao.excluir(medicacao.getNome());
    }

    txtNome.setText("");
    txtCodigoConsulta.setText("");
    txtDosagem.setText("");
    txtQuantidadeDias.setText("");

    lblMedico.setText("");

    txtNome.setEnabled(true);          
    txtCodigoConsulta.setEnabled(false);
    btnCodigoConsulta.setEnabled(false);

    txtDosagem.setEnabled(false);
    txtQuantidadeDias.setEnabled(false);

    txtNome.requestFocus();

    btnConsultar.setEnabled(true);
    btnInserir.setEnabled(false);
    btnAlterar.setEnabled(false);
    btnExcluir.setEnabled(true);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prepCon = new PreparaConexao("", "");
        prepCon.setDriver("net.ucanaccess.jdbc.UcanaccessDriver");
        prepCon.setConnectionString("jdbc:ucanaccess://C:\\Users\\Victorleonardo\\Documents\\NetBeansProjects\\prjPOOBeatrizIsaqueVictor\\src\\fatec\\poo\\basededados\\DBClinica.accdb");

        Connection conn = prepCon.abrirConexao();
        
        daoMedicacao = new DaoMedicacao(conn);
        daoPaciente = new DaoPaciente(conn);
        daoConsulta = new DaoConsulta(conn);
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        prepCon.fecharConexao();
    }//GEN-LAST:event_formWindowOpened

    private void btnCodigoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoConsultaActionPerformed
        
    consulta = daoConsulta.consultar(Integer.parseInt(txtCodigoConsulta.getText()));

    if (consulta == null) {  
        JOptionPane.showMessageDialog(this, "Consulta não cadastrada");
        txtCodigoConsulta.requestFocus();
        return;
    } 
    
    lblMedico.setText(consulta.getMedico().getNome());

    txtCodigoConsulta.setEnabled(false);
    btnCodigoConsulta.setEnabled(false);

    txtNome.setEnabled(true);
    txtDosagem.setEnabled(true);
    txtQuantidadeDias.setEnabled(true);
    txtNome.requestFocus();

    }//GEN-LAST:event_btnCodigoConsultaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        medicacao = daoMedicacao.consultar(
            txtNome.getText(),
            Integer.parseInt(txtCodigoConsulta.getText())
    );

    if (medicacao == null) {
        JOptionPane.showMessageDialog(this, "Medicação não cadastrada.");
        btnInserir.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);

        txtDosagem.setText(null);
        txtQuantidadeDias.setText(null);

        txtDosagem.setEnabled(true);
        txtQuantidadeDias.setEnabled(true);
        txtDosagem.requestFocus();

    } else {
        txtDosagem.setText(medicacao.getDosagem());
        txtQuantidadeDias.setText(String.valueOf(medicacao.getQtdeDias()));

        btnInserir.setEnabled(false);
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);

        txtDosagem.setEnabled(true);
        txtQuantidadeDias.setEnabled(true);
        txtDosagem.requestFocus();
    }
    }//GEN-LAST:event_btnConsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiPrescreverMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiPrescreverMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiPrescreverMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiPrescreverMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiPrescreverMedicacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCodigoConsulta;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblCodigoConsulta;
    private javax.swing.JLabel lblDosagem;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblMedicoTexto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidadeDias;
    private javax.swing.JTextField txtCodigoConsulta;
    private javax.swing.JTextField txtDosagem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidadeDias;
    // End of variables declaration//GEN-END:variables

    private PreparaConexao prepCon;
    private DaoConsulta daoConsulta;
    private DaoMedicacao daoMedicacao;
    private Consulta consulta;
    private Medicacao medicacao;
    private Connection conn;
    private DaoPaciente daoPaciente;
}
