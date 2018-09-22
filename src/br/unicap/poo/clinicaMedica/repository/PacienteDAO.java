/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.model.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PacienteDAO implements PacienteRepBridge{
    ArrayList<Paciente> dataBase;
    
    public PacienteDAO(){
        dataBase = new ArrayList();
    }
    @Override
    public boolean inserir(Paciente item) {
        return dataBase.add(item);
    }

    @Override
    public boolean alterar(Paciente item) {
        int cont=0;
        
        for(Paciente data : dataBase){
            if(data.getCpf().equals(item.getCpf())){
                dataBase.set(cont, item);
                return true;
            }
            cont++;
        }
        return false;
    }

    @Override
    public boolean remover(Paciente item) {
        return dataBase.remove(item);
    }

    @Override
    public List<Paciente> listar() {
        return dataBase;
    }

    @Override
    public Paciente selecionar(String cpf) {
        int cont = 0;
        
        for(Paciente data : dataBase){
            if(data.getCpf().equals(cpf)){
                return dataBase.get(cont);
            }
        }
        return null;
    }
    
}
