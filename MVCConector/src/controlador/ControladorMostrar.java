/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmActualizar;
import vista.FrmMostrar;

/**
 *
 * @author John
 */
public class ControladorMostrar implements WindowListener,MouseListener {

    FrmMostrar vista = new FrmMostrar();
    Cliente pvo = new Cliente();
    ClienteDAO pdao = new ClienteDAO();
    FrmActualizar ac = new FrmActualizar();

    public ControladorMostrar(FrmMostrar vista, Cliente pvo, ClienteDAO pdao, FrmActualizar ac) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;
        this.ac = ac;

        vista.addWindowListener(this);
        vista.tblMostrar.addMouseListener(this);
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
        vista.tblMostrar.setModel(m);
    }

    private void datos() {
        int row;
        row = vista.tblMostrar.getSelectedRow();
        pvo.setId(Integer.parseInt(vista.tblMostrar.getValueAt(row, 0).toString()));
        ac.txtid.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 0)));
        ac.txtNit.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 1)));
        ac.txtNom.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 2)));
        ac.txtApe.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 3)));
        ac.txtDir.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 4)));
        ac.txtTel.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 5)));
        ac.txtFec.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 6)));

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

    @Override
    public void mouseClicked(MouseEvent e) {
        this.datos();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ac.setVisible(true);
        ac.setLocationRelativeTo(null);
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

}
