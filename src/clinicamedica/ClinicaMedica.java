/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.service.TipoExameRepetidoException;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.unicap.poo.clinicaMedica.view.MenuPrincipal;
/**
 *
 * @author Brenan Wanderley
 */

public class ClinicaMedica {    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MenuPrincipal menu = new MenuPrincipal();
       menu.menu();
    }
    
}
