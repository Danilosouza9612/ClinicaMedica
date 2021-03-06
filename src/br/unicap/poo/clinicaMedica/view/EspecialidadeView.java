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
public class EspecialidadeView {
    private EditarDescricaoEspecialidadeView cadastrar;
    private VerEspecialidadeView ver;
    private EspecialidadeService service;
    public EspecialidadeView(){
        service = new EspecialidadeService();
    }
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Exibir Especialidades\n2 - Cadastrar Especialidades\n3 - Voltar");
            System.out.println("Digite uma opção:");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    ver = new VerEspecialidadeView();
                    ver.VerEspecialidade();
                    break;
                case 2:
                    cadastrar = new EditarDescricaoEspecialidadeView();
                    Especialidade novo = new Especialidade();
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
