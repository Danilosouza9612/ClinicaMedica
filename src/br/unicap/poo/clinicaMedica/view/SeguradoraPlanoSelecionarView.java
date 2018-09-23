/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoSelecionarView {
    private SeguradoraPlanoService service;
    
    public SeguradoraPlanoSelecionarView(){
        
    }
    
    public SeguradoraPlano selecionar(){
        service = SeguradoraPlanoService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        SeguradoraPlano selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código da Seguradora(Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo!=-1){
                selecao = service.selecionar(codigo);
            }else{
                return null;
            }
        }while(selecao==null);
        
        return selecao;
    }     
   
}
