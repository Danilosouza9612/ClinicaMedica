/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioIndisponivelException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Malu Maranhão
 */
public class ConsultaView {

    private ConsultaVerView verConsultasView;
    private ConsultaSelecionarView ConsultaSelecionarView;
    private MedicoSelecionarView medicoSelecao;
    private AgendamentoDataView dataSelecao;
    private AgendamentoHoraView horaSelecao;
    private ConsultaService service;
    private PacienteSelecionarView pacienteSelecao;
    private MedicoListaView listaMedico;

    public ConsultaView() {
        verConsultasView = new ConsultaVerView();
        ConsultaSelecionarView = new ConsultaSelecionarView();
        medicoSelecao = new MedicoSelecionarView();
        dataSelecao = new AgendamentoDataView();
        pacienteSelecao = new PacienteSelecionarView();
        horaSelecao = new AgendamentoHoraView();
        listaMedico = new MedicoListaView();
    }

    public void menu() {
        Scanner l = new Scanner(System.in);
        int opcao;
        Medico medico;
        Paciente paciente;
        Date data;
        boolean valido;
        Consulta novo;
        do {
            System.out.println("..................................");
            System.out.println("1 - Ver consultas por data");
            System.out.println("2 - Ver consultas por médico");
            System.out.println("3 - Ver consultas por data e médico");
            System.out.println("4 - Nova consulta");
            System.out.println("5 - Voltar");
            opcao = l.nextInt();
            l.nextLine();
            switch (opcao) {
                case 1:
                    data = dataSelecao.dataAgendamento();
                    if(data!=null){
                        verConsultasView.verConsultas(service.verConsultas(data));
                    }
                    break;
                case 2:
                    medico = medicoSelecao.selecionar();
                    if(medico!=null){
                        verConsultasView.verConsultas(service.verConsultas(medico));
                    }
                    break;
                case 3:
                    data = dataSelecao.dataAgendamento();
                    medico = medicoSelecao.selecionar();
                    if(data!=null && medico!=null){
                        verConsultasView.verConsultas(service.verConsultas(medico, data));
                    }
                    break;
                    
                case 4:
                    do{
                        valido=true;
                        service = ConsultaService.getInstance();
                        data = dataSelecao.dataAgendamento();
                        medico = medicoSelecao.selecionar();
                        paciente = pacienteSelecao.selecionar();
                        if(data!=null & paciente!=null && medico!=null && horaSelecao.horaAgendamento(data)){
                            try {
                                novo = new Consulta(service.lastCode()+1, data, medico, paciente);
                                service.AgendarConsulta(novo);
                            } catch (AgendamentoException | HorarioIndisponivelException ex) {
                                System.out.println(ex.getMessage());
                                valido=false;
                            }
                        }
                    }while(!valido);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 5);

    }

}
