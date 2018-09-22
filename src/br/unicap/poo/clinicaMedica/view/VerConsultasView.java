/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

//import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Consulta;
import java.util.List;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.model.Agendamento;

/**
 *
 * @author caio Maranhão
 */
class VerConsultasView {
    
    public VerConsultasView(){
    }
    
    
    public Agendamento verConsultaData(){
        System.out.println();
        
        
        return null;
    }
    
    
    public void verConsultaMedico(List<Consulta> lista){
        System.out.println();
        for(Consulta item : lista){
            System.out.println("COD "+item.getCodigo()+" Data: ");
        }
    }
    
    public void verConsultaDataeMedico(List<Consulta> lista){
        
        
    }
  
    
    
    
    
    
    

}
