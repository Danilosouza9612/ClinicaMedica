/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacienteDataNascimentoView {
    public PacienteDataNascimentoView(){
        
    }
    public void alterarDataNascimento(Paciente paciente){
        Calendar calendar;
        String dataString;
        String[] quebra;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite a data de nascimento (DD/MM/YYYY):");
        dataString = l.nextLine();
        quebra = dataString.split("/");
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(quebra[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(quebra[1])-1);
        calendar.set(Calendar.YEAR, Integer.parseInt(quebra[2]));
        paciente.setDataNasc(calendar.getTime());
    }
}