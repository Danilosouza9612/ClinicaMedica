package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoverSeguradoraPlanoView {
    public RemoverSeguradoraPlanoView (){
        
    }
    
    public void remover(){
        SeguradoraPlanoService service = SeguradoraPlanoService.getInstance();
        int codigo;
        boolean valido;
        Scanner l = new Scanner(System.in);
        SeguradoraPlano selecao = null;
        do{
            System.out.println("..................................");
            System.out.println();
            valido=true;
            System.out.println("Digite o código da seguradora (Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            try{
                if(codigo != 1){
                    selecao = service.selecionar(codigo);
                }
            } catch(SeguradoraPlanoNaoEncontradaException ex){
                valido = false;
                System.out.println(ex);
            }
            
            if(valido){
                try{
                    service.removerSeguradora(selecao);
                }
                catch(SeguradoraPlanoNaoEncontradaException ex){
                    System.out.println(ex);
                }
            }
        } while(!valido && codigo !=1);
    }
}
