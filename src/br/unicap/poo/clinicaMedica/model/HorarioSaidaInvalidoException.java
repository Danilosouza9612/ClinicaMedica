/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

/**
 *
 * @author Danilo
 */
public class HorarioSaidaInvalidoException extends HorarioInvalidoException {

    public HorarioSaidaInvalidoException() {
        super("Horário de saída inválido");
    }
    
}
