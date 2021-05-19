/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Asus VivoBook
 */
public class Model {
        private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    HashMap<String,Usuario> usuarios;
    HashMap<String,Jugador> jugadores;
    HashMap<String,Apuesta> apuestas;
    HashMap<String,List<String>> favoritas;
    
      HashMap<String,Sorteo> sorteos;
    int i=1;
    
    
    private Model(){
        usuarios = new HashMap();
        usuarios.put("111", new Usuario("111","111",1));
        usuarios.put("222", new Usuario("222","222",1));
        usuarios.put("333", new Usuario("333","333",2));
        
        jugadores = new HashMap(); 
        jugadores.put("111", new Jugador("111","J.Perez",usuarios.get("111")));
        jugadores.put("222", new Jugador("222","B.Banner",usuarios.get("222")));
        jugadores.put("333", new Jugador("333","L.Kjero",usuarios.get("333")));
        
        apuestas = new HashMap(); 
        Apuesta a=new Apuesta();
        Apuesta b=new Apuesta();
        Apuesta c=new Apuesta();
        Apuesta d=new Apuesta();
        
        a.setMotivo("Ano Nuevo");
        a.setFecha(new Date(121,1,1));
        a.setRetorno(70);
        a.setGanador(0);
        a.setJugador(jugadores.get("111"));
        a.setApuesta(20000);
        a.setPremio(800000);
        
        
        
           b.setMotivo("Navidad");
        b.setFecha(new Date(121,12,25));
        b.setRetorno(80);
        b.setGanador(0);

        b.setApuesta(20000);

        
              c.setMotivo("Dia mundial de la poblacion");
        c.setFecha(new Date(121,07,11));
        c.setRetorno(90);
        c.setGanador(0);

        c.setApuesta(20000);

        
        
        
        apuestas.put("Ano Nuevo", a);
         apuestas.put("Navidad", b);
        
         apuestas.put("Dia mundial de la poblacion", c);
        
        sorteos=new HashMap();
        
        Sorteo s=new Sorteo();
        s.setAp(a);
        s.setI(0);
        s.setApuesta(15000);
        s.setJugador(jugadores.get("111"));
        s.setNumero(1);
        s.setPremio(200000);
        s.getAp().setGanador(7);
        sorteos.put("0", s);
      
}
    public Usuario usuarioFind(String cedula,String cl11ave) throws Exception{
        if (usuarios.get(cedula)!=null&&(usuarios.get(cedula).getClave() == null ? cl11ave == null : usuarios.get(cedula).getClave().equals(cl11ave))) return usuarios.get(cedula);
        else throw new Exception("Usuario no existe");
    }
     public Jugador clienteFind(Usuario usuario) throws Exception{
        if (jugadores.get(usuario.getCedula())!=null) return jugadores.get(usuario.getCedula());
        else throw new Exception("Cliente no existe");
    }    
    public List<Apuesta> cuentasFind(Jugador cliente) throws Exception{
        List<Apuesta> result = new ArrayList();
        for(Apuesta c: apuestas.values()){
            if(c.getJugador().equals(cliente)){
                result.add(c);
            }
        }
        return result;
    }
    
        public List<Sorteo> sorteosFind(Jugador cliente) throws Exception{
        List<Sorteo> result = new ArrayList();
        for(Sorteo c: sorteos.values()){
            if(c.getJugador().equals(cliente)){
                result.add(c);
            }
        }
        return result;
    }
    
    
    

    public List<Apuesta> findPasadas() throws Exception{
        List<Apuesta> result = new ArrayList();
        for(Apuesta c: apuestas.values()){
            if(c.getFecha().before(new Date())){
                result.add(c);
                
            }
        }
        return result;
    }

    public List<Apuesta> findProximas() {
               List<Apuesta> result = new ArrayList();
        for(Apuesta c: apuestas.values()){
            if(c.getFecha().after(new Date(121,5,6))){
                result.add(c);
            }
        }
        return result;
    }

        public void apuestaCreate(Apuesta apuesta) throws Exception{

            apuestas.put(apuesta.getMotivo(), apuesta);

        
    }
        
        public int indice(){
            return i++;
        }
    
        
                public void sorteoCreate(Sorteo apuesta) throws Exception{

            sorteos.put(String.valueOf(indice()), apuesta);

        
    }
       public Apuesta findApuesta(String key){
           
           Apuesta a=apuestas.get(key);
            return apuestas.get(key);
        }
       
       

        
    
}
