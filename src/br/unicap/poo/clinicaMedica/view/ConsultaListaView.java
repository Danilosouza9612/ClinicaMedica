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
import java.text.DateFormat;

/**
 *
 * @author caio Maranhão
 */
class ConsultaListaView {
    
    public ConsultaListaView(){
    }
    
    public void listaConsultar(List<Consulta> lista){
        DateFormat df  = DateFormat.getDateInstance(DateFormat.SHORT);;

        for(Consulta item : lista){
            System.out.println("COD "+item.getCodigo()+" Data: "+df.format(item.getData())+" Paciente:"+item.getPaciente().getNome()+" Médico:"+item.getMedico().getNome());
        }
    } 
}
