/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class PlanoDeSaude {
    private SeguradoraPlano seguradoraPlano;
    private String numeroCarteira;
    private Date dataValidade;

    public PlanoDeSaude(SeguradoraPlano seguradoraPlano, String numeroCarteira, Date dataValidade) {
        this.seguradoraPlano = seguradoraPlano;
        this.numeroCarteira = numeroCarteira;
        this.dataValidade = dataValidade;
    }

    public SeguradoraPlano getSeguradoraPlano() {
        return seguradoraPlano;
    }

    public void setSeguradoraPlano(SeguradoraPlano seguradoraPlano) {
        this.seguradoraPlano = seguradoraPlano;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    
}
