/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmActualizar;


/**
 *
 * @author John
 */
public class ControladorModificar implements ActionListener{

    FrmActualizar ac = new FrmActualizar();
    Cliente pvo = new Cliente();
    ClienteDAO pdao = new ClienteDAO();
    public ControladorModificar(Cliente pvo,ClienteDAO pdao, FrmActualizar ac) {
        this.pvo = pvo;
        this.pdao = pdao;
        this.ac = ac;

        ac.btnActualizar.addActionListener(this);

    }


    private void modi() {
        try{
        pvo.getId();
        pvo.setNit(Integer.parseInt(ac.txtNit.getText()));
        pvo.setNombres(ac.txtNom.getText());
        pvo.setApellidos(ac.txtApe.getText());
        pvo.setDireccion(ac.txtDir.getText());
        pvo.setTelefono(Integer.parseInt(ac.txtTel.getText()));
        pvo.setFecha_nacimiento(ac.txtFec.getText());
        pdao.actualizar(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ac.btnActualizar) {
            this.modi();
            ac.dispose();
        }
    }

}
