/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoView {
    
    public MedicoView(){
        
    }
    public void menu(){
        int opcao;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("1 - Cadastrar Médico");
        System.out.println("2 - Ver Médico");
        System.out.println("3 - Voltar");
        do{
            System.out.println("..................................");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Ver Médico");
            System.out.println("3 - Voltar");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
    }
}
