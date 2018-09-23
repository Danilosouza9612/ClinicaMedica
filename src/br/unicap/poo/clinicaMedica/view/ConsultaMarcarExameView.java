/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import java.util.Date;
import java.util.Scanner;



public class ConsultaMarcarExameView {
    private ConsultaService service;
    private ExameService exService;
    private AgendamentoReagendarView data;
    
    public ConsultaMarcarExameView() {
        data = new AgendamentoReagendarView();
    }
    
    public void marcarExame(Consulta consulta){
        Date dataExame;
        Scanner l = new Scanner(System.in);
        do{
        
        dataExame = data.reagendar();
        }while(!valido)
    }
    
    
}
