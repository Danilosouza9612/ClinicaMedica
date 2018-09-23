/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import java.util.Date;

/**
 *
 * @author Brenan Wanderley
 */
public class Exame extends Agendamento{
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
}
