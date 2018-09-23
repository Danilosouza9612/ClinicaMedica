/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.HorarioMedicoDiaSemanaInvalido;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioChegadaInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioSaidaInvalidoException;

/**
 *
 * @author Danilo
 */
public class Horario {
    private final int codigo;
    private DiaSemana diaSemana;
    private int chegada;
    private int saida;
    
    public Horario(int codigo){
        this.diaSemana=diaSemana.SEGUNDA;
        this.chegada=0;
        this.saida=23;
        this.codigo=codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) throws HorarioMedicoDiaSemanaInvalido{
        switch(diaSemana){
            case 1:
                this.diaSemana=DiaSemana.DOMINGO;
                break;
            case 2:
                this.diaSemana=DiaSemana.SEGUNDA;
                break;
            case 3:
                this.diaSemana=DiaSemana.TERCA;
                break;
            case 4:
                this.diaSemana=DiaSemana.QUARTA;
                break;
            case 5:
                this.diaSemana=DiaSemana.QUINTA;
                break;
            case 6:
                this.diaSemana=DiaSemana.SEXTA;
                break;
            case 7:
                this.diaSemana=DiaSemana.SABADO;
                break;
            default:
                throw new HorarioMedicoDiaSemanaInvalido();
              
        }
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
    public boolean equals(Object horario){
        Horario objeto = (Horario)horario;
        
        return objeto.diaSemana==this.diaSemana && objeto.chegada==this.chegada && objeto.saida==this.saida;
    }
    
}
