/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class MenuPrincipal {
    private ProcedimentoView procedimentoView;
    private PacienteView pacienteView;
    private MedicoView medicoView;
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
      
        do{
            System.out.println("..................................");
            System.out.println();            
            System.out.println("1 - Exames\n2 - Consultas\n3 - Procedimentos\n4 - Pacientes\n5 - Médicos\n6 - Sair");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    procedimentoView = new ProcedimentoView();
                    procedimentoView.menuProcedimento();
                    break;
                case 4:
                    pacienteView = new PacienteView();
                    pacienteView.menu();
                    break;
                case 5:
                    medicoView = new MedicoView();
                    medicoView.menu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=6);
        
    }
}
