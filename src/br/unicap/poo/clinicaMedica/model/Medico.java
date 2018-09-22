/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

/**
 *
 * @author aluno
 */
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoException;
import br.unicap.poo.clinicaMedica.noRepeatArrayList.NoRepeatArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Medico extends Pessoa{
    private final int codigo;
    private NoRepeatArrayList<Especialidade> especialidades;
    private PlanoSaudeMedico planoSaudeMedico;
    private HorarioMedico horarioMedico;
    

    public Medico(int codigo, HorarioMedico horarioMedico, Especialidade especialidade) throws PessoaException, MedicoException {
        super();
        this.planoSaudeMedico = new PlanoSaudeMedico(false);
        if(horarioMedico==null){
            throw new MedicoException("Informe o horário do médico");
        }
        this.horarioMedico=horarioMedico;
        if(especialidade==null){
            throw new MedicoException("Informe a especialidade do médico");
        }
        especialidades.add(especialidade);
        this.codigo=codigo;
    }
    public List<Especialidade> getEspecialidades() {
        List<Especialidade> clone = new ArrayList<Especialidade>();
        
        for(Especialidade item : especialidades){
            clone.add(item);
        }
        
        return clone;
    }
    public void addEspecialidade(Especialidade especialidade) throws EspecialidadeMedicoRepetidaException{
        if(especialidades.contains(especialidade)){
            throw new EspecialidadeMedicoRepetidaException();
        }else{
            especialidades.add(especialidade);
        }
    }
    public void removeEspecialidade(Especialidade especialidade) throws EspecialidadeMedicoNaoEncontradaException{
        if(!especialidades.remove(especialidade)){
            throw new EspecialidadeMedicoNaoEncontradaException();
        }
    }
    public HorarioMedico getHorarioMedico(){
        return horarioMedico;
    }
    public PlanoSaudeMedico getPlanoSaudeMedico(){
        return planoSaudeMedico;
    }
    public boolean atendePlanoSaude(SeguradoraPlano seguradoraPlano){
        return planoSaudeMedico.atendePlanoSaude(seguradoraPlano);
    }
    public boolean horarioDisponivel(Date data){
        return horarioMedico.horarioDisponivel(data);
    }
    public int getCodigo(){
        return codigo;
    }
    @Override
    public boolean equals(Object medico){
        Medico objeto = (Medico)medico;
        return objeto.getCodigo()==this.getCodigo();
    }

}
