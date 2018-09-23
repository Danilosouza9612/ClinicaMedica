
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoDAO;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepBridge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedimentoMedicoService {
    private ProcedimentoMedicoRepBridge procedimentos;
    private static ProcedimentoMedicoService instance;
    
    private ProcedimentoMedicoService(){
        procedimentos=new ProcedimentoMedicoDAO();  
    }
    public static synchronized ProcedimentoMedicoService getInstance(){
        if(instance==null){
            instance = new ProcedimentoMedicoService();
        }
        return instance;
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
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)procedimentos.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (List<ProcedimentoMedico>)(List<?>) resultado;
        
    }
    public List<ProcedimentoMedico> verProcedimentos(Medico medico){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)procedimentos.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<ProcedimentoMedico>)(List<?>) resultado;
    }
    public List<ProcedimentoMedico> verProcedimentos(Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)procedimentos.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (List<ProcedimentoMedico>)(List<?>) resultado;
    }
    public ProcedimentoMedico selecionar(int codigo){
        ProcedimentoMedico selecao = procedimentos.selecionar(codigo);
        
        return selecao;
    }
    public int lastCode(){
        return procedimentos.lastCode();
    }
}

