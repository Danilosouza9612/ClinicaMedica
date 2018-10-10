/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import java.util.Scanner;

/**
 *
 * @author Brenan Wanderley
 */
public class ExameCancelarView {
    private ExameService service;
    private ConsultaService conService;
    public ExameCancelarView() {
        service = new ExameService();
        conService = new ConsultaService();
    }
    
    public boolean cancelarExame(Exame exame){
        Scanner l = new Scanner(System.in);
        Consulta consulta;
        char op;
        do{
            System.out.println("..................................");
            System.out.println("Confirmar o cancelamento (S/N)?");
            op=l.nextLine().toLowerCase().charAt(0);
            if(op=='s'){
                service.cancelarExame(exame);
                consulta = exame.getConsulta();
                consulta.removeExame(exame);
                conService.alterarConsulta(consulta);
                
                return true;
            }
        }while(op!='s' && op!='n');
        
        return false;
    }
}
