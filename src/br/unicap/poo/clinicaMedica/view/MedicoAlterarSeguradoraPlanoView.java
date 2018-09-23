/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.SeguradoraPlano;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemPlanoSaudeAtendidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoAlterarSeguradoraPlanoView {
    private SeguradoraPlanoService segService;
    private MedicoService service;
    private ListaSeguradoraPlanoView lista;
    private SeguradoraPlanoSelecionarView selecao;
    public MedicoAlterarSeguradoraPlanoView(){
        lista = new ListaSeguradoraPlanoView();       
        selecao = new SeguradoraPlanoSelecionarView();        
    }
    
    public void alterarMedicoSeguradora(Medico medico){
        List<SeguradoraPlano> seguradoras = medico.getPlanoSaudeMedico().getSeguradorasPlano();
        Scanner l = new Scanner(System.in);
        int opcao;
        SeguradoraPlano seguradora;
        segService = SeguradoraPlanoService.getInstance();
        service = MedicoService.getInstance();
        
        do{
            System.out.println("..................................");
            lista.listaSeguradoraPlano(seguradoras);
            System.out.println("1 - Adicionar/n2 - Remover/n3 - Voltar");
            System.out.println("Escolha uma opção");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:                 
                    System.out.println("..................................");
                    lista.listaSeguradoraPlano(segService.listarSeguradoras());
                    seguradora=selecao.selecionar();
                    if(seguradora!=null){
                        try {
                            medico.getPlanoSaudeMedico().adicionarSeguradora(seguradora);
                            service.alterarMedico(medico);
                        } catch (SeguradoraPlanoSaudeMedicoRepetidaException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("..................................");
                    seguradora=selecao.selecionar();
                    if(seguradora!=null){
                        try {
                            medico.getPlanoSaudeMedico().removerSeguradora(seguradora);
                            service.alterarMedico(medico);
                        } catch (SeguradoraPlanoSaudeMedicoNaoEncontradaException | MedicoSemPlanoSaudeAtendidoException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=3);
    }      
}
