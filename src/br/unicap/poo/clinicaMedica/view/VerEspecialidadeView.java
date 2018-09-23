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
 * @author aluno
 */
public class VerEspecialidadeView {
    private ListaEspecialidadeView listaEspecialidade;
    private EditarDescricaoEspecialidadeView alterarEspecialidadeView;
    private EspecialidadeSelecionarView selecionar;
    private EspecialidadeService service;
    
    public VerEspecialidadeView(){
        listaEspecialidade = new ListaEspecialidadeView();
        alterarEspecialidadeView = new EditarDescricaoEspecialidadeView();
        selecionar = new EspecialidadeSelecionarView();

       
    }
    public void VerEspecialidade(){
        EspecialidadeService service = EspecialidadeService.getInstance();
        listaEspecialidade = new ListaEspecialidadeView();
        Especialidade selecao;
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaEspecialidade.listaEspecialidade(service.listar());
            System.out.println();
            System.out.println("1 - Alterar Tipo de Especialidade\n2 - Remover Especialidade\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    selecao = selecionar.selecionar();
                    if(selecao!=null){
                        alterarEspecialidadeView.editarDescricao(selecao);
                    }
                    listaEspecialidade.listaEspecialidade(service.listar());
                    break;
                case 2:
                    selecao = selecionar.selecionar();
                    if(selecao!=null){
                        service.removerEspecialidade(selecao);
                    }
                    listaEspecialidade.listaEspecialidade(service.listar());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
    
}
