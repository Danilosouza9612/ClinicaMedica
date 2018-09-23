/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brenan Wanderley
 */
public class ExameVerView {
    private ExameListaView listaExame;
    private ExameSelecionarView selecionar;
    private ExameSelecaoView selecaoExame;
    public ExameVerView(){
        listaExame = new ExameListaView();
        selecionar = new ExameSelecionarView();
        selecaoExame = new ExameSelecaoView();
    }
    public void verConsultas(List<Exame> lista){
        Scanner l = new Scanner(System.in);
        int opcao;
        Exame selecao;
        listaExame.listaConsultar(lista);
        
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
                        selecaoExame.selecaoExame(selecao);
                        listaExame.listaConsultar(lista);
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
