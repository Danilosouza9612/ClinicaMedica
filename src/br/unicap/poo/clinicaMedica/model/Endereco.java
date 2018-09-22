/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.NumeroInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.EnderecoException;
import br.unicap.poo.clinicaMedica.model.exceptions.CepInvalidoException;

/**
 *
 * @author aluno
 */
public class Endereco {
    private String cep;
    private int numero;
    private String complemento;

    public Endereco(String cep, int numero, String complemento) throws EnderecoException {
        setCep(cep);
        this.numero=numero;
        this.complemento=complemento;
    }
    public Endereco(){
        
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws CepInvalidoException {
        int cepLen = cep.length();
        if(cepLen<8 || cepLen>8){
            throw new CepInvalidoException("Número insucifiente");
        }
        for(int i=0; i<8; i++){
            if(!Character.isDigit(cep.charAt(0))){
                throw new CepInvalidoException("Caracteres inválidos para um CEP");
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws NumeroInvalidoException {
        if(numero<0){
            throw new NumeroInvalidoException();
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public boolean enderecoCompleto(){
        return cep!=null;
    }
    
    
}
