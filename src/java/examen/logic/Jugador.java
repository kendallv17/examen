/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Asus VivoBook
 */
public class Jugador {
   private String nombre;
   private String cedula;
   private Usuario usuario;
   private List<Apuesta> apuestas;

    public Jugador() {
        apuestas=new ArrayList();
    }

    public Jugador(String cedula, String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usuario = usuario;
        this.apuestas = new ArrayList();
        
    }



   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", cedula=" + cedula + ", usuario=" + usuario + ", apuestas=" + apuestas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.apuestas, other.apuestas)) {
            return false;
        }
        return true;
    }
   
   
   
}
