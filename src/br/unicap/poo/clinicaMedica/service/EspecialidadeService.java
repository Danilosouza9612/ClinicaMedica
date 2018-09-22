/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeDAO;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeRepBridge;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class EspecialidadeService {
    private EspecialidadeRepBridge especialidades;
    private static EspecialidadeService instance;
    
    private EspecialidadeService(){
        especialidades = new EspecialidadeDAO();
    }
    public synchronized static EspecialidadeService getInstance(){
        if(instance==null){
            instance = new EspecialidadeService();
        }
        
        return instance;
    }
    public void inserirEspecialidade(Especialidade item) throws EspecialidadeRepetidaException{
        if(especialidades.selecionar(item.getCodigo())!=null){
            throw new EspecialidadeRepetidaException();
        }else{
            especialidades.inserir(item);
        }
    } 
    
    public void alterarEspecialidade(Especialidade item) throws EspecialidadeNaoEncontradaException{
        if(!especialidades.alterar(item)){
            throw new EspecialidadeNaoEncontradaException();
        }
    }
    
    public void removerEspecialidade(Especialidade item) throws EspecialidadeNaoEncontradaException{
        if(!especialidades.remover(item)){
            throw new EspecialidadeNaoEncontradaException();
        }
    }
   public List<Especialidade> listar(){
       List<Especialidade> listaEspecialidades = especialidades.listar();
       
       Collections.sort(listaEspecialidades, Comparator.comparing(Especialidade::getDescricao));
       
       return listaEspecialidades;
   }
    public Especialidade selecionar(int codigo) throws EspecialidadeNaoEncontradaException{
        Especialidade selecao = especialidades.selecionar(codigo);
        if(selecao==null){
            throw new EspecialidadeNaoEncontradaException();
        }
        
        return selecao;
    }
    public int lastCode(){
        return especialidades.lastCode();
    }

    public void alterarTipoProcedimento(Especialidade especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
