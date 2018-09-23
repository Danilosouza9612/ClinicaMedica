/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class AgendamentoHoraView {
    public AgendamentoHoraView(){
        
    }
    public boolean horaAgendamento(Date date){
        Calendar calendar;
        String dataString;
        String[] quebra;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite a hora (XX:XX) (FIM para Sair):");
        dataString = l.nextLine();
        if(dataString.equalsIgnoreCase("FIM")){
            return false;
        }
        quebra = dataString.split(":");
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(quebra[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(quebra[1]));
        
        return true;
    }
}
