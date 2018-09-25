/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
class ProcedimentoSelecaoView {
    private AgendamentoDataView dataAgendamento;
    private ProcedimentoCancelarView procedimentoCancelarView;
    private AgendamentoAlterarStatusView procedimentoAlterarView;
    private ProcedimentoInfoView info;
    private ProcedimentoListaView listaProcedimentoView;
    private TipoProcedimentoSelecionarView selecionarTipoProcedimento;
    private ProcedimentoListaView listaTipoProcedimento;
    private ProcedimentoMedicoSelecionarView selecionarProcedimento;
    
    public ProcedimentoSelecaoView(){
        dataAgendamento = new AgendamentoDataView();
        procedimentoAlterarView = new AgendamentoAlterarStatusView();
        procedimentoCancelarView = new ProcedimentoCancelarView();
        listaProcedimentoView = new ProcedimentoListaView();
        selecionarProcedimento = new ProcedimentoMedicoSelecionarView();
        listaProcedimentoView = new ProcedimentoListaView();
        selecionarTipoProcedimento = new TipoProcedimentoSelecionarView();
        info = new ProcedimentoInfoView();
    }
    
    public void selecaoProcedimento(ProcedimentoMedico procedimento){
        Scanner l = new Scanner(System.in);
        int opcao;
        Date data;
        boolean valido;
        
        info.info(procedimento);
        
        
        do{
            System.out.println("1 - Reagendar Procedimento");
            System.out.println("2 - Cancelar Procedimento");
            System.out.println("3 - Alterar status");
            System.out.println("4 - sair");

            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    do{
                        data = dataAgendamento.dataAgendamento();
                        valido=true;
                        if(data!=null){
                            try {
                                procedimento.setData(data);
                            } catch (DataInvalidaException ex) {
                                System.out.println(ex.getMessage());
                                valido=false;
                            }
                        }
                    }while(!valido);
                    info.info(procedimento);                    
                    break;
                    
                case 2:
                    if(procedimentoCancelarView.cancelarProcedimento(procedimento)){
                        return;
                    }
                    info.info(procedimento);
                    break;
                    
                case 3:
                    if(procedimentoAlterarView.alterarStatus(procedimento)){
                        info.info(procedimento);
                    }
                    break;
                    
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=4);
        
    }
}
