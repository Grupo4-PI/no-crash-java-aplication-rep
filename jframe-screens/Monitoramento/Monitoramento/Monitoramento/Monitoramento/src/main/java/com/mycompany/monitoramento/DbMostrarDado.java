package com.mycompany.monitoramento;

import com.github.britooo.looca.api.core.Looca;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.checkerframework.common.returnsreceiver.qual.This;

public class DbMostrarDado {

    Looca looca = new Looca();

    private Long emUso = looca.getMemoria().getDisponivel();
    private Long memoriaTotal = looca.getMemoria().getTotal();
    private Integer qtdDiscoJ = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
    private Double usop = looca.getProcessador().getUso();
    private String idMaquina = looca.getProcessador().getId();
    Date horaAtual = new Date();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(horaAtual);
    String hora = new SimpleDateFormat("HH:mm").format(horaAtual);

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Long getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(Long memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }
    
    public Double porcentoMemoria(){
        Double emUsoPorcento = ((emUso / 1024.0) / 1024.0) / 1024.0;
        Double memoriaTotalPorcento = ((memoriaTotal / 1024.0) / 1024.0) / 1024.0;
        
        //return (emUsoPorcento / memoriaTotalPorcento) * 100.0;
        return 3.0;
    }
}
