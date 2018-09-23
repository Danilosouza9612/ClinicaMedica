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
public class PacienteSelecaoView {
    private PacienteAlterarView pacienteAlterarView;
    private PacienteExcluirView pacienteExcluirView;
    private PacienteInfoView info;
    public PacienteSelecaoView(){
        pacienteAlterarView = new PacienteAlterarView();
        pacienteExcluirView = new PacienteExcluirView();        
    }
    
    public void selecaoPaciente(Paciente paciente){
        Scanner l = new Scanner(System.in);
        int opcao;
        
        info = new PacienteInfoView();
        info.info(paciente);
        
        
        do{
            System.out.println("1 - Alterar Paciente");
            System.out.println("2 - Remover Paciente");
            System.out.println("3 - Voltar");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    pacienteAlterarView.alterar(paciente);
                    info.info(paciente);
                    break;
                case 2:
                    if(pacienteExcluirView.excluirPaciente(paciente)){
                        return;
                    }
                    info.info(paciente);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
        
    }
}
