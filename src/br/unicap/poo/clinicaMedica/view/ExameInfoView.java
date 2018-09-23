/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Exame;
import java.text.DateFormat;

/**
 *
 * @author Brenan Wanderley
 */
class ExameInfoView {
    public ExameInfoView(){
        
    }
    public void info(Exame exame){
        DateFormat df;
        System.out.println("..................................");
        System.out.println("Médico:"+exame.getMedico());
        System.out.println("Paciente:"+exame.getPaciente().getNome());
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data: " + df.format(exame.getData()));
    }
}
