/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Horario;
import br.unicap.poo.clinicaMedica.model.HorarioMedico;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class MedicoSelecionarHorarioView {
    public MedicoSelecionarHorarioView(){
    }
    public Horario selecionar(HorarioMedico horarioMedico){
        int codigo;
        Scanner l = new Scanner(System.in);
        Horario selecao=null;
        do{
            System.out.println("..................................");
            System.out.println();
            System.out.println("Digite o código do horário do médico(Digite -1 para Sair)");
            try{
                codigo=l.nextInt();
                if(codigo!=-1){
                    selecao = horarioMedico.selecionar(codigo);
                }else{
                    return null;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println("Código Inválido");
            }           
            l.nextLine();
        }while(selecao==null);
        
        return selecao;
    } 
}
