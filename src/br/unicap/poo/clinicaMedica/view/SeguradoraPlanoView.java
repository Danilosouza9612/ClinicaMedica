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
public class SeguradoraPlanoView {
    private EditarDescricaoSeguradoraPlanoView cadastrar;
    private VerSeguradoraPlanoView ver;
    private SeguradoraPlanoService service;
    public SeguradoraPlanoView(){
        service = new SeguradoraPlanoService();
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Seguradoras\n2 - Cadastrar Seguradoras\n3 - Voltar");
            System.out.println("Digite uma opção:");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    ver = new VerSeguradoraPlanoView();
                    ver.verSeguradoraPlanoView();
                    break;
                case 2:
                    cadastrar = new EditarDescricaoSeguradoraPlanoView();
                    SeguradoraPlano novo = new SeguradoraPlano();
                    service.inserirSeguradora(novo);

                    cadastrar.editarDescricao(novo);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
    }    
}
