package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;
public class RemoverSeguradoraPlanoView {
    public RemoverSeguradoraPlanoView (){
        
    }
    
    public void remover(){
        SeguradoraPlanoService service = SeguradoraPlanoService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        SeguradoraPlano selecao = null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código da seguradora (Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo!=-1){
                selecao = service.selecionar(codigo);
            }  
        } while(selecao==null && codigo !=1);
    }
}
