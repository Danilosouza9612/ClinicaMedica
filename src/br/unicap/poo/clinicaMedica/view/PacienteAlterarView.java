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
public class PacienteAlterarView {
    private PacienteService service;
    private PessoaNomeView pacienteNomeView;
    private PessoaTelefoneView pacienteTelefoneView;
    private PacienteEnderecoCEPView pacienteCEPView;
    private PacienteEnderecoNumeroView pacienteEnderecoNumeroView;
    private PacienteEnderecoComplementoView pacienteEnderecoComplementoView;
    private PacientePlanoSaudeView pacientePlanoSaudeView;
    private PacienteDataNascimentoView pacienteDataNascimentoView;
    public PacienteAlterarView(){
        
    }
    public void alterar(Paciente paciente){
        Scanner l = new Scanner(System.in);
        int opcao;
        service = PacienteService.getInstance();
        do{
            System.out.println("1 - Alterar Nome");
            System.out.println("2 - Alterar Telefone");
            System.out.println("3 - Alterar CEP");
            System.out.println("4 - Alterar Número de Endereço");
            System.out.println("5 - Alterar Complemento");
            System.out.println("6 - Alterar Plano de Saúde");
            System.out.println("7 - Alterar Data de Nascimento");
            System.out.println("8 - Voltar");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    pacienteNomeView = new PessoaNomeView();
                    pacienteNomeView.editarNome(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 2:
                    pacienteTelefoneView = new PessoaTelefoneView();
                    pacienteTelefoneView.editarTelefone(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 3:
                    pacienteCEPView = new PacienteEnderecoCEPView();
                    pacienteCEPView.editarTelefone(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 4:
                    pacienteEnderecoNumeroView = new PacienteEnderecoNumeroView();
                    pacienteEnderecoNumeroView.editarNumero(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 5:
                    pacienteEnderecoComplementoView = new PacienteEnderecoComplementoView();
                    pacienteEnderecoComplementoView.editarComplemento(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 6:
                    pacientePlanoSaudeView = new PacientePlanoSaudeView();
                    pacientePlanoSaudeView.alterarSeguradoraView(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 7:
                    pacienteDataNascimentoView = new PacienteDataNascimentoView();
                    pacienteDataNascimentoView.alterarDataNascimento(paciente);
                    service.alterarPaciente(paciente);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida");
                   
                    
            }
        }while(opcao!=8);
    }
}
