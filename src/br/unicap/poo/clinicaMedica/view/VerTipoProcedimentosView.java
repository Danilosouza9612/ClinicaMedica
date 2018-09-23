/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class VerTipoProcedimentosView {
    private ListaTipoProcedimentosView listaTipoProcedimentos;
    private EditarDescricaoTipoProcedimentoView editar;
    private TipoProcedimentoSelecionarView selecionar;
    private TipoProcedimentoService service;

    
    public VerTipoProcedimentosView(){
        listaTipoProcedimentos = new ListaTipoProcedimentosView();
        selecionar = new TipoProcedimentoSelecionarView();
        editar = new EditarDescricaoTipoProcedimentoView();
    }
    public void verTipoProcedimentos(){
        service = TipoProcedimentoService.getInstance();
        
        Scanner l = new Scanner(System.in);
        TipoProcedimento selecao;
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
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        editar.editarDescricao(selecao);
                    }   
                    listaTipoProcedimentos.listaTipoProcedimento(service.listar());
                    break;
                case 2:
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        service.removerTipoProcedimento(selecao);
                    }
                    listaTipoProcedimentos.listaTipoProcedimento(service.listar());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
    
}
