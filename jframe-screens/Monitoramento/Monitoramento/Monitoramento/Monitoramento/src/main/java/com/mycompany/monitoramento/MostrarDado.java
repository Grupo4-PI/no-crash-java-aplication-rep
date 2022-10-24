/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guh_a
 */
public class MostrarDado extends javax.swing.JFrame {

    /**
     * Creates new form MostrarDado
     */
    public MostrarDado() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarTudo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        outputLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarTudo.setBackground(new java.awt.Color(66, 45, 16));
        mostrarTudo.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        mostrarTudo.setForeground(java.awt.Color.white);
        mostrarTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseicon.png"))); // NOI18N
        mostrarTudo.setText("Dados");
        mostrarTudo.setAlignmentY(0.0F);
        mostrarTudo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(131, 88, 32))); // NOI18N
        mostrarTudo.setBorderPainted(false);
        mostrarTudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarTudo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mostrarTudo.setDefaultCapable(false);
        mostrarTudo.setFocusPainted(false);
        mostrarTudo.setFocusable(false);
        mostrarTudo.setIconTextGap(12);
        mostrarTudo.setRequestFocusEnabled(false);
        mostrarTudo.setVerifyInputWhenFocusTarget(false);
        mostrarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTudoActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarTudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 121, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystems.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, 62));

        outputLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundImage.png"))); // NOI18N
        outputLogin.setText("jLabel1");
        getContentPane().add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTudoActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Looca looca = new Looca();

            Long emUso = looca.getMemoria().getDisponivel();
            Integer qtdDiscoJ = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
            Double usop = looca.getProcessador().getUso();
            String idMaquina = looca.getProcessador().getId();

            for (int i = 0; i < qtdDiscoJ; i++) {
                Disco disco = looca.getGrupoDeDiscos().getDiscos().get(i);
                String modelo = disco.getModelo();
                String serial = disco.getSerial();
                Long bytesEscrita = disco.getBytesDeEscritas();
                Long bytesLeitura = disco.getBytesDeLeitura();
                Long escritas = disco.getEscritas();
                Long leituras = disco.getLeituras();
                Long tamanho = disco.getTamanho() / 1000000000;
                Long tamanhoAtualFila = disco.getTamanhoAtualDaFila();
                Long tempoTransferencia = disco.getTempoDeTransferencia();

                Statement stm = con.createStatement();
                stm.execute("INSERT INTO Disco (modelo, serial, bytesEscrita, bytesLeitura, escritas, leituras, tamanho, tamanhoAtualFila, tempoTransferencia,  fkHardware) "
                        + "VALUES ('" + modelo + "','"  + serial + "','"  + bytesEscrita + "','" + bytesLeitura + "','" + escritas + "','" + leituras + "','" + tamanho + "','" + tamanhoAtualFila + "','" + tempoTransferencia + "','" + idMaquina + "')");
            }
            
            Statement stm = con.createStatement();
            stm.execute("INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkHardware) "
                    + "VALUES ('" + emUso + "','"  + usop + "','" + idMaquina + "')");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MostrarDado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrarTudoActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarDado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mostrarTudo;
    private javax.swing.JLabel outputLogin;
    // End of variables declaration//GEN-END:variables
}