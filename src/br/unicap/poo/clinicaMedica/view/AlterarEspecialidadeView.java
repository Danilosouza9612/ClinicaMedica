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
public class AlterarEspecialidadeView {
    EditarDescricaoEspecialidadeView editarDescricaoEspecialidadeView;
    public AlterarEspecialidadeView(){
        
    }
    
    public void alterar(){
        EspecialidadeService service = EspecialidadeService.getInstance();
        int codigo;
        boolean valido;
        Scanner l = new Scanner(System.in);
        Especialidade selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            valido=true;
            System.out.println("Digite o código da especialidade (Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            try {
                if(codigo!=-1){
                    selecao=service.selecionar(codigo);
                }
            } catch (EspecialidadeNaoEncontradaException ex) {
                valido=false;
                System.out.println(ex);
            }
            
            if(valido){
                editarDescricaoEspecialidadeView = new EditarDescricaoEspecialidadeView();
                editarDescricaoEspecialidadeView.editarDescricao(selecao);
            }
        }while(!valido && codigo!=-1);
        
    }
}

