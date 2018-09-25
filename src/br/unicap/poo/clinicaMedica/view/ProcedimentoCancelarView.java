/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.ConsultaService;

import java.util.Scanner;
/**
 *
 * @author aluno
 */
class ProcedimentoCancelarView {
    private ProcedimentoMedicoService service;
    private ConsultaService conService;
    public ProcedimentoCancelarView() {
    }
    
    public boolean cancelarProcedimento(ProcedimentoMedico procedimento){
     Scanner l = new Scanner(System.in);
        Consulta consulta;
        char op;
        do{
            System.out.println("..................................");
            System.out.println("Confirmar o cancelamento (S/N)?");
            op=l.nextLine().toLowerCase().charAt(0);
            if(op=='s'){
                service = ProcedimentoMedicoService.getInstance();
                service.cancelarProcedimennto(procedimento);
                conService = ConsultaService.getInstance();
                consulta = procedimento.getConsulta();
                consulta.removeProcedimento(procedimento);
                conService.alterarConsulta(consulta);
                
                return true;
            }
        }while(op!='s' && op!='n');
        
        return false;
    }
    
    
}
    
   