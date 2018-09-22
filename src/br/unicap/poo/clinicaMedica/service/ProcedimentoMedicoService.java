
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoDAO;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepBridge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedimentoMedicoService {
    ProcedimentoMedicoRepBridge procedimentos;
    
    
    public ProcedimentoMedicoService(){
        procedimentos=new ProcedimentoMedicoDAO();  
    }
    
    public void agendarProcedimento(ProcedimentoMedico item) throws ProcedimentoRepetidoException{
        if(procedimentos.selecionar(item.getCodigo())!=null){
            throw new ProcedimentoRepetidoException();
        }else{
            procedimentos.inserir(item);
        }
    }
    
    public void alterarProcedimento(ProcedimentoMedico item) throws ProcedimentoNaoEncontradoException{
        if(!procedimentos.alterar(item)){
            throw new ProcedimentoNaoEncontradoException();
        }
    }
    
    
    public void cancelarProcedimennto(ProcedimentoMedico procedimento) throws ProcedimentoNaoEncontradoException{
        if(!procedimentos.remover(procedimento)){
            throw new ProcedimentoNaoEncontradoException();
        }
    }
    
    
    public List<ProcedimentoMedico> verProcedimentos(Medico medico, Date data){
        List<ProcedimentoMedico> retorno = new ArrayList<>();
        List<ProcedimentoMedico> listaProcedimentos = procedimentos.listar();
        
        for(ProcedimentoMedico item : listaProcedimentos){
            if(item.getConsulta().getMedico().equals(medico) && item.getConsulta().getData().equals(data)){
                retorno.add(item);
            }
        }
        
        return retorno;
    }
    public List<ProcedimentoMedico> verProcedimentos(Medico medico){
        List<ProcedimentoMedico> retorno = new ArrayList<>();
        List<ProcedimentoMedico> listaProcedimentos = procedimentos.listar();
        
        for(ProcedimentoMedico item : listaProcedimentos){
            if(item.getConsulta().getMedico().equals(medico)){
                retorno.add(item);
            }
        }
        
        return retorno;
    }
    public List<ProcedimentoMedico> verProcedimentos(Date data){
        List<ProcedimentoMedico> retorno = new ArrayList<>();
        List<ProcedimentoMedico> listaProcedimentos = procedimentos.listar();
        
        for(ProcedimentoMedico item : listaProcedimentos){
            if(item.getConsulta().getData().equals(data)){
                retorno.add(item);
            }
        }
        
        return retorno;
    }
    public ProcedimentoMedico selecionar(int codigo) throws ProcedimentoNaoEncontradoException{
        ProcedimentoMedico selecao = procedimentos.selecionar(codigo);
        if(selecao==null){
            throw new ProcedimentoNaoEncontradoException();
        }
        
        return selecao;
    }
}

