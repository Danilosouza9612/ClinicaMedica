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
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            } 
            l.nextLine();
            
            switch(opcao){
                case 1:
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
