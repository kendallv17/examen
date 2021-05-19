<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="examen.logic.Sorteo"%>
<%@page import="examen.logic.Jugador"%>
<%@page import="examen.logic.Apuesta"%>

<%@page import="examen.presentation.jugador.apuestas.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
   examen.presentation.jugador.apuestas.Model model = (Model) request.getAttribute("model");
    List<Apuesta>proximas=model.getApuestas();
    List<Sorteo>a=model.getSorteos();
    Jugador jugador=model.getJugador();
    int i=0;
%>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>

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


            <div class="col-md-8">
             <table class="table table-striped">
                  <label></label>
               <label>Mis apuestas</label>
               
            <thead>
                
                 <tr > <th scope="col">Motivo</th><th scope="col">Fecha</th><th scope="col">Retorno</th> <th scope="col">Ganador</th><th scope="col">Casas</th><th scope="col">Premio</th>  </tr>
            </thead>
            <tbody>
                <% for(Sorteo c:a){%>
                <tr> <td><%=c.getAp().getMotivo()%> </td>  
                        <td><%=c.getAp().getFecha().toString()%></td>
                <td><%=c.getAp().getRetorno()%> </td> 
                 <td><%=c.getAp().getGanador()%> </td>
                  <td><%=c.getApuesta()%>,<%=c.getNumero()%> </td>
                  <td><%=c.getAp().getPremio()%> </td>
                
                </tr> 
    
                        <%}%>
            </tbody>
        </table>    
               </div>
             <div class="col-md-3">
                
            <form action="/examen/presentation/jugador/apuestas/ingresar" method="post">
                  <div class="form-group">
                            <label>Sorteo</label>
                        <select name="sorteoFld" id="tipo">
                             <% for(Apuesta c:proximas){%>
                        <Option value="<%=c.getMotivo()%>"><%=c.getFecha().toString()%>-<%=c.getMotivo()%></Option>
                          <%i++;%>
                         <%}%>
                    </select>
                        </div> 
             <div class="form-group">
              
            <label>Numero debe estar entre 0 y 99</label>
            <input  name="numeroFld" class="form-control" value="<%=form.get("numeroFld")[0]%>" title="<%=title("numeroFld",errores)%>" >
            </div>  
             <div class="form-group">
            
            <label>Monto debe estar entre 100 y 20000</label>
            <input  name="montoFld" class="form-control" value="<%=form.get("montoFld")[0]%>" title="<%=title("montoFld",errores)%>">
            </div>  
             <p style="color:red"><%=title("montoFld",errores)%></p>
                <button class="btn btn-class">Ingresar</button>
                
              </form>
             </div>
            
            
            
             </div>
            
                      
       
       
             
            
            
            
     <%@ include file="/presentation/Footer.jsp" %>
</body> 
</html>

      <%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("montoFld", new String[]{String.valueOf(model.getSeleccionado().getApuesta())});
       values.put("numeroFld", new String[]{String.valueOf(model.getSeleccionado().getNumero())});
       return values;
    }
%> 