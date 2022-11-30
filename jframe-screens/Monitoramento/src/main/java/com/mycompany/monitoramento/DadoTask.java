package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadoTask extends TimerTask {

    private SqlCommands comandos;
    private String token = "";
    
    public DadoTask(String token) {
        this.comandos = new SqlCommands();
        this.token = token;
    }

    @Override
    public void run() {
        try {
            DbDado mdado = new DbDado();
            System.out.println("executou dado");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://nocrash.database.windows.net:"
                    + "1433;database=NoCrash;encrypt=true;trustServerCertificate=false", "nocrash", "#Gfgrupo4");
            Statement stm = con.createStatement();
            System.out.println(mdado.getEmUso());
            stm.execute("INSERT INTO Dado (memoriaDisponivel , usoProcessador, fkDesktop) "
                    + "VALUES ('" + mdado.getEmUso() + "','" + mdado.getUsop() + "',' " + token + "');");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DadoTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
