/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.service.EspecialidadeNaoEncontradaException;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class EditarDescricaoEspecialidadeView {

    public EditarDescricaoEspecialidadeView() {
    }
    
    public void editarDescricao(Especialidade especialidade){
        System.out.println("..................................");
        System.out.println();
        EspecialidadeService service = EspecialidadeService.getInstance();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        especialidade.setDescricao(descricao);
        try {
            service.alterarEspecialidade(especialidade);
        } catch (EspecialidadeNaoEncontradaException ex) {
            System.out.println(ex);
        }
    }
}
