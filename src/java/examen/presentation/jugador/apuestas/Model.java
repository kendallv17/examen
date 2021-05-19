/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.presentation.jugador.apuestas;

import examen.logic.Apuesta;
import examen.logic.Jugador;
import examen.logic.Sorteo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus VivoBook
 */
public class Model {
    List<Apuesta> apuestas;
     List<Sorteo> sorteos;
    Sorteo seleccionado;
    Jugador jugador;

    public Model() {
        this.reset();
    }

    public void reset(){ 
        List<Apuesta> rows = new ArrayList<>();  
        List<Sorteo> rows1 = new ArrayList<>();  
        seleccionado=new Sorteo();  
        jugador=new Jugador();
        this.setApuestas(rows);
        this.setSorteos(rows1);
    }
    
    public void setApuestas(List<Apuesta> apuestas){
        this.apuestas =apuestas;    
    }

     public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public Sorteo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Sorteo seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public List<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(List<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }
    
    
}
