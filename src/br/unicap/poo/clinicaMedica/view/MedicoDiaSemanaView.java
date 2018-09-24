/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.DiaSemana;
import br.unicap.poo.clinicaMedica.model.Horario;
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
            System.out.println("1 - Domingo\n2 - Segunda\n3 - Terça\n4 - Quarta\n5 - Quinta\n6 - Sexta\n7 - Sábado");
            System.out.println("Escolha uma Opção (Digite -1) para sair:");
            try{
                diaSemana=l.nextInt();
                if(diaSemana==-1){
                    return false;
                }
            }catch(java.util.InputMismatchException ex){
                diaSemana=0;
            }
            l.nextLine();
            switch(diaSemana){
                case 1:
                    horario.setDiaSemana(DiaSemana.DOMINGO);
                    break;
                case 2:
                    horario.setDiaSemana(DiaSemana.SEGUNDA);
                    break;
                case 3:
                    horario.setDiaSemana(DiaSemana.TERCA);
                    break;
                case 4:
                    horario.setDiaSemana(DiaSemana.QUARTA);
                    break;
                case 5:
                    horario.setDiaSemana(DiaSemana.QUINTA);
                    break;
                case 6:
                    horario.setDiaSemana(DiaSemana.SEXTA);
                    break;    
                case 7:
                    horario.setDiaSemana(DiaSemana.SABADO);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while(!valido);
        return true;
    }
        
}
