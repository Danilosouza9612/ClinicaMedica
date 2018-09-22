/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.noRepeatArrayList;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class NoRepeatArrayList<E> extends ArrayList<E>{
    
    public NoRepeatArrayList(){
        super();
    }
    @Override
    public boolean add(E e){
        if(super.contains(e)){
            return false;
        }
        return super.add(e);
    }
    
}
