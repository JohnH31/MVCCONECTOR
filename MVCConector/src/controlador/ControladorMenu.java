/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmEliminar;
import vista.FrmMostrar;
import vista.Frm_Insertar;
import vista.Frm_Menu;

/**
 *
 * @author John
 */
public class ControladorMenu implements ActionListener {

    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    FrmMostrar vMo = new FrmMostrar();
    FrmEliminar vme = new FrmEliminar();

    public ControladorMenu(Frm_Menu vMe, Frm_Insertar vIn, FrmMostrar vMo,FrmEliminar vme) {
        this.vMe = vMe;
        this.vIn = vIn;
        this.vMo = vMo;
        this.vme = vme;

        vMe.btnInsertarM.addActionListener(this);
        vMe.btnMostrarM.addActionListener(this);
        vMe.btnEliminarM.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vMe.btnInsertarM) {
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        }
        if (e.getSource() == vMe.btnMostrarM) {
            vMo.setVisible(true);
            vMo.setLocationRelativeTo(null);
        }
        if (e.getSource() == vMe.btnEliminarM) {
            vme.setVisible(true);
            vme.setLocationRelativeTo(null);
        }
    }

}
