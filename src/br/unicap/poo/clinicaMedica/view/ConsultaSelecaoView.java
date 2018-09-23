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

class ConsultaSelecaoView {
    private AgendamentoDataView dataAgendamento;
    private ConsultaCancelarView consultaCancelarView;
    private AgendamentoAlterarStatusView consultaAlterarView;
    private ConsultaService service;
    private ExameService exService;
    private TipoExameService tipoExameService;
    private TipoProcedimentoService tipoProcecimentoService;
    private ProcedimentoMedicoService proService;
    private ConsultaInfoView info;
    private ListaTipoExameView listaTipoExame;
    private TipoExameSelecionarView selecionarTipoExame;
    private ListaTipoProcedimentosView listaTipoProcedimento;
    private TipoProcedimentoSelecionarView selecionarTipoProcedimento;
    
    public ConsultaSelecaoView(){
        dataAgendamento = new AgendamentoDataView();
        consultaCancelarView = new ConsultaCancelarView();
        consultaAlterarView = new AgendamentoAlterarStatusView();
        consultaCancelarView = new ConsultaCancelarView();
        listaTipoExame = new ListaTipoExameView();
        selecionarTipoExame = new TipoExameSelecionarView();
        listaTipoProcedimento = new ListaTipoProcedimentosView();
        selecionarTipoProcedimento = new TipoProcedimentoSelecionarView();
        service = ConsultaService.getInstance();
    }
    
    public void selecaoConsulta(Consulta consulta){
        Scanner l = new Scanner(System.in);
        int opcao;
        Date data;
        boolean valido;
        
        Exame novoExame;
        ProcedimentoMedico novoProcedimento;
        TipoExame tipoExame;
        TipoProcedimento tipoProcedimento;
        
        info = new ConsultaInfoView();
        info.info(consulta);
        
        
        do{
            System.out.println("1 - Reagendar consulta");
            System.out.println("2 - Cancelar consulta");
            System.out.println("3 - Alterar status");
            if(consulta.getStatus()==Status.REALIZADA){
                System.out.println("4 - Exames marcados dessa consulta");
                System.out.println("5 - Procedimentos marcados dessa consulta");
                System.out.println("6 - Marcar Exame");
                System.out.println("7 - Marcar Procedimento Médico");
                System.out.println("8 - Voltar ");
            }
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    data = dataAgendamento.dataAgendamento();
                    if(data!=null){
                        try {
                            consulta.setData(data);
                        } catch (DataInvalidaException ex) {
                        }
                        info.info(consulta);                    
                    }
                    break;
                    
                case 2:
                    if(consultaCancelarView.cancelarConsulta(consulta)){
                        return;
                    }
                    info.info(consulta);
                    break;
                    
                case 3:
                    if(consultaAlterarView.alterarStatus(consulta)){
                        info.info(consulta);
                    }
                    break;
                    
                case 4:
                     if(consulta.getStatus()==Status.REALIZADA){
                         
                     }
                    break;
                    
                case 5:
                    if(consulta.getStatus()==Status.REALIZADA){
                    }
                    break;
                case 6:
                    if(consulta.getStatus()==Status.REALIZADA){
                        exService = ExameService.getInstance();
                        tipoExameService = TipoExameService.getInstance();
                        listaTipoExame.listaTipoExame(tipoExameService.listar());
                        tipoExame = selecionarTipoExame.selecionar();
                        do{
                            valido=false;
                            data = dataAgendamento.dataAgendamento();

                            try {
                                if(tipoExame!=null && data!=null){
                                    novoExame = new Exame(exService.lastCode()+1, data, consulta, tipoExame);
                                    consulta.addExame(novoExame);
                                    exService.novoExame(novoExame);
                                    service.alterarConsulta(consulta);
                                }
                            } catch (AgendamentoException ex) {
                                System.out.println(ex.getMessage());
                                valido=true;
                            }
                        }while(!valido);
                    }
                    break;
                case 7:
                    if(consulta.getStatus()==Status.REALIZADA){
                        proService = ProcedimentoMedicoService.getInstance();
                        tipoProcecimentoService = TipoProcedimentoService.getInstance();
                        listaTipoProcedimento.listaTipoProcedimento( tipoProcecimentoService.listar());
                        tipoProcedimento = selecionarTipoProcedimento.selecionar();
                        do{
                            valido=false;
                            data = dataAgendamento.dataAgendamento();

                            try {
                                if(tipoProcedimento!=null && data!=null){
                                    novoProcedimento = new ProcedimentoMedico(exService.lastCode()+1, data, consulta, tipoProcedimento);
                                    consulta.addProcedimento(novoProcedimento);
                                    proService.agendarProcedimento(novoProcedimento);
                                    service.alterarConsulta(consulta);
                                }
                            } catch (AgendamentoException ex) {
                                System.out.println(ex.getMessage());
                                valido=true;
                            }
                        }while(!valido);
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
