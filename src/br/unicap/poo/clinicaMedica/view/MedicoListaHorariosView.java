/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class MedicoListaHorariosView {
    public MedicoListaHorariosView(){
        
    }
    public void listaHorarios(List<Horario> horarios){
        for(Horario item : horarios){
             System.out.println("COD "+item.getCodigo()+" +Chegada:"+item.getChegada()+"h Saída:"+item.getSaida()+"h Dia da Semana:"+item.getDiaSemana());
        }
    }
}
