/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class PacienteEnderecoComplementoView {
    public PacienteEnderecoComplementoView(){
        
    }
    
    public boolean editarComplemento(Paciente paciente){
        String complemento;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite o complemento (Digite FIM para sair):");
        complemento = l.nextLine();
        if(complemento.equalsIgnoreCase("FIM")){
            return false;
        }
        paciente.getEndereco().setComplemento(complemento);
        return true;
    }
}
