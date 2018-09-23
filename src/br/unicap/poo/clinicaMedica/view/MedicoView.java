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
    private MedicoCadastroView medicoCadastroView;
    private EspecialidadeView especialidadeView;
    private MedicoVerView medicoVerView;
    
    public MedicoView(){
        medicoCadastroView = new MedicoCadastroView();
        especialidadeView = new EspecialidadeView();
        medicoVerView = new MedicoVerView();
    }
    public void menu(){
        int opcao;
        Scanner l = new Scanner(System.in);
        do{
            System.out.println("..................................");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Ver Médico");
            System.out.println("3 - Gerenciar Especialidades de Médico");
            System.out.println("4 - Voltar");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    medicoCadastroView.cadastrar();
                    break;
                case 2:
                    medicoVerView.verMedicos();
                    break;
                case 3:
                    especialidadeView.menu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=4);
    }
}
