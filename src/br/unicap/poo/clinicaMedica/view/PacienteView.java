/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacienteView {
    private PacienteCadastrarView pacienteCadastrarView;
    private PacienteSelecionarView pacienteSelecionarView;
    private PacienteSelecaoView pacienteSelecaoView;
    private PacienteService service;
    public PacienteView(){
        pacienteCadastrarView = new PacienteCadastrarView();
        pacienteSelecionarView = new PacienteSelecionarView();
        pacienteSelecaoView = new PacienteSelecaoView();
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        Paciente selecao, novo;
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Selecionar Paciente");
            System.out.println("3 - Voltar");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }
            l.nextLine();
            switch(opcao){
                case 1:
                    novo=pacienteCadastrarView.cadastrarPaciente(false);
                    if(novo!=null){
                        service = PacienteService.getInstance();
                        service.cadastrarPaciente(novo);
                    }
                    break;
                case 2:
                    selecao = pacienteSelecionarView.selecionar(false);
                    if(selecao!=null){
                        pacienteSelecaoView.selecaoPaciente(selecao);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
        
    }
}
