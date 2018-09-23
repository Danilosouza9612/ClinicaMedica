/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;


/**
 *
 * @author aluno
 */
public class TipoExame{
    private final int codigo;
    private String descricao;

    public TipoExame(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
