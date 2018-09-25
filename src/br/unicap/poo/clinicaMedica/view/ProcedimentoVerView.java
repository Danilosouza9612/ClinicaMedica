/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
class ProcedimentoVerView {
    private ProcedimentoListaView listaProcedimento;
    private ProcedimentoMedicoSelecionarView selecionar;
    private ProcedimentoSelecaoView selecaoExame;
    
    public ProcedimentoVerView(){
        listaProcedimento = new ProcedimentoListaView();
        selecionar = new ProcedimentoMedicoSelecionarView();
        selecaoExame = new ProcedimentoSelecaoView();
    }
    public void verExames(List<ProcedimentoMedico> lista){
        Scanner l = new Scanner(System.in);
        int opcao;
        ProcedimentoMedico selecao;
        listaProcedimento.listaConsultar(lista);
        
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
                        selecaoExame.selecaoProcedimento(selecao);
                        listaProcedimento.listaConsultar(lista);
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
