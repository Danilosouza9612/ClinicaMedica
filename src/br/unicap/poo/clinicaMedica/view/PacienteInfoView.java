/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;

/**
 *
 * @author Danilo
 */
public class PacienteInfoView {
    public PacienteInfoView(){
        
    }
    public void info(Paciente paciente){
        System.out.println("..................................");
        System.out.println("Nome:"+paciente.getNome());
        System.out.println("Telefone:"+paciente.getTelefone());
        System.out.println("CPF:"+paciente.getCpf());
        if(paciente.cadastroCompleto()){
            System.out.println("Data de Nascimento:"+paciente.getDataNasc());
            System.out.println("Número de Visitas:"+paciente.getNumeroVisitas());
            System.out.println("Endereço:");
            System.out.println("CEP"+paciente.getEndereco().getCep()+" Nº"+paciente.getEndereco().getNumero()+" Complemento:"+paciente.getEndereco().getComplemento());
            System.out.println("Plano de Saúde:");
            if(paciente.getPlanoDeSaude().getSeguradoraPlano()!=null){
                System.out.println("Plano de Saúde:");
                System.out.println("Seguradora:"+paciente.getPlanoDeSaude().getSeguradoraPlano().getDescricao());
                System.out.println("Número da carteira:"+paciente.getPlanoDeSaude().getNumeroCarteira());
                System.out.println("Data de Validade:"+paciente.getPlanoDeSaude().getDataValidade());
            }
        }
    }
}
