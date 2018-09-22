/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class VerEspecialidadeView {
    private ListaEspecialidadeView listaEspecialidade;
    private AlterarEspecialidadeView alterarEspecialidadeView;
    private RemoverEspecialidadeView removerEspecialidadeView;
    
    public VerEspecialidadeView(){
        
    }
    public void VerEspecialidade(){
        EspecialidadeService service = EspecialidadeService.getInstance();
        listaEspecialidade = new ListaEspecialidadeView();
        
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
                    alterarEspecialidadeView = new AlterarEspecialidadeView();
                    alterarEspecialidadeView.alterar();
                    break;
                case 2:
                    removerEspecialidadeView = new RemoverEspecialidadeView();
                    removerEspecialidadeView.remover();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
    
}
