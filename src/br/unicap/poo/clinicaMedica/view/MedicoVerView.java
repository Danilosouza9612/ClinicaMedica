/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoVerView {
    private MedicoService service;
    private MedicoSelecionarView selecionar;
    private MedicoSelecaoView selecao;
    private MedicoListaView lista;
    private MedicoInfoView verMedicoEspecifico;
    public MedicoVerView(){
        lista = new MedicoListaView();
        verMedicoEspecifico = new MedicoInfoView();
        selecionar = new MedicoSelecionarView();
        selecao = new MedicoSelecaoView();
        service = new MedicoService();
    }
    
    public void verMedicos(){
        Scanner l = new Scanner(System.in);
        int opcao;
        Medico selecaoMedico;
        
        System.out.println("..................................");
        lista.listar(service.listarMedico());
        do{
            System.out.println("1 - Selecionar Médico\n2 - Voltar");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    selecaoMedico=selecionar.selecionar();
                    selecao.selecao(selecaoMedico);
                    lista.listar(service.listarMedico());
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=2);
    }
}
