/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioSaidaInvalidoException;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoHoraSaidaView {
    
    public MedicoHoraSaidaView(){
        
    }
    public boolean alterarHoraSaída(Horario horario){
        Scanner l = new Scanner(System.in);
        int saida;
        boolean valido;
        
        do{
            valido=true;
            System.out.println("Digite a hora de saída (Digite -1 para Sair)");
            saida=l.nextInt();
            
            if(saida==-1){
                return false;
            }
            
            try {
                horario.setSaida(saida);
                return true;
            } catch (HorarioSaidaInvalidoException ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);
        return false;
    }
    
}
