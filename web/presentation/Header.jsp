
<%@page import="examen.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>

            <nav class="navbar navbar-style">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#micon">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        
                        <a href="/examen/presentation/apuestas/show"><img class="logo" src="/examen/images/money.png"></a>
                    </div>
                    <div class="collapse navbar-collapse" id="micon">
                    <ul class="nav navbar-nav navbar-right">
                        

                        <li><a href="/examen/presentation/apuestas/show">Home</a></li>
                          <% if (usuario==null){%>
                        <li><a href="/examen/presentation/login/show">Login</a></li>
                        <%}%>
                          <% if (usuario!=null){%>
                        <li><a href="/examen/presentation/login/logout">Logout</a></li>
                        <%}%>
                         <% if (usuario!=null){%>
                         <li><a href="/examen/presentation/jugador/apuestas/show">Apuestas</a></li>
                         <%}%>
                        
                    </ul>
                         </div>  
                </div>  
                 
            </nav>

  
