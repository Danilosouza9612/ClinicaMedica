/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.view;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.Scanner;

/**
 *
 * @author caio Maranhão
 */
public class ConsultaSelecionarView {

    private ConsultaSelecaoView selecaoConsulta;
    private ConsultaService service;

    public ConsultaSelecionarView() {
    }

    public void selecionar() {
        int codigo;
        Consulta selecao;
        Scanner l = new Scanner(System.in);
        service = ConsultaService.getInstance();
        do {
            System.out.println("..................................");
            System.out.println("Digite o código da consulta (Digite 1 para voltar):");
            codigo = l.nextInt();
            selecao = service.selecionar(codigo);
            if (codigo == 1) {
                return;
            }
            if (selecao == null) {
                System.out.println("Consulta não encontrada");
            }
        } while (selecao == null);

        selecaoConsulta = new ConsultaSelecaoView();
        selecaoConsulta.selecaoConsulta(selecao);

    }

}
