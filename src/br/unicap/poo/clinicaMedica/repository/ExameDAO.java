/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Exame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ExameDAO implements ExameRepBridge{
    ArrayList<Exame> dataBase;
    
    public ExameDAO(){
        dataBase = new ArrayList();
    }
    @Override
    public boolean inserir(Exame item) {
        return dataBase.add(item);
    }

    @Override
    public boolean alterar(Exame item) {
        int cont=0;
        
        for(Exame data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Exame item) {
        return dataBase.remove(item);
    }

    @Override
    public List<Exame> listar() {
        return dataBase;
    }

    @Override
    public Exame selecionar(int codigo) {
        int cont = 0;
        
        for(Exame data : dataBase){
            if(data.getCodigo()==codigo){
                return dataBase.get(cont);
            }
        }
        return null;
    }    
}
