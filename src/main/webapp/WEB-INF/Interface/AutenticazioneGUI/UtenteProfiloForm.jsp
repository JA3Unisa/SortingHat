<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/01/2022
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/Interface/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - UtenteUpdate"/>
    </jsp:include>


</head>
<body>
<jsp:include page="/WEB-INF/Interface/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuMobile.jsp"></jsp:include>

<form method="post" action="../utenti/modificoUtente">


    <input type="hidden" name="id" value="${utente.idUtente}">
    <input type="hidden" name="id" value="${utente.password}">
    <input type="hidden" name="id" value="${utente.universitario}">
    <fieldset class="grid-x form admin">
        <legend>Aggiorna Utente</legend>
        <input type="hidden" name="id" value="${utente.idUtente}">
        <label for="Nome" >
            <input id="Nome" name="Nome" placeholder="Nome" type="text" value="${utente.nome}" required maxlength="20">
        </label>
        <label for="Cognome" >
            <input id="Cognome" name="Cognome" placeholder="Cognome" type="text" value="${utente.cognome}" required maxlength="20">
        </label>
        <label for="Email" >
            <input id="Email" name="Email" placeholder="Email" type="text" value="${utente.email}" required>
        </label>
        <button type="submit" class="btn primary">Aggiorna</button>
    </fieldset>

</form>
<body>

</body>
</html>