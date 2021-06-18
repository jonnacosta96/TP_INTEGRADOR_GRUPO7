
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
       <a><img src="assets/img/logo.png" height="30px" alt="" style="margin-right: 10px;"></a>
      <container>
        <a class="navbar-brand mr-5 text-light">UTN Banking</a>
      </container>
      <button class="navbar-toggler" type="button">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
          <a class="nav-link">Home</a>
          </li>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Administrar
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a href="${pageContext.servletContext.contextPath}/adminCuentas.html"class="dropdown-item">Cuentas</a>
              <a href="${pageContext.servletContext.contextPath}/adminClientes.html" class="dropdown-item">Clientes</a>
          </div>
          </li>
      </ul>
      </div>
      <div class="d-flex align-items-center">
          <ul class="navbar-nav mr-auto">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-light"  id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  userName
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item">Logout</a>
                </div>
              </li>
            </ul>
        </div>
  </nav>
