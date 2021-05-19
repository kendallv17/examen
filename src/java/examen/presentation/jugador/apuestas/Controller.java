/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.presentation.jugador.apuestas;

import examen.logic.Jugador;
import examen.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus VivoBook
 */
@WebServlet(name = "ControllerJugApuestas", urlPatterns = {"/presentation/jugador/apuestas/show","/presentation/jugador/apuestas/ingresar"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         request.setAttribute("model", new examen.presentation.jugador.apuestas.Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/jugador/apuestas/show":
              viewUrl = this.show(request);
              break;
          case "/presentation/jugador/apuestas/ingresar":
              viewUrl = this.ingresarA(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
        
        
        
        
    }
    
    public String ingresarA(HttpServletRequest request){
                try{
            Map<String,String> errores =  this.validar(request);
            if(errores.isEmpty()){
                this.updateModel(request);          
                return this.ingresar(request);
            }
            else{
                request.setAttribute("errores", errores);
                return "/presentation/login/View.jsp"; 
            }            
        }
        catch(Exception e){
            return "/presentation/Error.jsp";             
        }  
        
    }
    
    
    String ingresar(HttpServletRequest request) throws Exception{
        Model model = (Model) request.getAttribute("model");
        examen.logic.Model domainModel = examen.logic.Model.instance();
        HttpSession session = request.getSession(true);
 
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Jugador cliente=domainModel.clienteFind(usuario);
        try{
            model.seleccionado.setJugador(cliente);
            if(model.getSeleccionado().getNumero()>99||model.getSeleccionado().getNumero()<0||model.getSeleccionado().getApuesta()<100||model.getSeleccionado().getApuesta()>20000){
            Map<String,String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("numeroFld","Numero o monto incorrectos");
            errores.put("montoFld","Numero o monto incorrectos");
            
            model.setApuestas(domainModel.findProximas());
            model.setSorteos(domainModel.sorteosFind(cliente));
            return "/presentation/jugador/apuestas/View.jsp"; 
            }
            
            
            domainModel.sorteoCreate(model.getSeleccionado());
            return "/presentation/jugador/apuestas/show";
        }catch(Exception e){
            
        }
        return "/presentation/Error.jsp";
    }
    
    
            Map<String,String> validar(HttpServletRequest request){
        Map<String,String> errores = new HashMap<>();
        if (request.getParameter("numeroFld").isEmpty()){
            errores.put("numeroFld","Cedula requerida");
        }

        if (request.getParameter("montoFld").isEmpty()){
            errores.put("montoFld","Clave requerida");
        }
        return errores;
    }
    
    void updateModel(HttpServletRequest request){
       examen.presentation.jugador.apuestas.Model model= ( examen.presentation.jugador.apuestas.Model) request.getAttribute("model");
       examen.logic.Model domainModel = examen.logic.Model.instance();
       
       String s=request.getParameter("sorteoFld");
        model.getSeleccionado().setAp(domainModel.findApuesta(request.getParameter("sorteoFld")));
        model.getSeleccionado().setNumero(Integer.parseInt(request.getParameter("numeroFld")));
        model.getSeleccionado().setApuesta(Double.parseDouble(request.getParameter("montoFld")));
        
        
        
   }
    
    
    
String show(HttpServletRequest request){
            Model model = (Model) request.getAttribute("model");
        examen.logic.Model domainModel = examen.logic.Model.instance();
        HttpSession session = request.getSession(true);
 
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Jugador cliente;
        try {
            cliente = domainModel.clienteFind(usuario);
            model.setJugador(cliente);
        } catch (Exception ex) {
            cliente=null;
        } 
        try {        
            model.setApuestas(domainModel.findProximas());
            model.setSorteos(domainModel.sorteosFind(cliente));
            return "/presentation/jugador/apuestas/View.jsp";
        } catch (Exception ex) {
            return "/presentation/Error.jsp";
        }
}
    
    
    
    
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



}
