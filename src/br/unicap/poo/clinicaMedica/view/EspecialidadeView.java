/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class EspecialidadeView {
    private EditarDescricaoEspecialidadeView cadastrar;
    private VerEspecialidadeView ver;
    private EspecialidadeService service;
    public EspecialidadeView(){
        
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
                    ver = new VerEspecialidadeView();
                    ver.VerEspecialidade();
                    break;
                case 2:
                    service = EspecialidadeService.getInstance();
                    cadastrar = new EditarDescricaoEspecialidadeView();
                    Especialidade novo = new Especialidade(service.lastCode()+1);
                    service.inserirEspecialidade(novo);

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
