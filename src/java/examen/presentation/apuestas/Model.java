/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.presentation.apuestas;

import examen.logic.Apuesta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus VivoBook
 */
public class Model {
    private List<Apuesta> proximas;
    private List<Apuesta> pasadas;

        public Model() {
        this.reset();
    }
        public void reset(){ 
        List<Apuesta> rows = new ArrayList<>();  
        List<Apuesta> rows1 = new ArrayList<>();  
        this.setProximas(rows);
        this.setPasadas(rows1);
    }

    public List<Apuesta> getProximas() {
        return proximas;
    }

    public void setProximas(List<Apuesta> proximas) {
        this.proximas = proximas;
    }

    public List<Apuesta> getPasadas() {
        return pasadas;
    }

    public void setPasadas(List<Apuesta> pasadas) {
        this.pasadas = pasadas;
    }
    
   
}
