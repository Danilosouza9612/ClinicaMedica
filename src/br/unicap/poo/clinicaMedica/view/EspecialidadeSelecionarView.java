/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class EspecialidadeSelecionarView {
    private EspecialidadeService service;
    public EspecialidadeSelecionarView(){
        
    }
    
    public Especialidade selecionar(){
        service = EspecialidadeService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        Especialidade selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código da Especialidade(Digite -1 para Sair)");
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