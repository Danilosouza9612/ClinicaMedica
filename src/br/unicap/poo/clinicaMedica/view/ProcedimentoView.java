/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class ProcedimentoView {
    private TipoProcedimentoView tipoProcedimentoView;
    private ExibirProcedimentosView exibirProcedimentoView;
    
    public void menuProcedimento(){
        Scanner l = new Scanner(System.in);
        int opcao;
      
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Procedimentos\n2 - Gerenciar Tipos de Procedimentos\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    break;
                case 2:
                    tipoProcedimentoView = new TipoProcedimentoView();
                    tipoProcedimentoView.menu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);        
    }
}
