/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class EditarDescricaoTipoProcedimentoView {
    private TipoProcedimentoService service;
    public EditarDescricaoTipoProcedimentoView(){
        
    }
    public void editarDescricao(TipoProcedimento tipoProcedimento){
        System.out.println("..................................");
        System.out.println();
        service = TipoProcedimentoService.getInstance();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        tipoProcedimento.setDescricao(descricao);
        service.alterarTipoProcedimento(tipoProcedimento);
    }
}
