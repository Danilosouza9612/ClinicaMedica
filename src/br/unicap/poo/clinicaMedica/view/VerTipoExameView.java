/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class VerTipoExameView {
    private ListaTipoExameView listaTipoExame;
    private AlterarTipoExameView alterarTipoExameView;
    private RemoverTipoExameView removerTipoExameView;
    
    public VerTipoExameView(){
        
    }
    public void verTipoProcedimentos(){
        TipoExameService service = TipoExameService.getInstance();
        listaTipoExame = new ListaTipoExameView();
        
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaTipoExame.listaTipoExame(service.listar());
            System.out.println();
            System.out.println("1 - Alterar Tipo de Exame\n2 - Remover Tipo de Exame\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    alterarTipoExameView = new AlterarTipoExameView();
                    alterarTipoExameView.alterar();
                    break;
                case 2:
                    removerTipoExameView = new RemoverTipoExameView();
                    removerTipoExameView.remover();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
}
