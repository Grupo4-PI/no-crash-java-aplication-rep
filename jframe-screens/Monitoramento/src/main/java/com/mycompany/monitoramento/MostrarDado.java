package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class MostrarDado extends javax.swing.JFrame {

    private Timer timer;
    private String token = "";

    public MostrarDado(String token) {

        initComponents();
        this.timer = new Timer("Insert Disco");
        this.timer.schedule(new DiscoTask(token), 1_000, 10_000);
        this.timer.schedule(new DiscoTaskMySql(token), 1_000, 10_000);

        this.timer = new Timer("Insert Dados");
        this.timer.schedule(new DadoTask(token), 1_000, 10_000);
        this.timer.schedule(new DadoTaskMySql(token), 1_000, 10_000);
        this.token = token;
        System.out.println("estou na tela de mostrar dado e o token é o " + token);
    }

    public MostrarDado() {

        initComponents();
        this.timer = new Timer("Insert Disco");
        this.timer.schedule(new DiscoTask(token), 1_000, 10_000);
        this.timer.schedule(new DiscoTaskMySql(token), 1_000, 10_000);

        this.timer = new Timer("Insert Dados");
        this.timer.schedule(new DadoTask(token), 1_000, 10_000);
        this.timer.schedule(new DadoTaskMySql(token), 1_000, 10_000);
        System.out.println("estou na tela de mostrar dado e o token é o " + token);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarTudo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        outputLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarTudo.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        mostrarTudo.setForeground(new java.awt.Color(0, 96, 255));
        mostrarTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log.png"))); // NOI18N
        mostrarTudo.setAlignmentY(0.0F);
        mostrarTudo.setBorder(null);
        mostrarTudo.setBorderPainted(false);
        mostrarTudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarTudo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        mostrarTudo.setDefaultCapable(false);
        mostrarTudo.setFocusPainted(false);
        mostrarTudo.setFocusable(false);
        mostrarTudo.setIconTextGap(12);
        mostrarTudo.setOpaque(false);
        mostrarTudo.setRequestFocusEnabled(false);
        mostrarTudo.setVerifyInputWhenFocusTarget(false);
        mostrarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTudoActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarTudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 121, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystemsBlueLogo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 400, 62));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnLog.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 60));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Clique para gerar o seu Log:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 400, -1));

        outputLogin.setBackground(new java.awt.Color(255, 255, 255));
        outputLogin.setOpaque(true);
        getContentPane().add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTudoActionPerformed
        DbDado mdado = new DbDado();
        Looca looca = new Looca();
        mdado.setUsop(90.0);
        SqlCommands sql = new SqlCommands();

        if (mdado.getUsop() >= 70.0) {
            try {
                System.out.println(mdado.getUsop());
                String txtErro = "Uso do processador está em " + mdado.getUsop() + "% "
                        + mdado.getData() + " " + mdado.getHora() + "\n";
                File file = new File("hardware.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fileWritter = new FileWriter(file.getPath(), true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write(txtErro);
                bufferWritter.flush();
                bufferWritter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (mdado.porcentoMemoria() >= 70.0) {
            try {
                System.out.println(mdado.getUsop());
                String txtErro = "Uso da memória está em " + mdado.porcentoMemoria() + "% "
                        + mdado.getData() + " " + mdado.getHora() + "\n";
                File file = new File("hardware.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fileWritter = new FileWriter(file.getPath(), true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                bufferWritter.write(txtErro);
                bufferWritter.flush();
                bufferWritter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_mostrarTudoActionPerformed

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
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
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarDado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton mostrarTudo;
    private javax.swing.JLabel outputLogin;
    // End of variables declaration//GEN-END:variables
}
