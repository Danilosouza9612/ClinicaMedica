/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgendamentoReagendarView {

    public AgendamentoReagendarView() {
    }
    
    
    public Date reagendar(){
        Calendar calendar;
        String dataString;
        String[] quebra;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite a data (DD/MM/YYYY) (FIM para Sair):");
        dataString = l.nextLine();
        if(dataString.equalsIgnoreCase("FIM")){
            return null;
        }
        quebra = dataString.split("/");
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(quebra[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(quebra[1])-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(quebra[2]));
        return calendar.getTime();
    }
    
}
