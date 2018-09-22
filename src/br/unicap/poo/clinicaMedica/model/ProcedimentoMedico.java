/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.ProcedimentoMedicoException;
import java.util.Date;

/**
 *
 * @author Brenan Wanderley
 */
public class ProcedimentoMedico extends Agendamento implements Comparable<ProcedimentoMedico>{
    public Consulta consulta;
    public TipoProcedimento tipo;

    public ProcedimentoMedico(int codigo, Date data, Consulta consulta, TipoProcedimento tipo) throws AgendamentoException, ProcedimentoMedicoException {
        super(codigo, data);
        if(this.consulta==null){
            throw new ProcedimentoMedicoException("Informe a Consulta");
        }
        this.consulta = consulta;
        if(this.tipo==null){
            throw new ProcedimentoMedicoException("Informe o tipo de procedimento");
        }
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public TipoProcedimento getTipoProcedimento() {
        return tipo;
    }
    @Override
    public int compareTo(ProcedimentoMedico procedimentoMedico){
        return super.compareTo(procedimentoMedico);
    }
}
