/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemPlanoSaudeAtendidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoNaoEncontradaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PlanoSaudeMedico {
    private ArrayList<SeguradoraPlano> seguradorasPlano;
    private boolean atendePrivado;
    
    public PlanoSaudeMedico(boolean atendePrivado){
        this.atendePrivado=atendePrivado;
        seguradorasPlano = new ArrayList<>();
    }
    
    public boolean isAtendePrivado(){
        return atendePrivado;
    }
    public void setAtendePrivado(boolean atendePrivado) throws MedicoSemPlanoSaudeAtendidoException{
        if(seguradorasPlano.size()==0){
            this.atendePrivado=atendePrivado;
        }else{
            throw new MedicoSemPlanoSaudeAtendidoException();
        }
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
    private boolean contemSeguradora(SeguradoraPlano item){
        for(SeguradoraPlano data : seguradorasPlano){
            if(item.getCodigo()==data.getCodigo()){
                return true;
            }else if(data.getCodigo()<item.getCodigo()){
                return false;
            }
        }
        return false;
    }
    public void adicionarSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoRepetidaException{
        if(!contemSeguradora(seguradora)){
            seguradorasPlano.add(seguradora);
        }else{
            throw new SeguradoraPlanoSaudeMedicoRepetidaException();
        }
    }
    public void removerSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoNaoEncontradaException, MedicoSemPlanoSaudeAtendidoException{
        int cont=0;
        if(seguradorasPlano.size()==1 && atendePrivado==false){
            throw new MedicoSemPlanoSaudeAtendidoException();
        }
        
        for(SeguradoraPlano item : seguradorasPlano){
            if(item.getCodigo()==seguradora.getCodigo()){
                seguradorasPlano.remove(cont);
            }
            if(item.getCodigo()>seguradora.getCodigo()){
                throw new SeguradoraPlanoSaudeMedicoNaoEncontradaException();
            }
            cont++;
        }
        throw new SeguradoraPlanoSaudeMedicoNaoEncontradaException();
    }
}
