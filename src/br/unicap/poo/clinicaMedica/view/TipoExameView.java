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
 * @author Danilo
 */
public class TipoExameView {
    private EditarDescricaoTipoExameView cadastrar;
    private VerTipoExameView ver;
    private TipoExameService service;
    public TipoExameView(){
        
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Tipos de Procedimentos\n2 - Cadastrar Tipos de Procedimentos\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    ver = new VerTipoExameView();
                    ver.verTipoExameView();
                    break;
                case 2:
                    service = TipoExameService.getInstance();
                    cadastrar = new EditarDescricaoTipoExameView();
                    TipoExame novo = new TipoExame(service.lastCode()+1);
                    service.adicionarTipo(novo);

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
