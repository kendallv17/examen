/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca.presentation.cliente.datos;

import banca.logic.Cliente;
import banca.logic.Usuario;

/**
 *
 * @author Escinf
 */
public class Model{
    Cliente current;

    public Model() {
        this.current = new Cliente("","",new Usuario("","",1));
    }

    
    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
        this.current = current;
    }
    
    
}
