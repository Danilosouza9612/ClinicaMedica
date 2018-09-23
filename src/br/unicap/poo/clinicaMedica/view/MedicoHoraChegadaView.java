/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioChegadaInvalidoException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class MedicoHoraChegadaView {
    
    public MedicoHoraChegadaView(){
        
    }
    public boolean alterarHoraChegada(Horario horario){
        Scanner l = new Scanner(System.in);
        int chegada;
        boolean valido;
        
        do{
            valido=true;
            System.out.println("Digite a hora de chegada (Digite -1 para Sair)");
            try{
               chegada=l.nextInt();
               if(chegada==-1){
                   return false;
               }

               try {
                   horario.setChegada(chegada);
                   return true;
               } catch (HorarioChegadaInvalidoException ex) {
                   System.out.println(ex.getMessage());
               }
            }catch(java.util.InputMismatchException ex){
                System.out.println("Horário Inválido");
                valido=false;
            }           
            l.nextLine();            

        }while(!valido);
        return false;
    }
}
