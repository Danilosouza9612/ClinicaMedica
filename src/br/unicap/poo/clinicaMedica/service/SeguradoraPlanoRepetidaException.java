/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoRepetidaException extends Exception {
    public SeguradoraPlanoRepetidaException(){
        super("Já existe uma seguradora de plano com esse código");
    }
}
