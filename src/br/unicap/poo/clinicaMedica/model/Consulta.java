/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioIndisponivelException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Brenan Wanderley
 */
public class Consulta extends Agendamento{
    private Medico medico;
    private ArrayList<Exame> exames;
    private ArrayList<ProcedimentoMedico> procedimentos;
    private Paciente paciente;
    
    public Consulta(int codigo, Date data, Medico medico, Paciente paciente) throws AgendamentoException, HorarioIndisponivelException{
        super(codigo, data);
        this.medico=medico;
        this.paciente=paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public ArrayList<ProcedimentoMedico> getProcedimentos() {
        return procedimentos;
    }
    public Paciente getPaciente() {
        return paciente;
    }
}
