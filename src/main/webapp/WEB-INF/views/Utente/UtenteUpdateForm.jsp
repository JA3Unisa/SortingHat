<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="utente" class="Model.Utente.Utente" scope="request"/>

<%--Se esiste l'alert lo include --%>
<c:if test="${not empty alert}">
    <%@include file="../partials/alert.jsp"%>
</c:if>

<form method="post" action="../utenti/update">


    <input type="hidden" name="id" value="${utente.idUtente}">
    <fieldset class="grid-x form admin">
        <legend>Aggiorna Utente</legend>
        <label for="Titolo" >
            <input id="Titolo" name="Titolo" placeholder="Titolo" type="text" value="${utente.nome}" required>
        </label>
        <label for="Corpo" >
            <input id="Corpo" name="Corpo" placeholder="Corpo" type="text" value="${utente.cognome}" required>
        </label>
        <label for="Email" >
            <input id="Email" name="Email" placeholder="Email" type="text" value="${utente.email}" required>
        </label>
        <label for="Universitario" >
            <input id="Universitario" name="Universitario" placeholder="Universitario" type="text" value="${utente.universitario}" required>
        </label>
        <label for="Ruolo" >
            <input id="Ruolo" name="Ruolo" placeholder="Ruolo" type="number" value="${utente.ruolo}" pattern="([1-3])"
                   title="Il prezzo deve essere un numero tra 1 e 3 " required>
        </label>
        <button type="submit" class="btn primary">Aggiorna</button>
    </fieldset>

</form>