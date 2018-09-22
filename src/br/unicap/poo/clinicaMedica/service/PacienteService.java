package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.repository.PacienteDAO;
import br.unicap.poo.clinicaMedica.repository.PacienteRepBridge;

public class PacienteService {

    private PacienteRepBridge pacientes;
    private static PacienteService instance;

    private PacienteService() {
        pacientes = new PacienteDAO();
    }
    public synchronized static PacienteService getInstance(){
        if(instance==null){
            instance = new PacienteService();
        }
        return instance;
    }
    
    public void cadastrarPaciente(Paciente item){
        pacientes.inserir(item);
    }
    
    public void alterarPaciente(Paciente item){
        pacientes.alterar(item);
    }
    
    public void removerPaciente(Paciente item){
        pacientes.remover(item);
    }
    
    public Paciente selecionar(String cpf){
        return pacientes.selecionar(cpf);        
    }

}
