package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

public class EditarDescricaoSeguradoraPlanoView {
    private SeguradoraPlanoService service;
    public EditarDescricaoSeguradoraPlanoView(){
        
    }
     
     public void editarDescricao(SeguradoraPlano seguradoraPlano){
        System.out.println("..................................");
        System.out.println();
        service = SeguradoraPlanoService.getInstance();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        seguradoraPlano.setDescricao(descricao);
        service.alterarSeguradora(seguradoraPlano);
     }
}
