/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import java.util.Date;

/**
 *
 * @author Brenan Wanderley
 */
public class Exame extends Agendamento implements Comparable<Exame>{
    private Consulta consulta;
    private TipoExame tipo;
    
    public Exame(int codigo, Date data, Consulta consulta, TipoExame tipo) throws AgendamentoException{
        super(codigo, data);
        this.tipo=tipo;
        this.consulta=consulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }
    public TipoExame getTipoExame() {
        return tipo;
    }
    public int compareTo(Exame exame){
        return super.compareTo(exame);
    }
}