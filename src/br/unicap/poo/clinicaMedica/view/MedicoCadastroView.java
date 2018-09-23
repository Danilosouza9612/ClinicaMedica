/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoCadastroView {
    private ListaEspecialidadeView especialidades;
    private EspecialidadeSelecionarView selecionar;
    private EspecialidadeService espService;
    private MedicoService service;
    private MedicoHoraChegadaView horaChegadaView;
    private MedicoHoraSaidaView horaSaidaView;
    private MedicoDiaSemanaView diaSemanaView;
    private PessoaNomeView nomeMedico;
    private PessoaTelefoneView telMedico;


    public MedicoCadastroView(){
        selecionar = new EspecialidadeSelecionarView();
        horaChegadaView = new MedicoHoraChegadaView();
        horaSaidaView = new MedicoHoraSaidaView();
        diaSemanaView = new MedicoDiaSemanaView();
        nomeMedico = new PessoaNomeView();
        telMedico = new PessoaTelefoneView();
        especialidades = new ListaEspecialidadeView();
    }
    public void cadastrar(){
        Especialidade especialidade;
        Horario horario;
        Medico medico;
        Scanner l = new Scanner(System.in);
        
        espService = EspecialidadeService.getInstance();
        
        especialidades.listaEspecialidade(espService.listar());
        especialidade=selecionar.selecionar();
        
        if(especialidade==null){
            return;
        }
        
        horario = new Horario(0);
        
        if(!horaChegadaView.alterarHoraChegada(horario)){
            return;
        }
        if(!horaSaidaView.alterarHoraSaída(horario)){
            return;
        }
        if(!diaSemanaView.alterarDiaSemana(horario)){
            return;
        }
        service = MedicoService.getInstance();
        medico = new Medico(service.lastCode()+1, horario, especialidade);
        if(!nomeMedico.editarNome(medico)){
            return;
        }
        if(!telMedico.editarTelefone(medico)){
            return;
        }
        service.cadastrarMedico(medico);
    }
}
