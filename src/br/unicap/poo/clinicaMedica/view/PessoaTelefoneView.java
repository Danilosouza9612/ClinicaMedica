/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Pessoa;
import br.unicap.poo.clinicaMedica.model.exceptions.TelefoneInvalidoException;
import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class PessoaTelefoneView {
    public PessoaTelefoneView(){
        
    }
    
    public void editarTelefone(Pessoa pessoa){
        String telefone;
        boolean valido;
        Scanner l = new Scanner(System.in);
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o telefone:");
            telefone = l.nextLine();
            try {
                pessoa.setTelefone(telefone);
            } catch (TelefoneInvalidoException ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);    
    }
}
