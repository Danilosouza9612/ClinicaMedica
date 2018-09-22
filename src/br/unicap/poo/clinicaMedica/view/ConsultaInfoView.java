/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;

/**
 *
 * @author caio Maranhão
 */
class ConsultaInfoView {
    public ConsultaInfoView(){
        
    }
    public void info(Consulta consulta){
        System.out.println("..................................");
        System.out.println("Médico:"+consulta.getMedico());
        System.out.println("Exame:"+consulta.getExames());
        System.out.println("Paciente:"+consulta.getPaciente());
        System.out.println("Procedimento: " + consulta.getProcedimentos());
    }
    
}


    
    
