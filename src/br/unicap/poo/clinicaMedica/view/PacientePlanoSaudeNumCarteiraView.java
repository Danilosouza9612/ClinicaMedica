/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacientePlanoSaudeNumCarteiraView {
    public PacientePlanoSaudeNumCarteiraView(){
        
    }
    
    public boolean alterarNumeroCarteiraPlano(Paciente paciente){
        String numCarteira;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite o número da carteira (Digite FIM para sair):");
        numCarteira = l.nextLine();
        if(numCarteira.equalsIgnoreCase("FIM")){
            return false;
        }
        paciente.getPlanoDeSaude().setNumeroCarteira(numCarteira);
        return true;
    }
}
