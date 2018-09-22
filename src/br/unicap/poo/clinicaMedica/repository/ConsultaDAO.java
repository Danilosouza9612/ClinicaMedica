/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ConsultaDAO implements ConsultaRepBridge {
    
    ArrayList<Consulta> dataBase;
    
    public ConsultaDAO(){
        dataBase = new ArrayList();
    }
    @Override
    public boolean inserir(Consulta item) {
        return dataBase.add(item);
    }

    @Override
    public boolean alterar(Consulta item) {
        int cont=0;
        
        for(Consulta data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Consulta item) {
        return dataBase.remove(item);
    }

    @Override
    public List<Consulta> listar() {
        return dataBase;
    }

    @Override
    public Consulta selecionar(int codigo) {
        int cont = 0;
        
        for(Consulta data : dataBase){
            if(data.getCodigo()==codigo){
                return dataBase.get(cont);
            }
        }
        return null;
    }
    
}
