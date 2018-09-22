
package br.unicap.poo.clinicaMedica.service;

class ExameNaoEncontradoException extends Exception {
    public ExameNaoEncontradoException(){
        super("Exame não encontrado");
    }
}
