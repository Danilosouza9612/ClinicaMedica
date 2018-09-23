/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemEspecialidadeException;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoAlterarEspecialidadeView {
    private EspecialidadeService espService;
    private MedicoService service;
    private ListaEspecialidadeView lista;
    private EspecialidadeSelecionarView selecao;
    public MedicoAlterarEspecialidadeView(){
        lista = new ListaEspecialidadeView();
        selecao = new EspecialidadeSelecionarView();
    }
    
    public void alterarMedicoEspecialidade(Medico medico){
        List<Especialidade> especialidades = medico.getEspecialidadeMedico().getEspecialidades();
        Scanner l = new Scanner(System.in);
        int opcao;
        Especialidade especialidade;
        espService = EspecialidadeService.getInstance();
        service = MedicoService.getInstance();
        
        do{
            System.out.println("..................................");
            lista.listaEspecialidade(especialidades);
            System.out.println("1 - Adicionar/n2 - Remover/n3 - Voltar");
            System.out.println("Escolha uma opção");
            opcao=l.nextInt();
            l.nextLine();
            switch(opcao){
                case 1:                 
                    System.out.println("..................................");
                    lista.listaEspecialidade(espService.listar());
                    especialidade=selecao.selecionar();
                    if(especialidade!=null){
                        try {
                            medico.getEspecialidadeMedico().addEspecialidade(especialidade);
                            service.alterarMedico(medico);
                        } catch (EspecialidadeMedicoRepetidaException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("..................................");
                    especialidade=selecao.selecionar();
                    if(especialidade!=null){
                        try {
                            medico.getEspecialidadeMedico().removeEspecialidade(especialidade);
                            service.alterarMedico(medico);
                        } catch (EspecialidadeMedicoNaoEncontradaException | MedicoSemEspecialidadeException ex) {
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
