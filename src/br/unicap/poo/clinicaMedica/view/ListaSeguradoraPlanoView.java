package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import java.util.List;

public class ListaSeguradoraPlanoView {
    public void listaSeguradoraPlano(List<SeguradoraPlano> lista){
        System.out.println();
        for(SeguradoraPlano item : lista){
            System.out.println("COD"+item.getCodigo()+" "+item.getDescricao());
        }
    }
}
