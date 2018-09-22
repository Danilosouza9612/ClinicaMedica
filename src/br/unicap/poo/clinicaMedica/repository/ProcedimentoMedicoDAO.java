/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ProcedimentoMedicoDAO implements ProcedimentoMedicoRepBridge{
    ArrayList<ProcedimentoMedico> dataBase;
    
    public ProcedimentoMedicoDAO(){
        dataBase = new ArrayList();
    }
    @Override
    public boolean inserir(ProcedimentoMedico item) {
        return dataBase.add(item);
    }

    @Override
    public boolean alterar(ProcedimentoMedico item) {
        int cont=0;
        
        for(ProcedimentoMedico data : dataBase){
            if(data.getCodigo()==item.getCodigo()){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(ProcedimentoMedico item) {
        return dataBase.remove(item);
    }

    @Override
    public List<ProcedimentoMedico> listar() {
        return dataBase;
    }

    @Override
    public ProcedimentoMedico selecionar(int codigo) {
        int cont = 0;
        
        for(ProcedimentoMedico data : dataBase){
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
