/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;//Brenan

import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class EditarDescricaoTipoExameView {
    private TipoExameService service;

    public EditarDescricaoTipoExameView(){
        
    }
    public void editarDescricao(TipoExame tipoExame){
        System.out.println("..................................");
        System.out.println();
        service = TipoExameService.getInstance();
        String descricao;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a descrição");
        descricao=l.nextLine();
        tipoExame.setDescricao(descricao);
        service.alterarTipo(tipoExame);
    }
}
