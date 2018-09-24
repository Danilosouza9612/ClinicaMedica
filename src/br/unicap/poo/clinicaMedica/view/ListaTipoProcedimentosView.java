/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ListaTipoProcedimentosView {
    public void listaTipoProcedimento(List<TipoProcedimento> lista){
        System.out.println();
        for(TipoProcedimento item : lista){
            System.out.println("COD "+item.getCodigo()+" "+item.getDescricao());
        }
    }
}
