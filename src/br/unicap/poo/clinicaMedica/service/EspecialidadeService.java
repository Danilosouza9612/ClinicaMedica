/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
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
    public void inserirEspecialidade(Especialidade item){
        especialidades.inserir(item);
    } 
    
    public void alterarEspecialidade(Especialidade item){
        especialidades.alterar(item);
    }
    
    public void removerEspecialidade(Especialidade item){
        especialidades.remover(item);
    }
   public List<Especialidade> listar(){
       List<Especialidade> listaEspecialidades = especialidades.listar();
       
       Collections.sort(listaEspecialidades, Comparator.comparing(Especialidade::getDescricao));
       
       return listaEspecialidades;
   }
    public Especialidade selecionar(int codigo){
        Especialidade selecao = especialidades.selecionar(codigo);
        
        return selecao;
    }
    public int lastCode(){
        return especialidades.lastCode();
    }
}
