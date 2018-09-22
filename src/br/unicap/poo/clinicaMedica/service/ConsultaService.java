
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ConsultaDAO;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepBridge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConsultaService {
    private ConsultaRepBridge consultas;
    private static ConsultaService instance;
    
    private ConsultaService(){
        consultas = new ConsultaDAO();
    }
    public synchronized static ConsultaService getInstance(){
        if(instance==null){
            instance = new ConsultaService();
        }
        
        return instance;
    }
    public void AgendarConsulta(Consulta item){
        consultas.inserir(item);
    } 
    
    public void alterarConsulta(Consulta item){
        consultas.alterar(item);
    }
    
    public void cancelarConsulta(Consulta item){
        consultas.remover(item);
    }
    public List<Consulta> verConsultas(Medico medico, Date data){
        List<Consulta> retorno = new ArrayList<Consulta>();
        List<Consulta> listaConsultas = consultas.listar();
        
        for(Consulta itemConsulta : listaConsultas){
            if(itemConsulta.getMedico().equals(medico) && itemConsulta.getData().equals(data)){
                retorno.add(itemConsulta);
            }
        }
        
        return retorno;
    }
    public List<Consulta> verConsultas(Medico medico){
        List<Consulta> retorno = new ArrayList<Consulta>();
        List<Consulta> listaConsultas = consultas.listar();
        
        for(Consulta itemConsulta : listaConsultas){
            if(itemConsulta.getMedico().equals(medico)){
                retorno.add(itemConsulta);
            }
        }
        
        return retorno;
    }
    public List<Consulta> verConsultas(Date data){
        List<Consulta> retorno = new ArrayList<Consulta>();
        List<Consulta> listaConsultas = consultas.listar();
        
        for(Consulta itemConsulta : listaConsultas){
            if(itemConsulta.getData().equals(data)){
                retorno.add(itemConsulta);
            }
        }
        
        return retorno;
    }
    public Consulta selecionar(int codigo){
        Consulta selecao = consultas.selecionar(codigo);
        
        return selecao;
    }
    public int lastCode(){
        return consultas.lastCode();
    }
}
