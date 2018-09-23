/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class MedicoInfoView {
    private MedicoService service;
    public MedicoInfoView(){
        
    }
    public void info(Medico medico){
        List<SeguradoraPlano> segMedico = medico.getPlanoSaudeMedico().getSeguradorasPlano();
        List<Especialidade> espMedico = medico.getEspecialidadeMedico().getEspecialidades();
        List<Horario> horarios = medico.getHorarioMedico().getHorarios();
        
        System.out.println("Nome:"+medico.getNome());
        System.out.println("Telefone:"+medico.getTelefone());
        System.out.println("Planos de Saúde Atendido:");
        for(SeguradoraPlano item : segMedico){
            System.out.print(item.getDescricao() + ", ");
        }
        System.out.println();
        System.out.print("Atende privado:");
        if(medico.getPlanoSaudeMedico().isAtendePrivado()){
            System.out.println("Sim");
        }else{
            System.out.println("Não");
        }
        System.out.println();
        System.out.println("Especialidades:");
        for(Especialidade item: espMedico){
            System.out.print(item.getDescricao() + ", ");           
        }
        System.out.println();
        System.out.println();
        System.out.println("Horários:");
        System.out.println();
        for(Horario item : horarios){
            System.out.println("Chegada:"+item.getChegada()+"h Saída:"+item.getSaida()+"h Dia da Semana:"+item.getDiaSemana());
        }
    }
}
