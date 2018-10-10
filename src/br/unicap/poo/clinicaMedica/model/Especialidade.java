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
public class Especialidade{
    private final int codigo;
    private String descricao;

    public Especialidade(int codigo) {
        this.codigo = codigo;
    }
    private Especialidade(int codigo, Especialidade especialidade){
        this.codigo=codigo;
        this.descricao=especialidade.descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    public Especialidade clonar(int codigo){
        return new Especialidade(codigo, this);
    }
}
