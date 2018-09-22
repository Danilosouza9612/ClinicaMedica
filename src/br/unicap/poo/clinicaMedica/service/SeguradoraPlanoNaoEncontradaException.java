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
public class SeguradoraPlanoNaoEncontradaException extends Exception {
    public SeguradoraPlanoNaoEncontradaException(){
        super("Seguradora não encontrada");
    }
}
