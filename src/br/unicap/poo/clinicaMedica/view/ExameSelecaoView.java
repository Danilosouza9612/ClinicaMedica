/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.Status;
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.util.Scanner;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenan Wanderley
 */
public class ExameSelecaoView {
    private AgendamentoDataView dataAgendamento;
    private ExameCancelarView exameCancelarView;
    private AgendamentoAlterarStatusView exameAlterarView;
    private ExameInfoView info;
    private ListaTipoExameView listaTipoExame;
    private TipoExameSelecionarView selecionarTipoExame;
    private ListaTipoProcedimentosView listaTipoProcedimento;
    private TipoProcedimentoSelecionarView selecionarTipoProcedimento;
    
    public ExameSelecaoView(){
        dataAgendamento = new AgendamentoDataView();
       // consultaCancelarView = new ConsultaCancelarView();
        exameAlterarView = new AgendamentoAlterarStatusView();
        exameCancelarView = new ExameCancelarView();
        listaTipoExame = new ListaTipoExameView();
        selecionarTipoExame = new TipoExameSelecionarView();
        listaTipoProcedimento = new ListaTipoProcedimentosView();
        selecionarTipoProcedimento = new TipoProcedimentoSelecionarView();
    }
    
    public void selecaoExame(Exame exame){
        Scanner l = new Scanner(System.in);
        int opcao;
        Date data;
        boolean valido;
        
        Exame novoExame;
        ProcedimentoMedico novoProcedimento;
        TipoExame tipoExame;
        TipoProcedimento tipoProcedimento;
        
        info = new ExameInfoView();
        info.info(exame);
        
        
        do{
            System.out.println("1 - Reagendar Exame");
            System.out.println("2 - Cancelar Exame");
            System.out.println("3 - Alterar status");
            System.out.println("8 sair");

            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    data = dataAgendamento.dataAgendamento();
                    if(data!=null){
                        try {
                            exame.setData(data);
                        } catch (DataInvalidaException ex) {
                        }
                        info.info(exame);                    
                    }
                    break;
                    
                case 2:
                    if(exameCancelarView.cancelarExame(exame)){
                        return;
                    }
                    info.info(exame);
                    break;
                    
                case 3:
                    if(exameAlterarView.alterarStatus(exame)){
                        info.info(exame);
                    }
                    break;
                    
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=8);
        
    }
}
