/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.logic;

/**
 *
 * @author Asus VivoBook
 */
public class Sorteo {
    private double apuesta;
    private Jugador jugador;
    private int numero;
    private Apuesta ap;
    private int i;
    private double premio;

    public double getApuesta() {
        return apuesta;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Sorteo() {
    }

    public Sorteo(double apuesta, Jugador jugador, int numero, Apuesta ap) {
        this.apuesta = apuesta;
        this.jugador = jugador;
        this.numero = numero;
        this.ap = ap;
    }



    public Apuesta getAp() {
        return ap;
    }

    public void setAp(Apuesta ap) {
        this.ap = ap;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }
    
    
    
}
