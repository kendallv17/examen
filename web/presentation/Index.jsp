<%@page import="examen.logic.Apuesta"%>

<%@page import="examen.presentation.apuestas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
   examen.presentation.apuestas.Model model = (Model) request.getAttribute("model");

    List<Apuesta>pasadas=model.getPasadas();
    List<Apuesta>proximas=model.getProximas();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <title>Principal</title> 
 <%@ include file="/presentation/Head.jsp" %>
</head>

    <%@ include file="/presentation/Header.jsp" %>
    
<body>
        <div class="container">

           <div class="col-md-6">
        <table class="table table-striped">
             <label></label>
               <label>Apuestas pasadas</label>
            <thead>
                
                <tr > <th scope="col">Motivo</th><th scope="col">Fecha</th><th scope="col">Retorno</th>  </tr>
            </thead>
            <tbody>
                        <% for(Apuesta c:pasadas){%>
                <tr> <td><%=c.getMotivo()%> </td>  
                        <td><%=c.getFecha().toString()%></td>
                <td><%=c.getRetorno()%> </td> 
                
                </tr> 
                           
                        <%}%>
            </tbody>
        </table>    
       
             </div>
            <div class="col-md-6">
             <table class="table table-striped">
                  <label></label>
               <label>Proximas apuestas</label>
            <thead>
                
                 <tr > <th scope="col">Motivo</th><th scope="col">Fecha</th><th scope="col">Retorno</th> <th scope="col">Ganador</th>  </tr>
            </thead>
            <tbody>
                <% for(Apuesta c:proximas){%>
                <tr> <td><%=c.getMotivo()%> </td>  
                        <td><%=c.getFecha().toString()%></td>
                <td><%=c.getRetorno()%> </td> 
                 <td><%=c.getGanador()%> </td> 
                
                </tr> 
                        
                      
               
                                
                        <%}%>
            </tbody>
        </table>    
               </div>
             </div>
            
                      
       
       
             
            
            
            
     <%@ include file="/presentation/Footer.jsp" %>
     
     <script src="presentation/datos.js"></script>
</body> 
</html>