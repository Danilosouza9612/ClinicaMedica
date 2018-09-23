/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioIndisponivelException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import java.util.Date;


/**
 *
 * @author Brenan Wanderley
 */
public class ExameView {
    
    private TipoExameView tipoExameView;
    private ExameVerView verExamesView;
    private ExameSelecionarView ExameSelecionarView;
    private MedicoSelecionarView medicoSelecao;
    private AgendamentoDataView dataSelecao;
    private AgendamentoHoraView horaSelecao;
    private ExameService service;
    private PacienteSelecionarView pacienteSelecao;
    private MedicoListaView listaMedico;
    
    public ExameView(){
        tipoExameView = new TipoExameView();
        verExamesView = new ExameVerView();
        ExameSelecionarView = new ExameSelecionarView();
        medicoSelecao = new MedicoSelecionarView();
        dataSelecao = new AgendamentoDataView();
        pacienteSelecao = new PacienteSelecionarView();
        horaSelecao = new AgendamentoHoraView();
        listaMedico = new MedicoListaView();
    }
    
    
    public void menuExame(){
        Scanner input = new Scanner (System.in);
        int opcao;
        Medico medico;
        Paciente paciente;
        Date data;
        boolean valido;
        Exame novo;
        
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("..................................");
            System.out.println("1 - Ver Exames por data");
            System.out.println("2 - Ver Exames por médico");
            System.out.println("3 - Ver Exames por data e médico");
            System.out.println("4 - Gerenciar Tipos de Exames");
            System.out.println("5 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=input.nextInt();
            input.nextLine();
            
            switch(opcao){
                case 1:
                    data = dataSelecao.dataAgendamento();
                    if(data!=null){
                        verExamesView.verConsultas(service.verExames(data));
                    }
                    break;
                case 2:
                    medico = medicoSelecao.selecionar();
                    if(medico!=null){
                        verExamesView.verConsultas(service.verExames(medico));
                    }
                    break;
                case 3:  
                    data = dataSelecao.dataAgendamento();
                    medico = medicoSelecao.selecionar();
                    if(data!=null && medico != null){
                        verExamesView.verConsultas(service.verExames(medico, data));
                    }
                    break;
                case 4:
                    tipoExameView.menu();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 5);
    }
}
