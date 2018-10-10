package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

public class EditarDescricaoSeguradoraPlanoView {
    private SeguradoraPlanoService service;
    public EditarDescricaoSeguradoraPlanoView(){
        service = new SeguradoraPlanoService();
    }
     
     public void editarDescricao(SeguradoraPlano seguradoraPlano){
        System.out.println("..................................");
        System.out.println();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        seguradoraPlano.setDescricao(descricao);
        service.alterarSeguradora(seguradoraPlano);
     }
}
