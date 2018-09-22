/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ListaEspecialidadeView {
    public void listaEspecialidade(List<Especialidade> lista){
        System.out.println();
        for(Especialidade item : lista){
            System.out.println("COD "+item.getCodigo()+" "+item.getDescricao());
        }
    }
}
