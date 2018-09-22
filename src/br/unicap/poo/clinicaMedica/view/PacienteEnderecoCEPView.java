/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.exceptions.CepInvalidoException;
import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class PacienteEnderecoCEPView {
    public PacienteEnderecoCEPView(){
        
    }
    
    public void editarTelefone(Paciente paciente){
        boolean valido;
        String cep;
        Scanner l = new Scanner(System.in);
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o CEP:");
            cep=l.nextLine();
            try {
                paciente.getEndereco().setCep(cep);
            } catch (CepInvalidoException ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);
    }
}
