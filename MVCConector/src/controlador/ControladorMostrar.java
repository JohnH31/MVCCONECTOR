/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmMostrar;

/**
 *
 * @author John
 */
public class ControladorMostrar implements WindowListener {

    FrmMostrar vista = new FrmMostrar();
    Cliente pvo = new Cliente();
    ClienteDAO pdao = new ClienteDAO();

    public ControladorMostrar(FrmMostrar vista, Cliente pvo, ClienteDAO pdao) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;

        vista.addWindowListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nit");
        m.addColumn("Nombres");
        m.addColumn("Apellidos");
        m.addColumn("Direccion");
        m.addColumn("Telefono");
        m.addColumn("Fecha Nacimiento");

        for (Cliente pvo : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo.getId(),pvo.getNit(),pvo.getNombres(),pvo.getApellidos(),pvo.getDireccion(),pvo.getTelefono(),pvo.getFecha_nacimiento()});

        }
        vista.tblMostrar.setModel(m);
    }
   

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
