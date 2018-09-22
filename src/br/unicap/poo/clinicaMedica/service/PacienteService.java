package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.repository.PacienteDAO;
import br.unicap.poo.clinicaMedica.repository.PacienteRepBridge;

public class PacienteService {

    PacienteRepBridge pacientes;

    public PacienteService() {
        pacientes = new PacienteDAO();
    }
    
    public void cadastrarPaciente(Paciente item) throws PacienteRepetidoException{
        if(pacientes.selecionar(item.getCpf())!=null){
            throw new PacienteRepetidoException();
        }else{
            pacientes.inserir(item);
        }
    }
    
    public void alterarPaciente(Paciente item) throws PacienteNaoEncontradaException{
        if(!pacientes.alterar(item)){
            throw new PacienteNaoEncontradaException();
        }
    }
    
    public void removerPaciente(Paciente item) throws PacienteNaoEncontradaException{
         if(!pacientes.remover(item)){
             throw new PacienteNaoEncontradaException();
         }
    }
    
    public Paciente selecionar(String cpf) throws PacienteNaoEncontradaException{
        Paciente selecao = pacientes.selecionar(cpf);
        if(selecao==null){
            throw new PacienteNaoEncontradaException();
        }
        
        return selecao;
        
    }

}
