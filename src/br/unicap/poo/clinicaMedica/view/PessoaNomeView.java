/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Pessoa;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class PessoaNomeView {
    public PessoaNomeView(){
        
    }
    
    public boolean editarNome(Pessoa pessoa){
        String nome;
        Scanner l = new Scanner(System.in);
        System.out.println("..................................");
        System.out.println("Digite o nome (Digite FIM para Sair):");
        nome = l.nextLine();
        if(nome.equalsIgnoreCase("FIM")){
            return false;
        }
        pessoa.setNome(nome);
        return true;
        
    }
}
