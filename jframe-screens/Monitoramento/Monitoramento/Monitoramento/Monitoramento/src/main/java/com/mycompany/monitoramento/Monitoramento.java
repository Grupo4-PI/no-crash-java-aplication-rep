/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.monitoramento;

/**
 *
 * @author guh_a
 */
public class Monitoramento {

    public static void main(String[] args) {
        
        Login login = new Login();
        
        login.show();
       /* create database mydb;

use mydb;

create table login(
username varchar(80),
senha varbinary(15)
);

insert into login(username, senha) values ('opa','123');

select * from login;

create table sistema(
idSistema int primary key auto_increment,
arquiteturaBD int, 
frabricanteBD varchar(80),
inicializadoBD varchar(80),
permissaoBD varchar(80),
tempoEmAtividadeBD varchar(80), 
sistemaOperacionalBD varchar(80)
);
select * from processador;
create table processador(
idPorcessador int primary key auto_increment,
nomeProcessadorBD varchar(80), 
frabricanteBD varchar(80),
frequenciaBd varchar(80), 
idMaquinaBD varchar(80),
 identificadorBD varchar(80),
 cpuFisicaBD int,
 cpuLogicaBD int,
 pacoteFisicoBD int,
 microBD varchar(80), 
 usoBD decimal(10,2)
);
select * from processador;
Create table disco (


IdDisco int primary key AUTO_INCREMENT,
qtdDiscoBD int,
discoAtualBD varchar(1600),
qtdVolumeBD int,
volumeBD VARCHAR(1000)


);

select * from disco;
drop table disco;

Create table memoria (

idMemoria int primary key AUTO_INCREMENT,
disponivelBD decimal,
emUsoBD decimal,
totalBD decimal
);

select * from memoria;-*/






        
    }
}
