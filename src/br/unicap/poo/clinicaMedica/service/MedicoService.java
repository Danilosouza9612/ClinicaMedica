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
    
    public MedicoService(){
        medicos = new MedicoDAO();
    }
    public void cadastrarMedico(Medico item) throws MedicoRepetidoException{
        if(!medicos.inserir(item)){
            throw new MedicoRepetidoException();
        }
    }
    public void alterarMedico(Medico item) throws MedicoNaoEncontradoException{
        if(!medicos.alterar(item)){
            throw new MedicoNaoEncontradoException();
        }
    }
    public void removerMedico(Medico item) throws MedicoNaoEncontradoException{
        if(!medicos.remover(item)){
            throw new MedicoNaoEncontradoException();
        }
    }
    public Medico selecionar(int codigo) throws MedicoNaoEncontradoException{
        Medico selecao = medicos.selecionar(codigo);
        if(selecao==null){
            throw new MedicoNaoEncontradoException();
        }
        
        return selecao;
    }
    public List<Medico> listarMedico(){
        List<Medico> listaMedicos = medicos.listar();
        
        Collections.sort(listaMedicos, Comparator.comparing(Medico::getNome));
        
        return listaMedicos;
    }
}
