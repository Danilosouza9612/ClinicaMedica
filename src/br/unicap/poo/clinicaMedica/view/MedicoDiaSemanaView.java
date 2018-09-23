/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioMedicoDiaSemanaInvalido;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoDiaSemanaView {
    
    public MedicoDiaSemanaView(){
        
    }
    public boolean alterarDiaSemana(Horario horario){
        Scanner l = new Scanner(System.in);
        int diaSemana;
        boolean valido;
        
        do{
            valido=true;
            System.out.println("Escolha o dia da semana do Médico(Digite -1 para Sair)");
            System.out.println("1 - Segunda\n2 - Terça\n3 - Quarta\n4 - Quinta\n5 - Sexta");
            diaSemana=l.nextInt();
            
            if(diaSemana==-1){
                return false;
            }
            
            try {
                horario.setDiaSemana(diaSemana);
                return true;
            } catch (HorarioMedicoDiaSemanaInvalido ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);
        return false;
    }
        
}
