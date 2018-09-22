package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

public class EditarDescricaoSeguradoraPlanoView {
     public EditarDescricaoSeguradoraPlanoView(){
        
    }
     
     public void editarDescricao(SeguradoraPlano seguradoraPlano){
        System.out.println("..................................");
        System.out.println();
        SeguradoraPlanoService service = SeguradoraPlanoService.getInstance();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        seguradoraPlano.setDescricao(descricao);
        try {
            service.alterarSeguradora(seguradoraPlano);
        } catch (SeguradoraPlanoNaoEncontradaException ex) {
            System.out.println(ex);
        }
     }
}
