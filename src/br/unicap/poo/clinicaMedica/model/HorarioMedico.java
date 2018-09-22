/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class HorarioMedico {
    private ArrayList<Horario> horarios;
    
    public HorarioMedico(Horario horario) throws HorarioMedicoException{
        ArrayList<Horario> horarios = new ArrayList<>();
        horarios.add(horario);
        if(horario==null){
            throw new SemHorarioException();
        }
    }
    public List<Horario> getHorarios(){
        ArrayList<Horario> clone = new ArrayList();
        
        for(Horario item : horarios){
            clone.add(item);
        }
        
        return clone;
    }
    public void addHorario(Horario horario) throws HorarioRepetidoException{
        if(!horarios.contains(horario)){
            horarios.add(horario);
        }else{
            throw new HorarioRepetidoException();
        }
    }
    public void removeHorario(Horario horario) throws HorarioMedicoNaoEncontradoException{
        if(!horarios.remove(horario)){
            throw new HorarioMedicoNaoEncontradoException();
        }
        
    }
    boolean horarioDisponivel(Date data){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        
        for(Horario item : this.horarios){
            if(item.horarioValido(diaSemana, hora)){
                return true;
            }
        }
        
        return false;
    }
}
