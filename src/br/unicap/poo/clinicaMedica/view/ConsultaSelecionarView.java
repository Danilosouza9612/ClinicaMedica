/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class ConsultaSelecionarView {
    private ConsultaService service;
    public ConsultaSelecionarView(){
        
    }
    
    public Consulta selecionar(){
        service = ConsultaService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        Consulta selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código da Consulta(Digite -1 para Sair)");
            try{
                codigo=l.nextInt();
                if(codigo!=-1){
                    selecao = service.selecionar(codigo);
                }else{
                    return null;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println("Opção Inválida");
            } 
            l.nextLine();

        }while(selecao==null);
        
        return selecao;
    }     
}
