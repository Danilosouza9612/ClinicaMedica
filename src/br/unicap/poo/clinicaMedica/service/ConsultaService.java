
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
    public void AgendarConsulta(Consulta item) throws ConsultaRepetidaException{
        if(consultas.selecionar(item.getCodigo())!=null){
            throw new ConsultaRepetidaException();
        }else{
            consultas.inserir(item);
        }
    } 
    
    public void alterarConsulta(Consulta item) throws ConsultaNaoEncontradaException{
        if(!consultas.alterar(item)){
            throw new ConsultaNaoEncontradaException();
        }
    }
    
    public void cancelarConsulta(Consulta item) throws ConsultaNaoEncontradaException{
        if(!consultas.remover(item)){
            throw new ConsultaNaoEncontradaException();
        }
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
    public Consulta selecionar(int codigo) throws ConsultaNaoEncontradaException{
        Consulta selecao = consultas.selecionar(codigo);
        if(selecao==null){
            throw new ConsultaNaoEncontradaException();
        }
        
        return selecao;
    }
}
