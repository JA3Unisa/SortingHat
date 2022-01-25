<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 26/01/22
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="risposta" class="Model.Risposta.Risposta" scope="request"/>

<%--Se esiste l'alert lo include --%>
<c:if test="${not empty alert}">
    <%@include file="../partials/alert.jsp"%>
</c:if>

<form method="post" action="../risposte/update">


    <input type="hidden" name="id" value="${risposta.idRisposta}">
    <fieldset class="grid-x form admin">
        <legend>Aggiorna Risposta</legend>
        <label for="Corpo" >
            <input id="Corpo" name="Corpo" placeholder="Corpo" type="text" value="${corpo.nome}" required>
        </label>
        <button type="submit" class="btn primary">Aggiorna</button>
    </fieldset>

</form>