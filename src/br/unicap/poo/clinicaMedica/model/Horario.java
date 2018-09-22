/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.HorarioChegadaInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioSaidaInvalidoException;

/**
 *
 * @author Danilo
 */
public class Horario {
    private DiaSemana diaSemana;
    private int chegada;
    private int saida;
    
    public Horario(DiaSemana diaSemana, int chegada, int saida) throws HorarioInvalidoException{
        this.diaSemana=diaSemana;
        setChegada(chegada);
        setSaida(saida);
    }
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) throws HorarioChegadaInvalidoException {
        if(chegada>saida){
            throw new HorarioChegadaInvalidoException();
        }else{
            this.chegada=chegada;
        }
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) throws HorarioSaidaInvalidoException {
        if(saida<chegada){
            throw new HorarioSaidaInvalidoException();
        }else{
            this.saida=saida;
        }
    }
    boolean horarioValido(int diaSemana, int hora){
        return diaSemana==this.diaSemana.getValorDiaSemana() && hora > chegada && hora < saida;
    }
    
}
