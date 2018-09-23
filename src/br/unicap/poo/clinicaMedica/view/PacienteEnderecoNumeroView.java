/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.exceptions.NumeroInvalidoException;
import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class PacienteEnderecoNumeroView {
    public PacienteEnderecoNumeroView(){
        
    }
    public boolean editarNumero(Paciente paciente){
        int numero;
        Scanner l = new Scanner(System.in);
        boolean valido;
        do{
            valido=true;
            System.out.println("..................................");
            System.out.println("Digite o número (Digite -1 para Sair):");
            try{
                numero=l.nextInt();
                if(numero==-1){
                    return false;
                }
                try {
                    paciente.getEndereco().setNumero(numero);
                } catch (NumeroInvalidoException ex) {
                    System.out.println(ex.getMessage());
                    valido=false;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println("Número Inválido");
            }           
            l.nextLine();
        }while(!valido);
        return true;
    }
}
