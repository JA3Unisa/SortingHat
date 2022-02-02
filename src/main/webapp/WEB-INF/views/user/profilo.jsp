
<%@ page import="Model.Utente.UtenteSession" %>
<%@ page import="Model.Utente.Utente" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
  <jsp:include page="../partials/headS.jsp">
    <jsp:param name="userStyles" value="main,background,profilo"/>
    <jsp:param name="userScripts" value="mobileMenu"/>
    <jsp:param name="title" value="SortingHat - Profilo"/>
  </jsp:include>
</head>
<body>
  <jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>
  <% //Utente u= (Utente) request.getAttribute("utente");


  %>

  <img >

  <h2>Nome: </h2><h2>  ${utente.nome} </h2>
  <h2>Cognome: </h2><h2> ${utente.cognome}</h2>
  <h2>Email: </h2><h2> ${utente.email}</h2>
  <h2>Ruolo: ${utente.universitario?  'Universitario':'Ordinario' }</h2>

  <a href="../utenti/logout">Logout</a>

  <a href="../utenti/modificoCliente">
    <div id="comincia">
      <p>Modifica Dati</p>
      <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
      </svg>
    </div>
  </a>



</body>
</html>
