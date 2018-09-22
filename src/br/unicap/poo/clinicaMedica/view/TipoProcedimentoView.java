/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoRepetidoException;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class TipoProcedimentoView {
    private VerTipoProcedimentosView verTipoProcedimentosView;
    private EditarDescricaoTipoProcedimentoView cadastrarTipoProcedimento;
    
    public TipoProcedimentoView(){
        
    }
    
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        TipoProcedimentoService service;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Tipos de Procedimentos\n2 - Cadastrar Tipos de Procedimentos\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    verTipoProcedimentosView = new VerTipoProcedimentosView();
                    verTipoProcedimentosView.verTipoProcedimentos();
                    break;
                case 2:
                    service = TipoProcedimentoService.getInstance();
                    cadastrarTipoProcedimento = new EditarDescricaoTipoProcedimentoView();
                    TipoProcedimento novo = new TipoProcedimento(service.lastCode()+1);
                    try {
                        service.cadastrarTipoProcedimento(novo);
                    } catch (TipoProcedimentoRepetidoException ex) {
                        System.out.println(ex);
                    }
                    cadastrarTipoProcedimento.editarDescricao(novo);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
    }
    
}
