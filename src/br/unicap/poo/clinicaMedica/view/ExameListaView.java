/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Exame;
import java.util.List;
import java.text.DateFormat;

/**
 *
 * @author Brenan Wanderley
 */
class ExameListaView {
    public ExameListaView(){
    }
    
    public void listaConsultar(List<Exame> lista){
        DateFormat df  = DateFormat.getDateInstance(DateFormat.SHORT);;

        for(Exame item : lista){
            System.out.println("COD "+item.getCodigo()+" Data: "+df.format(item.getData())+" Paciente:"+item.getPaciente().getNome()+" Exame:"+item.getTipoExame().getDescricao());
        }
    } 
}
