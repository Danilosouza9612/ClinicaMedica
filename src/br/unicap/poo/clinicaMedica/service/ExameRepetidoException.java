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
public class ExameRepetidoException extends Exception {
    public ExameRepetidoException(){
        super("Há um exame com esse mesmo código cadastrado");
    }
}
