
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ConsultaDAO;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepBridge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConsultaService {
    private ConsultaRepBridge consultas;
    private static ConsultaService instance;
    
    private ConsultaService(){
        consultas = new ConsultaDAO();
    }
    public synchronized static ConsultaService getInstance(){
        if(instance==null){
            instance = new ConsultaService();
        }
        
        return instance;
    }
    public void AgendarConsulta(Consulta item){
        consultas.inserir(item);
    } 
    
    public void alterarConsulta(Consulta item){
        consultas.alterar(item);
    }
    
    public void cancelarConsulta(Consulta item){
        consultas.remover(item);
    }
    public List<Consulta> verConsultas(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public List<Consulta> verConsultas(Medico medico){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public List<Consulta> verConsultas(Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public Consulta selecionar(int codigo){
        Consulta selecao = consultas.selecionar(codigo);
        
        return selecao;
    }
    public int lastCode(){
        return consultas.lastCode();
    }
}
