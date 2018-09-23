/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.Date;
import java.util.Scanner;



public class ConsultaMarcarExameView {
    private ExameService exService;
    private AgendamentoDataView data;
    private TipoExameSelecionarView selTipoExame;
    
    public ConsultaMarcarExameView() {
        data = new AgendamentoDataView();
        selTipoExame = new TipoExameSelecionarView();
    }
    
    public void marcarExame(Consulta consulta){
        Date dataExame;
        TipoExame tipo;
        boolean valido;
        Exame exame;
        do{
            valido=true;
            dataExame = data.dataAgendamento();
            if(dataExame==null){
                return;
            }
            exService = ExameService.getInstance();
            if((tipo = selTipoExame.selecionar())==null){
                return;
            }
            try {
                exame = new Exame(exService.lastCode()+1, dataExame, consulta, tipo);
                exService.novoExame(exame);
            } catch (AgendamentoException ex) {
                System.out.println(ex.getMessage());
                valido=false;
            }
        }while(!valido);
        
    }
    
    
}
