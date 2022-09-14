/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmEliminar;

/**
 *
 * @author John
 */
public class ControladorEliminar implements MouseListener, WindowListener {

    FrmEliminar eli = new FrmEliminar();
    Cliente pvo = new Cliente();
    ClienteDAO pdao = new ClienteDAO();
    public ControladorEliminar(FrmEliminar eli,Cliente pvo, ClienteDAO pdao) {
        this.eli = eli;
        this.pvo = pvo;
        this.pdao = pdao;

        eli.addWindowListener(this);
        eli.tblEliminar.addMouseListener(this);
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
            m.addRow(new Object[]{pvo.getId(), pvo.getNit(), pvo.getNombres(), pvo.getApellidos(), pvo.getDireccion(), pvo.getTelefono(), pvo.getFecha_nacimiento()});

        }
        eli.tblEliminar.setModel(m);
    }

    private void eliminar() {

        int row = eli.tblEliminar.getSelectedRow();
        pvo.setId(Integer.parseInt(eli.tblEliminar.getValueAt(row, 0).toString()));
        int men = JOptionPane.showConfirmDialog(null, "Estas seguro que deceas eliminar el registro?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (men == JOptionPane.YES_OPTION) {
            try {
                pdao.eliminar(pvo);
                pvo.setId(row);
            } catch (Exception e) {
                System.out.println("Mensaje eliminar" + e.getMessage());
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        this.eliminar();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
