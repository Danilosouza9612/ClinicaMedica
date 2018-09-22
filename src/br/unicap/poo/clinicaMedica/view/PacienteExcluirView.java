/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacienteExcluirView {
    private PacienteService service;

    public PacienteExcluirView(){
        
    }
    public boolean excluirPaciente(Paciente paciente){
        Scanner l = new Scanner(System.in);
        char op;
        do{
            System.out.println("..................................");
            System.out.println("Confirmar a exclusão (S/N)?");
            op=l.nextLine().toLowerCase().charAt(0);
            if(op=='s'){
                service = PacienteService.getInstance();
                service.removerPaciente(paciente);
                return true;
            }
        }while(op!='s' && op!='n');
        
        return false;
    }
}
