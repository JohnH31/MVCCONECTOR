/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author John
 */
public interface ConsultarDAO {
    public void insertar(Cliente p);
    public ArrayList<Cliente> consultarTabla();
}
