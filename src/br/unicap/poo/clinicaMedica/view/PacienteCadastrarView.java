/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacienteCadastrarView {
    private PacienteService service;
    private PessoaNomeView pacienteNomeView;
    private PessoaTelefoneView pacienteTelefoneView;
    private PacienteEnderecoCEPView pacienteCEPView;
    private PacienteEnderecoNumeroView pacienteEnderecoNumeroView;
    private PacienteEnderecoComplementoView pacienteEnderecoComplementoView;
    private PacientePlanoSaudeView pacientePlanoSaudeView;
    private PacienteDataNascimentoView pacienteDataNascimentoView;

    public PacienteCadastrarView(){
        pacienteNomeView = new PessoaNomeView();
        pacienteTelefoneView = new PessoaTelefoneView();
        pacientePlanoSaudeView = new PacientePlanoSaudeView();
        pacienteCEPView = new PacienteEnderecoCEPView();
        pacienteEnderecoNumeroView = new PacienteEnderecoNumeroView();
        pacienteEnderecoComplementoView = new PacienteEnderecoComplementoView();
        pacienteDataNascimentoView = new PacienteDataNascimentoView();
        service = new PacienteService();
    }
    
    public Paciente cadastrarPaciente(boolean preCadastro){
        Paciente novo=null;
        Scanner l = new Scanner(System.in);
        String cpf;
        boolean valido;
        
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o CPF do Paciente (Digite FIM pra Sair):");
            cpf = l.nextLine();
            if(cpf.equalsIgnoreCase("FIM")){
                return null;
            }
            if(service.selecionar(cpf)!=null){
                System.out.println("Paciente já existe em nosso cadastro");
                valido=false;
            }else{
                try {
                    novo = new Paciente(cpf);
                } catch (PessoaException ex) {
                    System.out.println(ex.getMessage());
                    valido=false;
                } 
            }
        }while(!valido);
        
        if(valido){
            if(!pacienteNomeView.editarNome(novo)){
                return null;
            }                  
            if(!pacienteTelefoneView.editarTelefone(novo)){
                return null;
            }
            if(!pacientePlanoSaudeView.alterarSeguradoraView(novo)){
                return null;
            }                 
            if(!preCadastro){
                if(!pacienteCEPView.editarCEP(novo)){
                    return null;
                }

                if(!pacienteEnderecoNumeroView.editarNumero(novo)){
                    return null;
                }

                if(!pacienteEnderecoComplementoView.editarComplemento(novo)){
                    return null;
                }                
                if(!pacienteDataNascimentoView.alterarDataNascimento(novo)){
                    return null;
                }
            }
        }
        return novo;
    }     
}
