<%@ page session= "true" %>
<%@ page import="frgp.utn.edu.ar.dto.UserSessionDto" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a><img src="assets/img/logo.png" height="30px" alt="" style="margin-right: 10px;"></a>
        <ng-container>
          <a class="navbar-brand mr-5 text-light">UTN Banking</a>
        </ng-container>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

        </div>
        <div class="d-flex align-items-center" style="cursor:pointer">
          <ul class="navbar-nav mr-auto">
              <li class="nav-item dropdown" style="cursor:pointer">
                <a class="nav-link dropdown-toggle text-light"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <% 
					    UserSessionDto userSession = (UserSessionDto)session.getAttribute("userSession");
					%>
					<%= userSession.getUserName() %>
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/logout.html">Logout</a>
                </div>
              </li>
            </ul>
        </div>
    </nav>