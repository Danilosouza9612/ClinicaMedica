/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class VerTipoExameView {
    private ListaTipoExameView listaTipoExame;
    private EditarDescricaoTipoExameView editar;
    private TipoExameSelecionarView selecionar;
    private TipoExameService service;
    
    public VerTipoExameView(){
        listaTipoExame = new ListaTipoExameView();
        editar = new EditarDescricaoTipoExameView();
        selecionar = new TipoExameSelecionarView();
    }
    public void verTipoExameView(){
        listaTipoExame = new ListaTipoExameView();
        
        TipoExame selecao;
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaTipoExame.listaTipoExame(service.listar());
            System.out.println();
            System.out.println("1 - Alterar Tipo de Exame\n2 - Remover Tipo de Exame\n3 - Voltar");
            System.out.println("Digite uma opção:");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        editar.editarDescricao(selecao);
                    }
                    listaTipoExame.listaTipoExame(service.listar());
                    break;
                case 2:
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        service.remover(selecao);
                    }    
                    listaTipoExame.listaTipoExame(service.listar());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
}
