/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class VerTipoProcedimentosView {
    private ListaTipoProcedimentosView listaTipoProcedimentos;
    private AlterarTipoProcedimentoView alterarTipoProcedimentoView;
    private RemovertipoProcedimentoView removerTipoProcedimentoView;
    
    public VerTipoProcedimentosView(){
        
    }
    public void verTipoProcedimentos(){
        TipoProcedimentoService service = TipoProcedimentoService.getInstance();
        listaTipoProcedimentos = new ListaTipoProcedimentosView();
        
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaTipoProcedimentos.listaTipoProcedimento(service.listar());
            System.out.println();
            System.out.println("1 - Alterar Tipo de Procedimento\n2 - Remover Tipo de Procedimento\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    alterarTipoProcedimentoView = new AlterarTipoProcedimentoView();
                    alterarTipoProcedimentoView.alterar();
                    break;
                case 2:
                    removerTipoProcedimentoView = new RemovertipoProcedimentoView();
                    removerTipoProcedimentoView.remover();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
    
}
