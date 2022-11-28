/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

/**
 *
 * @author guh_a
 */
import com.github.britooo.looca.api.core.Looca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author guh_a
 */
public class DiscoTaskMySql extends TimerTask{
    private Looca looca;
    private SqlCommands comandos;
    
    
    
     public DiscoTaskMySql() {
        this.comandos = new SqlCommands();
        this.looca = new Looca();
    }
    @Override
    public void run() {
        DbDado mdado = new DbDado();
    

        try {
            
         DatabaseMySql db = new DatabaseMySql();

           try {
                    for (int i = 0; i < mdado.getQtdDisco(); i++) {
                        db.inserirDisco(i);
                        System.out.println("Insert disco local");
                    }
                } catch (Exception ex) {
                    try {
                        for (int i = 0; i < mdado.getQtdDisco(); i++) {
                            
                            db.updateDisco(i);
                            System.out.println("update local");
                        }
                    } catch (Exception e) {
                        System.out.println("erro no disco local");
                    }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DadoTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
