/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemHorarioException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioMedicoNaoEncontradoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioRepetidoException;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoAlterarHorarioView {
    private MedicoListaHorariosView lista;
    private MedicoService service;
    private MedicoSelecionarHorarioView selecao;
    private MedicoDiaSemanaView diaDaSemana;
    private MedicoHoraChegadaView horaChegada;
    private MedicoHoraSaidaView horaSaida;
    public MedicoAlterarHorarioView(){
        lista = new MedicoListaHorariosView();       
        selecao = new MedicoSelecionarHorarioView();  
        diaDaSemana = new MedicoDiaSemanaView();
        horaChegada = new MedicoHoraChegadaView();
        horaSaida = new MedicoHoraSaidaView();
    }
    
    public void alterarMedicoSeguradora(Medico medico){
        List<Horario> horarios = medico.getHorarioMedico().getHorarios();
        Scanner l = new Scanner(System.in);
        int opcao;
        Horario horario, novo;
        service = MedicoService.getInstance();
        
        do{
            System.out.println("..................................");
            lista.listaHorarios(horarios);
            System.out.println("1 - Adicionar/n2 - Remover/n3 - Voltar");
            System.out.println("Escolha uma opção");
            try{
                opcao=l.nextInt();
            }catch(java.util.InputMismatchException ex){
                opcao=0;
            }           
            l.nextLine();
            switch(opcao){
                case 1:
                    novo = new Horario(medico.getHorarioMedico().lastCode()+1);
                    if(!horaChegada.alterarHoraChegada(novo)){
                        return;
                    }
                    if(!horaSaida.alterarHoraSaída(novo)){
                        return;
                    }
                    if(!diaDaSemana.alterarDiaSemana(novo)){
                        return;
                    }
                    try {
                        medico.getHorarioMedico().addHorario(novo);
                    } catch (HorarioRepetidoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    service.alterarMedico(medico);
                    break;
                case 2:
                    System.out.println("..................................");
                    horario=selecao.selecionar(medico.getHorarioMedico());
                    if(horario!=null){
                        try {
                            medico.getHorarioMedico().removeHorario(horario);
                        } catch (HorarioMedicoNaoEncontradoException | MedicoSemHorarioException ex) {
                            System.out.println(ex.getMessage());
                        }
                        service.alterarMedico(medico);
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
