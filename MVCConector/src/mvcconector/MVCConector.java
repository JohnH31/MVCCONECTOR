/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcconector;

import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorModificar;
import controlador.ControladorMostrar;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmMostrar;
import vista.Frm_Insertar;
import vista.Frm_Menu;

/**
 *
 * @author Usuario Local
 */
public class MVCConector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Frm_Menu me = new Frm_Menu();
        Frm_Insertar in = new Frm_Insertar();
        FrmMostrar mo = new FrmMostrar();
        FrmActualizar ac = new FrmActualizar();
        FrmEliminar eli = new FrmEliminar();

        Cliente pvo = new Cliente();
        ClienteDAO pdao = new ClienteDAO();

        ControladorMenu cm = new ControladorMenu(me, in, mo,eli);
        ControladorInsertar ci = new ControladorInsertar(in, pvo, pdao);
        ControladorMostrar mos = new ControladorMostrar(mo, pvo, pdao,ac);
        ControladorModificar mom = new ControladorModificar(pvo, pdao, ac);
        ControladorEliminar moe = new ControladorEliminar(eli, pvo, pdao);
        me.setVisible(true);
        me.setLocationRelativeTo(null);
    }

}
