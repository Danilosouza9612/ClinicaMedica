/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;

/**
 *
 * @author aluno
 */
public class ProcedimentoView {
    private TipoProcedimentoView tipoProcedimentoView;
    private ProcedimentoVerView procedimentoVerView;
    private ProcedimentoMedicoSelecionarView procedimentoSelecionarView;
    private MedicoSelecionarView medicoSelecao;
    private AgendamentoDataView dataSelecao;
    private AgendamentoHoraView horaSelecao;
    private ProcedimentoMedicoService service;
    private PacienteSelecionarView pacienteSelecao;
    private MedicoListaView listaMedico;;
    
    public ProcedimentoView(){
        tipoProcedimentoView = new TipoProcedimentoView();
        procedimentoVerView = new ProcedimentoVerView();
        procedimentoSelecionarView = new ProcedimentoMedicoSelecionarView();
        medicoSelecao = new MedicoSelecionarView();
        dataSelecao = new AgendamentoDataView();
        pacienteSelecao = new PacienteSelecionarView();
        horaSelecao = new AgendamentoHoraView();
        listaMedico = new MedicoListaView();
        service = ProcedimentoMedicoService.getInstance();
        
        
        
        
        
        
    }
    
    
    public void menuProcedimento(){
        Scanner l = new Scanner (System.in);
        int opcao;
        
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("..................................");
            System.out.println("1 - Ver Procedimentos Médicos por data");
            System.out.println("2 - Ver Procedimentos Médicos por médico");
            System.out.println("3 - Ver Procedimentos Médicos por data e médico");
            System.out.println("4 - Gerenciar Tipos de Procedimentos Médicos");
            System.out.println("5 - Voltar");
            System.out.println("Digite uma opção:");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            
            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:  
                    break;
                case 4:
                    tipoProcedimentoView.menu();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 4);
    }
}
