/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.service.ExameService;
import java.util.Scanner;

/**
 *
 * @author Danilo bw 
 */// Verefiquei BW 
public class ExameSelecionarView {
    private ExameService service;
    public ExameSelecionarView(){
        service = new ExameService();
    }
    
    public Exame selecionar(){
        int codigo;
        Scanner l = new Scanner(System.in);
        Exame selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código do Exame(Digite -1 para Sair)");
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
