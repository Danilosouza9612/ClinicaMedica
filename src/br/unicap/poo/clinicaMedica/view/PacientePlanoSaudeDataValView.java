/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacientePlanoSaudeDataValView {
    public PacientePlanoSaudeDataValView(){
        
    }
    
    public void alterarDataValidade(Paciente paciente){
        Calendar calendar = Calendar.getInstance();
        String dataString;
        String[] quebra;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite a data de validade (DD/MM/YYYY):");
        dataString = l.nextLine();
        quebra = dataString.split("/");
        calendar.set(Integer.parseInt(quebra[0]), Integer.parseInt(quebra[1]), Integer.parseInt(quebra[2]));
        paciente.getPlanoDeSaude().setDataValidade(calendar.getTime());
    }
}
