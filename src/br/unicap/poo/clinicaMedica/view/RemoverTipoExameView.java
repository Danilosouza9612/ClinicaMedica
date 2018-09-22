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
public class RemoverTipoExameView {
    public RemoverTipoExameView(){
    }
    
    public void remover(){
        TipoExameService service = TipoExameService.getInstance();
        int codigo;
        boolean valido;
        Scanner l = new Scanner(System.in);
        TipoExame selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            valido=true;
            System.out.println("Digite o código do tipo de procedimento(Digite -1 para Sair)");
            codigo=l.nextInt();
            l.nextLine();
            if(codigo==-1){
                return;
            }else{
                selecao=service.selecionar(codigo);
            }
        }while(!valido && codigo!=-1);  
        service.remover(selecao);
    }   
}
