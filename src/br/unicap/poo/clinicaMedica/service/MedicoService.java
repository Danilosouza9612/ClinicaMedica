/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
 
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.MedicoDAO;
import br.unicap.poo.clinicaMedica.repository.MedicoRepBridge;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author aluno
 */
public class MedicoService {
    private MedicoRepBridge medicos;
    private static MedicoService instance;
    private MedicoService(){
        medicos = new MedicoDAO();
    }
    public synchronized static MedicoService getInstance(){
        if(instance==null){
            instance = new MedicoService();
        }
        return instance;
    }
    public void cadastrarMedico(Medico item){
        medicos.inserir(item);
    }
    public void alterarMedico(Medico item){
        medicos.alterar(item);
    }
    public void removerMedico(Medico item){
        medicos.remover(item);
    }
    public Medico selecionar(int codigo){
        Medico selecao = medicos.selecionar(codigo);
        
        return selecao;
    }
    public List<Medico> listarMedico(){
        List<Medico> listaMedicos = medicos.listar();
        
        Collections.sort(listaMedicos, Comparator.comparing(Medico::getNome));
        
        return listaMedicos;
    }
    public int lastCode(){
        return medicos.lastCode();
    }
}
