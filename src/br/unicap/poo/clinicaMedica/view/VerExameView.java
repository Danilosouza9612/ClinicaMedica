package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;

public class VerExameView {
    private VerTipoExameView verTipoExameView;
    
    
    public VerExameView(){
        
    }
    
    public void menu(){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("1 - Ver data do exame\n2 - Ver exame médico\n3 - Ver data do exame médico\n4 - Voltar");
            System.out.println("Digite uma opção:");
            opcao=l.nextInt();
            l.nextLine();
            
            switch(opcao){
                case 1:
                    verTipoExameView = new VerTipoExameView();
                    break;
                case 2:
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
