/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.NumeroInvalidoException;
import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class PacienteEnderecoNumeroView {
    public PacienteEnderecoNumeroView(){
        
    }
    public void editarNumero(Paciente paciente){
        int numero;
        Scanner l = new Scanner(System.in);
        boolean valido;
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o número:");
            numero = l.nextInt();
            try {
                paciente.getEndereco().setNumero(numero);
            } catch (NumeroInvalidoException ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);
    }
}
