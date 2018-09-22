
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoDAO;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepBridge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedimentoMedicoService {
    private ProcedimentoMedicoRepBridge procedimentos;
    
    
    public ProcedimentoMedicoService(){
        procedimentos=new ProcedimentoMedicoDAO();  
    }
    
    public void agendarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.inserir(procedimento);
    }
    
    public void alterarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.alterar(procedimento);
    }
    
    
    public void cancelarProcedimennto(ProcedimentoMedico procedimento){
        procedimentos.remover(procedimento);
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
    public ProcedimentoMedico selecionar(int codigo){
        ProcedimentoMedico selecao = procedimentos.selecionar(codigo);
        
        return selecao;
    }
    public int lastCode(){
        return procedimentos.lastCode();
    }
}

