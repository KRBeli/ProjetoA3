package com.mycompany.Banco;

/**
 * A classe CadastroEvento representa um evento a ser cadastrado.
 * 
 * Cada evento possui um nome, uma descrição, uma data de início, uma data de fim, uma hora de início e uma hora de fim.
 * 
 * Os atributos podem ser acessados e modificados por meio de métodos getters e setters.
 */

public class CadastroEvento {
    private String nomeEvento, descricao, dataInicio, dataFim, horaInicio, horaFim;

    public CadastroEvento(){

    }
    public CadastroEvento(String nomeEvento,String descricao, String dataInicio, String dataFim, String horaInicio, String horaFim){
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio= horaInicio;
        this.horaFim = horaFim;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}
