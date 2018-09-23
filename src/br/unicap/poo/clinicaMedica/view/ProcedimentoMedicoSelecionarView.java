/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class ProcedimentoMedicoSelecionarView {
    private ProcedimentoMedicoService service;
    public ProcedimentoMedicoSelecionarView(){
        
    }
    
    public ProcedimentoMedico selecionar(){
        service = ProcedimentoMedicoService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        ProcedimentoMedico selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código da ProcedimentoMedico(Digite -1 para Sair)");
            try{
                codigo=l.nextInt();
                if(codigo!=-1){
                    selecao = service.selecionar(codigo);
                }else{
                    return null;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println("Código Inválido");
            }           
            l.nextLine();

        }while(selecao==null);
        
        return selecao;
    }     
}
