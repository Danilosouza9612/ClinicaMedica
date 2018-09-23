/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

/**
 *
 * @author Lucas Soares
 */
public class ExameView {
    
    private VerExameView verExameView;
    private AlterarExameView alterarExameView;
    
    
    public void menuExame(){
        Scanner l = new Scanner (System.in);
        int opcao;
        
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Exames\n2 - Reagendar exame\n3 - Alterar status\n4 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            
            switch(opcao){
                case 1:
                    verExameView = new VerExameView();
                    verExameView.menu();
                    break;
                case 2:
                    break;
                case 3:
                    alterarExameView = new AlterarExameView();
                    alterarExameView.menu();    
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 4);
    }
}
