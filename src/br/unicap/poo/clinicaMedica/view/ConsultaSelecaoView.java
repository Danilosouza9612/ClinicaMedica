/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;


import br.unicap.poo.clinicaMedica.model.Consulta;
import java.util.Scanner;
import br.unicap.poo.clinicaMedica.service.ConsultaService;

class ConsultaSelecaoView {
    private AgendamentoReagendarView consultaReagendarView;
    private ConsultaCancelarView consultaCancelarView;
    private ConsultaAlterarView consultaAlterarView;
    private ConsultaMarcarExameView consultaMarcarExameView;
    private ConsultaMarcarProcedimentoMedicoView consultaMarcarProcedimentoMedicoView;
    private ConsultaInfoView info;
   
    public ConsultaSelecaoView(){
        
    }
    
    public void selecaoConsulta(Consulta consulta){
        Scanner l = new Scanner(System.in);
        int opcao;
        
        info = new ConsultaInfoView();
        info.info(consulta);
        
        
        do{
            System.out.println("1 - Reagendar consulta");
            System.out.println("2 - Cancelar consulta");
            System.out.println("3 - Alterar status");
            System.out.println("4 - Marcar exame");
            System.out.println("5 - Marcar procedimento médico");
            System.out.println("6 - Voltar ");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:
                    consultaReagendarView = new AgendamentoReagendarView();
                    consultaReagendarView.reagendar(consulta);
                    info.info(consulta);
                    break;
                    
                case 2:
                    consultaCancelarView = new ConsultaCancelarView();
                    if(consultaCancelarView.cancelarConsulta(consulta)){
                        return;
                    }
                    info.info(consulta);
                    break;
                    
                case 3:
                    consultaAlterarView = new ConsultaAlterarView();
                    consultaAlterarView.alterarStatus(consulta);
                    info.info(consulta);
                    break;
                    
                case 4:
                    consultaMarcarExameView = new ConsultaMarcarExameView();
                    consultaMarcarExameView.marcarExame();
                    break;
                    
                case 5:
                    consultaMarcarProcedimentoMedicoView = new ConsultaMarcarProcedimentoMedicoView();
                    consultaMarcarProcedimentoMedicoView.marcar();
                    
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=6);
        
    }
}
