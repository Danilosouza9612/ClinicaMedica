/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import java.text.DateFormat;
/**
 *
 * @author aluno
 */
class ProcedimentoInfoView {
    public ProcedimentoInfoView(){
    }
    
    
    public void info(ProcedimentoMedico procedimento ){
         DateFormat df;
        System.out.println("..................................");
        System.out.println("Médico:"+procedimento.getMedico().getNome());
        System.out.println("Paciente:"+procedimento.getPaciente().getNome());
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data: " + df.format(procedimento.getData()));
        System.out.println("Tipo: " + procedimento.getTipoProcedimento().getDescricao());
    }
}
