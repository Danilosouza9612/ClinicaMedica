/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Status;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Scanner;

/**
 *
 * @author Malu Maranhão
 */
public class AgendamentoAlterarStatusView {
    private ConsultaService service;
    public AgendamentoAlterarStatusView() {
    }
    
    public boolean alterarStatus(Agendamento agendamento){
        int opcao;
        Scanner l = new Scanner(System.in);
        do{
            System.out.println("Selecione o Status (Digite -1 para Voltar):");
            System.out.println("1 - Agendada\n2 - Realizada");
            System.out.println("Digite uma opção");
            opcao=l.nextInt();
            switch(opcao){
                case 1:
                    agendamento.setStatus(Status.AGENDADA);
                    return true;
                case 2:
                    agendamento.setStatus(Status.REALIZADA);
                    return true;
                case -1:
                    return false;
                default:
                    System.out.println("Opção inválida");
            }
            
        }while(opcao!=-1);
        return true;
    }
    
}
