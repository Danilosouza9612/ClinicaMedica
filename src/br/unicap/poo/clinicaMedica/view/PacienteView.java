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
public class PacienteView {
    private PacienteCadastrarView pacienteCadastrarView;
    private PacienteSelecionarView pacienteSelecionarView;
    public PacienteView(){
        
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Pré-cadastrar Paciente");
            System.out.println("3 - Selecionar Paciente");
            System.out.println("4 - Voltar");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    pacienteCadastrarView = new PacienteCadastrarView();
                    pacienteCadastrarView.cadastrarPaciente(false);
                    break;
                case 2:
                    pacienteCadastrarView = new PacienteCadastrarView();
                    pacienteCadastrarView.cadastrarPaciente(true);
                    break;
                case 3:
                    pacienteSelecionarView = new PacienteSelecionarView();
                    pacienteSelecionarView.selecionar();
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=4);
        
    }
}
