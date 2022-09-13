/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.Frm_Insertar;

/**
 *
 * @author John
 */
public class ControladorInsertar implements ActionListener{

    Frm_Insertar vIn = new Frm_Insertar();
    Cliente pvo = new Cliente();
    ClienteDAO pdao = new ClienteDAO();
    
    public ControladorInsertar(Frm_Insertar vIn,Cliente pvo,ClienteDAO pdao){
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vIn.btnInsertar.addActionListener(this);
        vIn.btnCancelar.addActionListener(this);
        
    }
    
    private void insetarPais(){
        try{
        pvo.setNit(Integer.parseInt(vIn.txtNit.getText()));
        pvo.setNombres(vIn.txtNom.getText());
        pvo.setApellidos(vIn.txtApe.getText());
        pvo.setDireccion(vIn.txtDir.getText());
        pvo.setTelefono(Integer.parseInt(vIn.txtTel.getText()));
        pvo.setFecha_nacimiento(vIn.txtFec.getText());
        pdao.insertar(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vIn.btnInsertar){
            this.insetarPais();
            vIn.dispose();
        }
        if(e.getSource() == vIn.btnCancelar){
            vIn.dispose();
        }
    }
    
}
