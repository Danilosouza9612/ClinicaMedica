/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import java.util.Scanner;



/**
 *
 * @author aluno
 */
public class ConsultaPacientePreCadastro {
    public ConsultaPacientePreCadastro(){
        
    }
    public boolean preCadastro(){
        char op;
        Scanner l = new Scanner(System.in);
        do{
            System.out.println("..................................");
            System.out.println("Fazer o pré-cadastro do Paciente(S/N)?");
            op=l.nextLine().toLowerCase().charAt(0);
            if(op=='s'){
                return true;
            }
        }while(op!='s' && op!='n');
        
        return false;
    }
}
