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
public class AlterarExameView {
    
    private AlterarTipoExameView alterarTipoExameVew;
    
    public AlterarExameView(){
        
    }
    
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Alterar exame\n2 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            
            switch(opcao){
                case 1:
                    alterarTipoExameVew = new AlterarTipoExameView();
                    alterarTipoExameVew.alterar();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 4);
    }
    
}
