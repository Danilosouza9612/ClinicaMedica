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
public class RemovertipoProcedimentoView {
    private TipoProcedimentoService service;
    public RemovertipoProcedimentoView(){
    }
    
    public void remover(){
        TipoProcedimentoService service = TipoProcedimentoService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        TipoProcedimento selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código do tipo de procedimento(Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo!=-1){
                selecao=service.selecionar(codigo);
            }
        }while(selecao==null);
        
        service.removerTipoProcedimento(selecao);

        
    }        
}
