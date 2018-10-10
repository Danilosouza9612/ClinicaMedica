/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class EditarDescricaoEspecialidadeView {
    private EspecialidadeService service;

    public EditarDescricaoEspecialidadeView() {
        service = new EspecialidadeService();
    }
    
    public void editarDescricao(Especialidade especialidade){
        System.out.println("..................................");
        System.out.println();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        especialidade.setDescricao(descricao);
        service.alterarEspecialidade(especialidade);

    }
}
