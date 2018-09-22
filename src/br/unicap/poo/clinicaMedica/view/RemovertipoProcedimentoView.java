/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoNaoEncontradoException;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class RemovertipoProcedimentoView {
    public RemovertipoProcedimentoView(){
    }
    
    public void remover(){
        TipoProcedimentoService service = TipoProcedimentoService.getInstance();
        int codigo;
        boolean valido;
        Scanner l = new Scanner(System.in);
        TipoProcedimento selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            valido=true;
            System.out.println("Digite o código do tipo de procedimento(Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            try {
                if(codigo!=-1){
                    selecao=service.selecionar(codigo);
                }
            } catch (TipoProcedimentoNaoEncontradoException ex) {
                valido=false;
                System.out.println(ex);
            }
            
            if(valido){
                try {
                    service.removerTipoProcedimento(selecao);
                } catch (TipoProcedimentoNaoEncontradoException ex) {
                    System.out.println(ex);
                }
            }
        }while(!valido && codigo!=-1);
        
    }        
}
