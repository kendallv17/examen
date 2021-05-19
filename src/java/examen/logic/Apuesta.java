
package examen.logic;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus VivoBook
 */
public class Apuesta {
    private String motivo;
    private Date fecha;
    private int retorno;
    private int ganador;
    private double premio;
    private double apuesta;
    private Jugador jugador;
    private int numero;
    private int i;



    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getRetorno() {
        return retorno;
    }

    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getApuesta() {
        return apuesta;
    }

    public void setApuesta(double apuesta) {
        this.apuesta = apuesta;
    }

    public Apuesta(String motivo, Date fecha, int retorno, int ganador, double premio, double apuesta, Jugador jugador) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.retorno = retorno;
        this.ganador = ganador;
        this.premio = premio;
        this.apuesta = apuesta;
        this.jugador=jugador;
    }

    public Apuesta() {
        jugador=new Jugador();
    }

    @Override
    public String toString() {
        return "Apuesta{" + "motivo=" + motivo + ", fecha=" + fecha + ", retorno=" + retorno + ", ganador=" + ganador + ", premio=" + premio + ", apuesta=" + apuesta + '}';
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
        final Apuesta other = (Apuesta) obj;
        if (this.retorno != other.retorno) {
            return false;
        }
        if (this.ganador != other.ganador) {
            return false;
        }
        if (Double.doubleToLongBits(this.premio) != Double.doubleToLongBits(other.premio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.apuesta) != Double.doubleToLongBits(other.apuesta)) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
    
    
    
}
