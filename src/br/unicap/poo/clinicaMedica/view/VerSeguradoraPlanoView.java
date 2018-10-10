package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

public class VerSeguradoraPlanoView {
    private ListaSeguradoraPlanoView listaSeguradora;
    private SeguradoraPlanoSelecionarView selecionar;
    private EditarDescricaoSeguradoraPlanoView alterar;
    private SeguradoraPlanoService service;

    
    public VerSeguradoraPlanoView(){
        listaSeguradora = new ListaSeguradoraPlanoView();
        alterar = new EditarDescricaoSeguradoraPlanoView();
        selecionar = new SeguradoraPlanoSelecionarView();
        service = new SeguradoraPlanoService();
    }
    
    public void verSeguradoraPlanoView(){
        SeguradoraPlano selecao;
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaSeguradora.listaSeguradoraPlano(service.listarSeguradoras());
            System.out.println();
            System.out.println("1 - Alterar Tipo de seguradora\n2 - Remover seguradora\n3 - Voltar");
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
                        alterar.editarDescricao(selecao);
                    }
                    listaSeguradora.listaSeguradoraPlano(service.listarSeguradoras());
                    break;
                case 2:
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        service.removerSeguradora(selecao);
                    }
                    listaSeguradora.listaSeguradoraPlano(service.listarSeguradoras());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
}
