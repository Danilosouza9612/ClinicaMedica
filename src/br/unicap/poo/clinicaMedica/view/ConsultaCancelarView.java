/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Scanner;

/**
 *
 * @author Malu Maranhão
 */
public class ConsultaCancelarView {
    private ConsultaService service;
    public ConsultaCancelarView() {
        service = new ConsultaService();
    }
    
    public boolean cancelarConsulta(Consulta consulta){
        Scanner l = new Scanner(System.in);
        char op;
        do{
            System.out.println("..................................");
            System.out.println("Confirmar o cancelamento (S/N)?");
            op=l.nextLine().toLowerCase().charAt(0);
            if(op=='s'){
                service.cancelarConsulta(consulta);
                return true;
            }
        }while(op!='s' && op!='n');
        
        return false;
    }
        
        
}
    

