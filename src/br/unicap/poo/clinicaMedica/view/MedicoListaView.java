/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Medico;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class MedicoListaView {
    public MedicoListaView(){
        
    }
    
    public void listar(List<Medico> lista){
        for(Medico item: lista){
            System.out.println("COD"+item.getCodigo()+" "+item.getNome()+" Telefone:"+item.getTelefone());
        }
    }
}
