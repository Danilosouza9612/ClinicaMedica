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
public class PacienteSelecionarView {
    private PacienteSelecaoView selecaoPaciente;
    private PacienteService service;
    public PacienteSelecionarView(){
        service = new PacienteService();
    }
    
    public Paciente selecionar(boolean voltarQuandoNaoEncontrado){
        String cpf;
        Paciente selecao;
        Scanner l = new Scanner(System.in);
        do{
            System.out.println("Digite o CPF do Paciente (Digite FIM para voltar):");
            cpf = l.nextLine();
            selecao=service.selecionar(cpf);
            if(cpf.equalsIgnoreCase("FIM")){
                return null;
            }
            if(selecao==null){
                System.out.println("Paciente não encontrado");
                if(voltarQuandoNaoEncontrado){
                    return null;
                }
            }
        }while(selecao==null);
        
        return selecao;   
    }
}
