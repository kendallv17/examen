/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.presentation.apuestas;

import examen.logic.Apuesta;
import examen.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "Controller", urlPatterns = {"/presentation/apuestas/show"})
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

                request.setAttribute("model", new Model());
        
        String viewUrl="";     
        switch (request.getServletPath()) {
          case "/presentation/apuestas/show":
              viewUrl = this.show(request);
              break;
        }          
        request.getRequestDispatcher(viewUrl).forward( request, response); 
        
        
    }
    
        public String show(HttpServletRequest request) {
        return this.showAction(request);
    }
    
        public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        examen.logic.Model domainModel = examen.logic.Model.instance();
        HttpSession session = request.getSession(true);
 
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        List<Apuesta>cursos=null;
        
        
        
        try {
           model.setPasadas(domainModel.findPasadas());
           model.setProximas(domainModel.findProximas());
        } catch (Exception ex) {
        }
        try {        
            return "/presentation/Index.jsp";
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
