/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class ConsultaVerView {
    private ConsultaListaView listaConsulta;
    private ConsultaSelecionarView selecionar;
    private ConsultaSelecaoView selecaoConsulta;
    public ConsultaVerView(){
        listaConsulta = new ConsultaListaView();
        selecionar = new ConsultaSelecionarView();
        selecaoConsulta = new ConsultaSelecaoView();
    }
    public void verConsultas(List<Consulta> lista){
        Scanner l = new Scanner(System.in);
        int opcao;
        Consulta selecao;
        listaConsulta.listaConsultar(lista);
        
        do{
            System.out.println("1 - Selecionar\n2 - Voltar");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            
            switch(opcao){
                case 1:
                    selecao=selecionar.selecionar();
                    if(selecao!=null){
                        selecaoConsulta.selecaoConsulta(selecao);
                        listaConsulta.listaConsultar(lista);
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while(opcao!=2);
    }
}
