/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

/**
 *
 * @author aluno
 */
public class MedicoRepetidoException extends Exception {

    public MedicoRepetidoException() {
        super("Já existe um cadastro desse médico");
    }
    
}
