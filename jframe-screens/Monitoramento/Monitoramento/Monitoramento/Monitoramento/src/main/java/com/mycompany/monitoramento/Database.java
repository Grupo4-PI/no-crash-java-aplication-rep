/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author guh_a
 */
public class Database {
     private JdbcTemplate connection;


  // CONSTRUTOR

  public Database() {


    BasicDataSource dataSource = new BasicDataSource();

    dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");

    dataSource​.setUrl("jdbc:mysql://localhost:3306/NoCrash?allowPublicKeyRetrieval=true&useSSL=false");

    dataSource​.setUsername("root");

    dataSource​.setPassword("041096");


    this.connection = new JdbcTemplate(dataSource);

  }


  // GETTER

  public JdbcTemplate getConnection() {

    return connection;

  }
}
