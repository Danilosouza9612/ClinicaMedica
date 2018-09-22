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

    
    public void cadastrarPaciente(boolean preCadastro){
        Paciente novo=null;
        Scanner l = new Scanner(System.in);
        String cpf;
        boolean valido;
        
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o CPF do Paciente (Digite FIM pra Sair):");
            cpf = l.nextLine();
            service = PacienteService.getInstance();
            if(cpf.equalsIgnoreCase("FIM")){
                return;
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
                } finally{
                    pacienteNomeView = new PessoaNomeView();
                    pacienteNomeView.editarNome(novo);
                    
                    pacienteTelefoneView = new PessoaTelefoneView();
                    pacienteTelefoneView.editarTelefone(novo);
                    
                    if(!preCadastro){
                        pacienteCEPView = new PacienteEnderecoCEPView();
                        pacienteCEPView.editarTelefone(novo);

                        pacienteEnderecoNumeroView = new PacienteEnderecoNumeroView();
                        pacienteEnderecoNumeroView.editarNumero(novo);

                        pacienteEnderecoComplementoView = new PacienteEnderecoComplementoView();
                        pacienteEnderecoComplementoView.editarComplemento(novo);
                        
                        pacientePlanoSaudeView = new PacientePlanoSaudeView();
                        pacientePlanoSaudeView.alterarSeguradoraView(novo);
                        
                        pacienteDataNascimentoView = new PacienteDataNascimentoView();
                        pacienteDataNascimentoView.alterarDataNascimento(novo);
                    }
                    service.cadastrarPaciente(novo);
                }
                
            }
        }while(!valido);
        
        
    }     
}
