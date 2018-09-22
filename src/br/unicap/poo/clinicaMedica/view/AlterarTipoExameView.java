/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.Scanner;
/**
 *
 * @author aluno
 */
public class AlterarTipoExameView {
    private EditarDescricaoTipoExameView editarDescricaoTipoExameView;
    private TipoExameService service;
    public AlterarTipoExameView(){
        
    }
    
    public void alterar(){
        service = TipoExameService.getInstance();
        int codigo;
        Scanner l = new Scanner(System.in);
        TipoExame selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código do tipo de Exame(Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo==-1){
                return;
            }else{
                selecao=service.selecionar(codigo);
            }
        }while(selecao==null);
 
        editarDescricaoTipoExameView = new EditarDescricaoTipoExameView();
        editarDescricaoTipoExameView.editarDescricao(selecao);
    }
}
