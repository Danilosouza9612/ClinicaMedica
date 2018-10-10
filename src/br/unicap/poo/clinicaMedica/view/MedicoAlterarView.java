/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoAlterarView {
    private PessoaNomeView nomeMedico;
    private PessoaTelefoneView telMedico;
    private MedicoService service;
    private MedicoAlterarEspecialidadeView alterarEsp;
    private MedicoAlterarSeguradoraPlanoView alterarSeg;
    private MedicoAlterarHorarioView horarios;
    
    public MedicoAlterarView(){
        nomeMedico = new PessoaNomeView();
        telMedico = new PessoaTelefoneView();
        alterarEsp = new MedicoAlterarEspecialidadeView();
        alterarSeg = new MedicoAlterarSeguradoraPlanoView();
        horarios = new MedicoAlterarHorarioView();
        service = new MedicoService();
    }
    
    public void alterar(Medico medico){
        Scanner l = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("1 - Alterar Nome");
            System.out.println("2 - Alterar Telefone");
            System.out.println("3 - Alterar Especialidades");
            System.out.println("4 - Alterar Planos de Saúde atendidos");
            System.out.println("5 - Alterar Horário");
            System.out.println("6 - Voltar");
            System.out.println("Digite uma opção");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    if(nomeMedico.editarNome(medico)){
                        service.alterarMedico(medico);
                    }
                    break;
                case 2:
                    if(telMedico.editarTelefone(medico)){
                        service.alterarMedico(medico);
                    }
                    break;
                case 3:
                    alterarEsp.alterarMedicoEspecialidade(medico);
                    break;
                case 4:
                    alterarSeg.alterarMedicoSeguradora(medico);
                    break;
                case 5:
                    horarios.alterarMedicoSeguradora(medico);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcao!=6);
    }
}
