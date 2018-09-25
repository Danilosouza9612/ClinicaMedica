/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import java.text.DateFormat;

/**
 *
 * @author Malu Maranhão
 */
class ConsultaInfoView {
    public ConsultaInfoView(){
        
    }
    public void info(Consulta consulta){
        DateFormat df;
        System.out.println("..................................");
        System.out.println("Médico:"+consulta.getMedico().getNome());
        System.out.println("Paciente:"+consulta.getPaciente().getNome());
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data: " + df.format(consulta.getData()));
    }
    
}


    
    
