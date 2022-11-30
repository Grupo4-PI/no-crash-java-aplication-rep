package com.mycompany.monitoramento;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Token extends javax.swing.JFrame {

    public Token() {
        initComponents();
        setResizable(false);
        setTitle("HardSystems | Token Insert");
        URL caminhoImagem;
        Image iconeTitulo;
        caminhoImagem = this.getClass().getClassLoader().getResource("logoHS.png");
        iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        TokenInserido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoToken = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        outputLogin = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TokenInserido.setBackground(new java.awt.Color(222, 222, 222));
        TokenInserido.setFont(new java.awt.Font("Gadugi", 0, 15)); // NOI18N
        TokenInserido.setActionCommand("<Not Set>");
        TokenInserido.setAlignmentX(0.0F);
        TokenInserido.setAlignmentY(0.0F);
        TokenInserido.setBorder(null);
        TokenInserido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TokenInseridoActionPerformed(evt);
            }
        });
        getContentPane().add(TokenInserido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 316, 20));

        jLabel2.setBackground(new java.awt.Color(151, 101, 37));
        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Insira o Token da Máquina:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, 30));

        botaoToken.setBackground(new java.awt.Color(255, 255, 255));
        botaoToken.setFont(new java.awt.Font("Gadugi", 1, 15)); // NOI18N
        botaoToken.setForeground(new java.awt.Color(0, 96, 255));
        botaoToken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verify.png"))); // NOI18N
        botaoToken.setText("Verificar");
        botaoToken.setAlignmentY(0.0F);
        botaoToken.setBorder(null);
        botaoToken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoToken.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        botaoToken.setDefaultCapable(false);
        botaoToken.setFocusPainted(false);
        botaoToken.setFocusable(false);
        botaoToken.setIconTextGap(12);
        botaoToken.setRequestFocusEnabled(false);
        botaoToken.setVerifyInputWhenFocusTarget(false);
        botaoToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTokenActionPerformed(evt);
            }
        });
        getContentPane().add(botaoToken, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 121, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HardSystemsBlueLogo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnLog.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, 60));

        outputLogin.setBackground(new java.awt.Color(255, 255, 255));
        outputLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 96, 255)));
        outputLogin.setOpaque(true);
        getContentPane().add(outputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TokenInseridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TokenInseridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TokenInseridoActionPerformed

    private void botaoTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTokenActionPerformed
        // TODO add your handling code here: String emailUsuario = textLogin.getText();
        DbDado dbMostrarDado = new DbDado();
        String token = TokenInserido.getText();
        SqlCommands sql = new SqlCommands();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:"
                    + "1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql.selectDesktop(token));

            if (rs.next()) {
                dispose();
                MostrarDado page = new MostrarDado(token);
                page.show();

                ResultSet verificarHardware = stm.executeQuery(sql.selectHardware(token));

                String sqlInsert = verificarHardware.next() ? sql.updateHardware(token) : sql.insertHardware(token);

                stm.execute(sqlInsert);

                try {
                    DatabaseMySql db = new DatabaseMySql();
                   
                    try {
                        db.insertHardware(token);
                    } catch (Exception ex) {
                        try {
                            try {
                                db.updateHardware(token);
                            } catch (Exception e) {
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("\n| Erro ao conectar com o MySql |\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Token Inválido!");
                TokenInserido.setText("");

                try {
                    String txtErro = "Token Inválido! " + dbMostrarDado.getData() + " " + dbMostrarDado.getHora() + "\n";
                    File file = new File("autenticacao.txt");

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
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            if (token.length() == 0) {
                outputLogin.setText("Preencha o campo...");
            } else {
                outputLogin.setText("Usuário ou senha incorretos...");
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_botaoTokenActionPerformed

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
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Token().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TokenInserido;
    private javax.swing.JButton botaoToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel outputLogin;
    // End of variables declaration//GEN-END:variables
}
