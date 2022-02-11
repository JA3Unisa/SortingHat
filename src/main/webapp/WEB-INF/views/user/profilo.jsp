
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
  <div id="utenteInfoAll">
  <div class="infoUtente"><h2>Nome: </h2>${utente.nome}</div>
  <div class="infoUtente"><h2>Cognome: </h2>${utente.cognome}</div>
  <div class="infoUtente"><h2>Email: </h2>${utente.email}</div>
  <div class="infoUtente"><h2>Ruolo: </h2>${utente.universitario ? 'Universitario':'Ordinario'}</div>

    <div class="userOperation"><a href="../utenti/logout">Logout</a></div>
    <div class="userOperation"><a href="../utenti/modificoCliente">Modifica dati</a></div>
  </div>


</body>
</html>
