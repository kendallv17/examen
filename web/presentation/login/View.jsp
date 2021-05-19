<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="examen.presentation.login.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
     <%@ include file="/presentation/Head.jsp" %>
    </head>
    <body>
    <%@ include file="/presentation/Header.jsp" %>
       
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>

        <div class="container">
            <div class="row content">
                <div class="col-md-6 mb-3">
                    <img src="/proyecto/images/icon.png" class="img-fluid" alt="image">
                </div>
                <div class="col-md-6">
                    <h3 class="signin-text mb-3"> SIGN IN</h3>
                    <form action="/examen/presentation/login/login" method="post">
  
                        <div class="form-group">
                            <label>ID</label>
                            <input  name="cedulaFld" class="form-control" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld",errores)%>" >
                        </div>
                        <div class="form-group">
                            <label for="password">PASSWORD</label>
                            <input type="password" name="claveFld" class="form-control" value="<%=form.get("claveFld")[0]%>" title="<%=title("claveFld",errores)%>" >
                        </div>  
                        <div class="form-group form-check">
                            <input type="checkbox" name="checkbox" class="form-check-input" id="checkbox">
                            <label class="form-check-label" for="checkbox">Remember me</label>
                        </div>
                        <p style="color:red"><%=title("claveFld",errores)%></p>
                        <button class="btn btn-class">LOGIN</button>
                    </form>
                   
                </div>
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
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("claveFld", new String[]{model.getCurrent().getClave()});
       return values;
    }
%> 

