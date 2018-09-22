/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.PlanoDeSaude;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class PacientePlanoSaudeView {
    private ListaSeguradoraPlanoView listaSeguradoraPlanoView;
    private PacientePlanoSaudeNumCarteiraView pacientePlanoSaudeNumCarteiraView;
    private PacientePlanoSaudeDataValView pacientePlanoSaudeDataValView;
    private SeguradoraPlanoService service;
    
    public PacientePlanoSaudeView(){
        
    }
    public void alterarSeguradoraView(Paciente paciente){
        int codigo;
        Scanner l = new Scanner(System.in);
        service = SeguradoraPlanoService.getInstance();
        SeguradoraPlano selecao=null;
        
        listaSeguradoraPlanoView = new ListaSeguradoraPlanoView();
        do{
            listaSeguradoraPlanoView.listaSeguradoraPlano(service.listarSeguradoras());
            System.out.println("-2 - Nenhum");
            
            System.out.println("Digite o código da seguradora");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo!=-2){
                selecao = service.selecionar(codigo);
            }
            
        }while(selecao==null && codigo!=-2);
        
        if(codigo!=-2){
            paciente.setPlanoDeSaude(new PlanoDeSaude());
            paciente.getPlanoDeSaude().setSeguradoraPlano(selecao);
            
            pacientePlanoSaudeNumCarteiraView = new PacientePlanoSaudeNumCarteiraView();
            pacientePlanoSaudeNumCarteiraView.alterarNumeroCarteiraPlano(paciente);
            
            pacientePlanoSaudeDataValView = new PacientePlanoSaudeDataValView();
            pacientePlanoSaudeDataValView.alterarDataValidade(paciente);
        }
        
    }
}
