package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ExameRepBridge;
import br.unicap.poo.clinicaMedica.repository.ExameDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ExameService {

    private ExameRepBridge exames;
    private static ExameService instance;

    private ExameService(){
        exames = new ExameDAO();
    }
    public synchronized static ExameService getInstance(){
        if(instance==null){
            instance = new ExameService();
        }
        
        return instance;
    }
    public void novoExame(Exame item) throws ExameRepetidoException {
        if(exames.selecionar(item.getCodigo())!=null){
            throw new ExameRepetidoException();
        }else{
            exames.inserir(item);
        }
    }

    public void alterarExame(Exame item) throws ExameNaoEncontradoException {
        if(!exames.alterar(item)){
            throw new ExameNaoEncontradoException();
        }

    }

    public void cancelarExame(Exame item) throws ExameNaoEncontradoException {
        if(!exames.remover(item)){
            throw new ExameNaoEncontradoException();
        }
    }
    
    public List<Exame> verExames(Medico item){
        List<Exame> retorno = new ArrayList();
        List<Exame> listaExames = exames.listar();
        
        for(Exame itemExame : listaExames){
            if(itemExame.getConsulta().getMedico().equals(item)){
                retorno.add(itemExame);
            }
        }
        
        return retorno;
    }
    public List<Exame> verExames(Date data){
        List<Exame> retorno = new ArrayList();
        List<Exame> listaExames = exames.listar();
        
        for(Exame itemExame : listaExames){
            if(itemExame.getConsulta().getData().equals(data)){
                retorno.add(itemExame);
            }
        }
        
        return retorno;        
    }
    public List<Exame> verExames(Medico medico, Date data){
        List<Exame> retorno = new ArrayList();
        List<Exame> listaExames = exames.listar();
        
        for(Exame itemExame : listaExames){
            if(itemExame.getConsulta().getData().equals(data) && itemExame.getConsulta().getMedico().equals(medico)){
                retorno.add(itemExame);
            }
        }
        
        return retorno;
    }
    public Exame selecionar(int codigo) throws ExameNaoEncontradoException{
        Exame selecao = exames.selecionar(codigo);
        if(selecao==null){
            throw new ExameNaoEncontradoException();
        }
        
        return selecao;
    }

}
