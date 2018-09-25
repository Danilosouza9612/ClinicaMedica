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
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
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
    private ConsultaPacientePreCadastro preCadastro;
    private PacienteCadastrarView cadastrarPaciente;
    private PacienteService pacService;
    private MedicoService medService;

    public ConsultaView() {
        verConsultasView = new ConsultaVerView();
        ConsultaSelecionarView = new ConsultaSelecionarView();
        medicoSelecao = new MedicoSelecionarView();
        dataSelecao = new AgendamentoDataView();
        pacienteSelecao = new PacienteSelecionarView();
        horaSelecao = new AgendamentoHoraView();
        listaMedico = new MedicoListaView();
        preCadastro = new ConsultaPacientePreCadastro();
        pacService = PacienteService.getInstance();
        cadastrarPaciente = new PacienteCadastrarView();
        service = ConsultaService.getInstance();
        listaMedico = new MedicoListaView();
        medService = MedicoService.getInstance();
    }

    public void menu() {
        Scanner l = new Scanner(System.in);
        int opcao;
        Medico medico;
        Paciente paciente=null;
        Date data=null;
        boolean valido=false;
        do {
            System.out.println("1 - Ver consultas por data");
            System.out.println("2 - Ver consultas por médico");
            System.out.println("3 - Ver consultas por data e médico");
            System.out.println("4 - Nova consulta");
            System.out.println("5 - Voltar");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
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
                    if((paciente=cadastroPaciente(paciente))==null){
                        break;
                    }
                    do{
                        valido=true;
                        listaMedico.listar(medService.listarMedico());
                        if((medico = medicoSelecao.selecionar())==null){
                            break;
                        }else{
                            if(!medico.atendePlanoSaude(paciente.getPlanoDeSaude().getSeguradoraPlano())){
                                valido=false;
                                System.out.println("O médico não atende a este plano de saúde");
                            }
                        }
                    }while(!valido);
                    if((data=(cadastroDataEHora(data, medico)))==null){
                        break;
                    }
                    if(data==null){
                        System.out.println("É null");
                    }
                    if(!finalizarCadastro(data, medico, paciente)){
                        break;
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 5);
        
    }
    private boolean finalizarCadastro(Date data, Medico medico, Paciente paciente){
        Consulta novo;
        try {
            novo = new Consulta(service.lastCode()+1, data, medico, paciente);
            service.AgendarConsulta(novo);
            if(pacService.selecionar(paciente.getCpf())==null){
                pacService.cadastrarPaciente(paciente);
            }
        } catch (AgendamentoException ex) {
            System.out.println(ex.getMessage());
            if((data=cadastroDataEHora(data, medico))==null){
                return finalizarCadastro(data, medico, paciente);
            }else{
                return false;
            }
        }
        return true;
    }
    private Date cadastroDataEHora(Date data, Medico medico){
        boolean horDisponivel=false;
        do{
            if((data = dataSelecao.dataAgendamento())==null){
                return null;
            }
            if((data = horaSelecao.horaAgendamento(data))==null){
                return null;
            }
            horDisponivel=medico.horarioDisponivel(data);
            if(!horDisponivel){
                System.out.println("Horário indisponível pro médico");
            }
        }while(!horDisponivel);
        return data;
    }
    private Paciente cadastroPaciente(Paciente paciente){
        if((paciente = pacienteSelecao.selecionar(true))==null){
            if(preCadastro.preCadastro()){
                paciente=cadastrarPaciente.cadastrarPaciente(true);
                if(paciente==null){
                    return null;
                }else{
                    return paciente;
                }
            }else{
                return null;
            }
        }
        return paciente;
    }

}
