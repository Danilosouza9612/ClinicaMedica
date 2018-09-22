package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

public class VerSeguradoraPlanoView {
    private ListaSeguradoraPlanoView listaSeguradora;
    private AlterarSeguradoraPlanoView alterarSeguradoraView;
    private RemoverSeguradoraPlanoView removerSeguradoraView;
    
    public VerSeguradoraPlanoView(){
        
    }
    
    public void verSeguradoraPlanoView(){
        SeguradoraPlanoService service = SeguradoraPlanoService.getInstance();
        listaSeguradora = new ListaSeguradoraPlanoView();
        
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            listaSeguradora.listaSeguradoraPlano(service.listarSeguradoras());
            System.out.println();
            System.out.println("1 - Alterar Tipo de seguradora\n2 - Remover seguradora\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    alterarSeguradoraView = new AlterarSeguradoraPlanoView();
                    alterarSeguradoraView.alterar();
                    break;
                case 2:
                    removerSeguradoraView = new RemoverSeguradoraPlanoView();
                    removerSeguradoraView.remover();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3); 
    }
}
