/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class SeguradoraPlanoDAO implements SeguradoraPlanoRepBridge{
    ArrayList<SeguradoraPlano> dataBase;
    
    public SeguradoraPlanoDAO(){
        dataBase = new ArrayList();
    }
    @Override
    public boolean inserir(SeguradoraPlano item) {
        return dataBase.add(item);
    }

    @Override
    public boolean alterar(SeguradoraPlano item) {
        int cont=0;
        
        for(SeguradoraPlano data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(SeguradoraPlano item) {
        return dataBase.remove(item);
    }

    @Override
    public List<SeguradoraPlano> listar() {
        return dataBase;
    }

    @Override
    public SeguradoraPlano selecionar(int codigo) {
        int cont = 0;
        
        for(SeguradoraPlano data : dataBase){
            if(data.getCodigo()==codigo){
                return dataBase.get(cont);
            }
        }
        return null;
    }
    @Override
    public int lastCode(){
        if(dataBase.isEmpty()){
            return -1;
        }
        return dataBase.get(dataBase.size()-1).getCodigo();
    }
}
