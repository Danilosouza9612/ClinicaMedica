/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.repository.TipoExameRepBridge;
import br.unicap.poo.clinicaMedica.repository.TipoExameRepFactory;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class TipoExameService {
    private TipoExameRepBridge tipoExames;

    public TipoExameService(){
        TipoExameRepFactory instance = new TipoExameRepFactory();
        tipoExames = instance.getInstance();
    }
    public void adicionarTipo(TipoExame item){
        tipoExames.inserir(item);
    }
    public void alterarTipo(TipoExame item){
        tipoExames.alterar(item);
        
    }
    public TipoExame selecionar(int codigo){
        TipoExame selecao = tipoExames.selecionar(codigo);
        
        return selecao;
    }
    public void remover(TipoExame item){
        tipoExames.remover(item);
    }
    public List<TipoExame> listar(){
        List<TipoExame> tiposExames = tipoExames.listar();
        
        Collections.sort(tiposExames, Comparator.comparing(TipoExame::getDescricao));
        
        return tiposExames;
    }
}
