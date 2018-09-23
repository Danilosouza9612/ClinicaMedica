package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

public class VerExameView {
    private VerTipoExameView verTipoExameView;
    
    
    public VerExameView(){
        verTipoExameView = new VerTipoExameView();        
    }
    
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Ver Exames\n2 - Gerenciar Tipos de Exames\n3 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            
            switch(opcao){
                case 1:
                    break;
                case 2:
                    verTipoExameView.verTipoExame();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 4);
    }
}
