/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.repository.TipoExameDAO;
import br.unicap.poo.clinicaMedica.repository.TipoExameRepBridge;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class TipoExameService {
    private TipoExameRepBridge tipoExames;
    private static TipoExameService instance;
    private TipoExameService(){
        tipoExames = new TipoExameDAO();
    }
    public synchronized static TipoExameService getInstance(){
        if(instance==null){
            instance = new TipoExameService();
        }
        
        return instance;
    }
    
    public void adicionarTipo(TipoExame item) throws TipoExameRepetidoException{
        if(tipoExames.selecionar(item.getCodigo())!=null){
            throw new TipoExameRepetidoException();
        }else{
            tipoExames.inserir(item);
        }
    }
    public void alterarTipo(TipoExame item) throws TipoExameNaoEncontradoException{
        if(!tipoExames.alterar(item)){
            throw new TipoExameNaoEncontradoException();
        }
    }
    public TipoExame selecionar(int codigo) throws TipoExameNaoEncontradoException{
        TipoExame selecao = tipoExames.selecionar(codigo);
        if(selecao==null){
            throw new TipoExameNaoEncontradoException();
        }
        
        return selecao;
    }
    public void remover(TipoExame item) throws TipoExameNaoEncontradoException{
        if(!tipoExames.remover(item)){
            throw new TipoExameNaoEncontradoException();
        }
    }
    public List<TipoExame> listar(){
        List<TipoExame> tiposExames = tipoExames.listar();
        
        Collections.sort(tiposExames, Comparator.comparing(TipoExame::getDescricao));
        
        return tiposExames;
    }
    public int lastCode(){
        return tipoExames.lastCode();
    }
}
