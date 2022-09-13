/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario Local
 */
public class ClienteDAO implements ConsultarDAO{

    @Override
    public void insertar(Cliente p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_cliente (nit, "
                    + "nombres, apellidos,direccion,telefono,fecha_nacimiento) VALUES (" + p.getNit()
                    + ",'"+p.getNombres()+"','"+p.getApellidos()+"','"+p.getDireccion()+"',"+p.getTelefono()
                    +",'"+p.getFecha_nacimiento()+"');";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje Insertar" + e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public ArrayList<Cliente> consultarTabla() {
    Conector c = new Conector();
        ArrayList<Cliente> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_cliente;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt(1));
                cli.setNit(rs.getInt(2));
                cli.setNombres(rs.getString(3));
                cli.setApellidos(rs.getString(4));
                cli.setDireccion(rs.getString(5));
                cli.setTelefono(rs.getInt(6));
                cli.setFecha_nacimiento(rs.getString(7));
                info.add(cli);
            }
            //c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }
    
}
