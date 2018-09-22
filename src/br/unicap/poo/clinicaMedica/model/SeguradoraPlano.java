package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.repository.Repositable;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class SeguradoraPlano implements Repositable {
    private final int codigo;
    private String descricao;

    private SeguradoraPlano(int codigo) {
        this.codigo = codigo;
    }
    @Override
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    @Override
    public boolean equals(Object seguradoraPlano){
        SeguradoraPlano objeto = (SeguradoraPlano)seguradoraPlano;
        return objeto.codigo==this.codigo;
    }
}
