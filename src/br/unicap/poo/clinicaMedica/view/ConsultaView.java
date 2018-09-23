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
 * @author Malu Maranhão
 */
public class ConsultaView {

    private VerConsultasView VerConsultasView;
    private ConsultaSelecionarView ConsultaSelecionarView;

    public ConsultaView() {

    }

    public void menu() {
        Scanner l = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("..................................");
            System.out.println("1 - Ver consultas por data");
            System.out.println("2 - Ver consultas por médico");
            System.out.println("3 - Ver consultas por data e médico");
            System.out.println("4 - Nova consulta");
            System.out.println("5 - Selecionar paciente");
            System.out.println("6 - Voltar");
            opcao = l.nextInt();
            l.nextLine();
            switch (opcao) {
                case 1:
                    VerConsultasView = new VerConsultasView();
                    VerConsultasView.verConsultaData();
                    break;
                case 2:
                    VerConsultasView = new VerConsultasView();
                    List<Consulta> lista = null;
                    VerConsultasView.verConsultaMedico(lista);
                    break;
                case 3:
                    VerConsultasView = new VerConsultasView();
                    List<Consulta> listas=null;
                    VerConsultasView.verConsultaDataeMedico(listas);
                    break;
                    
                case 4:
                //nova consultas

                case 5:
                    ConsultaSelecionarView = new ConsultaSelecionarView();
                    ConsultaSelecionarView.selecionar();

                case 6:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 6);

    }

}
