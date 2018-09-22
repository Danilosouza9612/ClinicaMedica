/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.noRepeatArrayList.NoRepeatArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PlanoSaudeMedico {
    private NoRepeatArrayList<SeguradoraPlano> seguradorasPlano;
    private boolean atendePrivado;
    
    public PlanoSaudeMedico(boolean atendePrivado){
        this.atendePrivado=atendePrivado;
        seguradorasPlano = new NoRepeatArrayList<>();
    }
    
    public boolean isAtendePrivado(){
        return atendePrivado;
    }
    public void setAtendePrivado(boolean atendePrivado){
        this.atendePrivado=atendePrivado;
    }
    public List<SeguradoraPlano> getSeguradorasPlano(){
        return seguradorasPlano;
    }
    public boolean atendePlanoSaude(SeguradoraPlano seguradoraPlano){
        if(seguradoraPlano==null){
            return atendePrivado;
        }else{
            return seguradorasPlano.contains(seguradoraPlano);
        }
    }
    public void adicionarSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoRepetidaException{
        if(!seguradorasPlano.contains(seguradora)){
            seguradorasPlano.add(seguradora);
        }else{
            throw new SeguradoraPlanoSaudeMedicoRepetidaException();
        }
    }
    public void removerSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoNaoEncontradaException{
        if(!seguradorasPlano.remove(seguradora)){
            throw new SeguradoraPlanoSaudeMedicoNaoEncontradaException();
        }
    }
}
