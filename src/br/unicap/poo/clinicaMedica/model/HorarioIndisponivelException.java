/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

/**
 *
 * @author aluno
 */
public class HorarioIndisponivelException extends MedicoException {

    public HorarioIndisponivelException() {
        super("Não há horário disponível para esse médico");
    }
    
}
