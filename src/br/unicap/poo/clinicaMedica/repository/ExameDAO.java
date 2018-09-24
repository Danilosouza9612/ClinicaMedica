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
        int cont=0;
        for(Exame data : dataBase){
            if(item.getCodigo()==data.getCodigo()){
                dataBase.remove(cont);
                return true;
            }else if(item.getCodigo()<data.getCodigo()){
                return false;
            }
            cont++;
        }
        return false;    }

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
            cont++;
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
