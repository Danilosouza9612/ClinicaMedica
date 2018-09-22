
package br.unicap.poo.clinicaMedica.service;

public class ProcedimentoRepetidoException extends Exception {
    public ProcedimentoRepetidoException(){
        super("Procedimento já existe");
    }
}
