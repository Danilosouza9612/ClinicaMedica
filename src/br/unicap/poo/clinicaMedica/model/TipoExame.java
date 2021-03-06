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

    public TipoExame() {
        this.codigo = 0;
    }
    private TipoExame(int codigo, TipoExame tipoExame){
        this.codigo=codigo;
        this.descricao=tipoExame.descricao;
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
    public TipoExame clonar(int codigo){
        return new TipoExame(codigo, this);
    }
}
