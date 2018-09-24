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
    private ConsultaView consultaView;
    private ExameView exameView;
    private SeguradoraPlanoView seguradoraView;
    
    public MenuPrincipal(){
        procedimentoView = new ProcedimentoView();
        pacienteView = new PacienteView();
        medicoView = new MedicoView();
        consultaView = new ConsultaView();
        exameView = new ExameView();
        seguradoraView = new SeguradoraPlanoView();
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao=0;
      
        do{
            System.out.println("..................................");
            System.out.println();            
            System.out.println("1 - Exames\n2 - Consultas\n3 - Procedimentos\n4 - Pacientes\n5 - Médicos\n6 - Seguradoras de Plano de Saúde atendidas\n7 - Sair");
            System.out.println("Digite uma opção:");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }
            l.nextLine();
            switch(opcao){
                case 1:
                    exameView.menuExame();
                    break;
                case 2:
                    consultaView.menu();
                    break;
                case 3:
                    procedimentoView.menuProcedimento();
                    break;
                case 4:
                    pacienteView.menu();
                    break;
                case 5:
                    medicoView.menu();
                    break;
                case 6:
                    seguradoraView.menu();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=7);
        
    }
}
