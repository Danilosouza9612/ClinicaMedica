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
    public PacienteSelecaoView(){
        
    }
    
    public void selecaoPaciente(Paciente paciente){
        Scanner l = new Scanner(System.in);
        int opcao;
        System.out.println("..................................");
        System.out.println("Nome:"+paciente.getNome());
        System.out.println("Telefone:"+paciente.getTelefone());
        System.out.println("CPF:"+paciente.getCpf());
        System.out.println("Data de Nascimento:"+paciente.getDataNasc());
        System.out.println("Número de Visitas:"+paciente.getNumeroVisitas());
        System.out.println("Endereço:");
        System.out.println("CEP"+paciente.getEndereco().getCep()+" Nº"+paciente.getEndereco().getNumero()+" Complemento:"+paciente.getEndereco().getComplemento());
        System.out.println("Plano de Saúde:");
        if(paciente.getPlanoDeSaude()!=null){
            System.out.println("Seguradora:"+paciente.getPlanoDeSaude().getSeguradoraPlano().getDescricao());
            System.out.println("Número da carteira:"+paciente.getPlanoDeSaude().getNumeroCarteira());
            System.out.println("Data de Validade:"+paciente.getPlanoDeSaude().getDataValidade());
        }
        
        do{
            System.out.println("1 - Alterar Paciente");
            System.out.println("2 - Remover Paciente");
            System.out.println("3 - Voltar");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    pacienteAlterarView = new PacienteAlterarView();
                    pacienteAlterarView.alterar(paciente);
                    break;
                case 2:
                    pacienteExcluirView = new PacienteExcluirView();
                    pacienteExcluirView.excluirPaciente(paciente);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
        
    }
}
