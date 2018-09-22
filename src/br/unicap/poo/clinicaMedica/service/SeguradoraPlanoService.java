/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoRepBridge;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoDAO;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoService {
    private SeguradoraPlanoRepBridge seguradorasPlano;
    private static SeguradoraPlanoService instance;
    
    private SeguradoraPlanoService(){
        seguradorasPlano = new SeguradoraPlanoDAO();
    }
    public synchronized static SeguradoraPlanoService getInstance(){
        if(instance==null){
            instance = new SeguradoraPlanoService();
        }
        
        return instance;
    }
    public void inserirSeguradora(SeguradoraPlano item) throws SeguradoraPlanoRepetidaException{
        if(seguradorasPlano.selecionar(item.getCodigo())!=null){
            throw new SeguradoraPlanoRepetidaException();
        }else{
            seguradorasPlano.inserir(item);
        }
    }
    public void alterarSeguradora(SeguradoraPlano item) throws SeguradoraPlanoNaoEncontradaException{
        if(!seguradorasPlano.alterar(item)){
            throw new SeguradoraPlanoNaoEncontradaException();
        }
    }
    public void removerSeguradora(SeguradoraPlano item) throws SeguradoraPlanoNaoEncontradaException{
        if(!seguradorasPlano.remover(item)){
            throw new SeguradoraPlanoNaoEncontradaException();
        }
    }
    public List<SeguradoraPlano> listarSeguradoras(){
        List<SeguradoraPlano> listaSeguradorasPlano = seguradorasPlano.listar();
        
        Collections.sort(listaSeguradorasPlano, Comparator.comparing(SeguradoraPlano::getDescricao));
        
        return listaSeguradorasPlano;
    }
    public SeguradoraPlano selecionar(int codigo) throws SeguradoraPlanoNaoEncontradaException{
        SeguradoraPlano selecao = seguradorasPlano.selecionar(codigo);
        if(selecao==null){
            throw new SeguradoraPlanoNaoEncontradaException();
        }
        
        return selecao;
    }
    public int lastCode(){
        return seguradorasPlano.lastCode();
    }
}
