/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guh_a
 */
public class DbMostrarDado {
     Looca looca = new Looca();

           private Long emUso = looca.getMemoria().getDisponivel();
            private Integer qtdDiscoJ = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
           private Double usop = looca.getProcessador().getUso();
         private   String idMaquina = looca.getProcessador().getId();
          private  Date horaAtual = new Date();
         private   String data = new SimpleDateFormat("dd/MM/yyyy"). format(horaAtual);

 

    public Long getEmUso() {
        return emUso;
    }

    public void setEmUso(Long emUso) {
        this.emUso = emUso;
    }

    public Integer getQtdDiscoJ() {
        return qtdDiscoJ;
    }

    public void setQtdDiscoJ(Integer qtdDiscoJ) {
        this.qtdDiscoJ = qtdDiscoJ;
    }

    public Double getUsop() {
        return usop;
    }

    public void setUsop(Double usop) {
        this.usop = usop;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Date getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(Date horaAtual) {
        this.horaAtual = horaAtual;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


   

            
            
}
