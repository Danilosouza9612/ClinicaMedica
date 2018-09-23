/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Medico;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoSelecaoView {
    private MedicoInfoView info;
    private MedicoAlterarView alterar;
    private MedicoRemoverView remover;
    public MedicoSelecaoView(){
        info = new MedicoInfoView();
        alterar = new MedicoAlterarView();
        remover = new MedicoRemoverView();
    }
    public void selecao(Medico medico){
        int opcao;
        Scanner l = new Scanner(System.in);
        info.info(medico);
                
        do{
            System.out.println("..................................");
            System.out.println("1 - Alterar\n2 - Remover");
            opcao=l.nextInt();
            System.out.println();
            
            switch(opcao){
                case 1:
                    alterar.alterar(medico);
                    info.info(medico);
                    break;
                case 2:
                    if(!remover.removerMedico(medico)){
                        info.info(medico);
                    };
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
                    
            }
            
        }while(opcao!=3);
    }
}
