<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="categoria" class="Model.Discussione.Discussione" scope="request"/>

<%--Se esiste l'alert lo include --%>
<c:if test="${not empty alert}">
    <%@include file="../partials/alert.jsp"%>
</c:if>

<form method="post" action="../discussioni/update">


    <input type="hidden" name="id" value="${discussione.idDiscussione}">
    <fieldset class="grid-x form admin">
        <legend>Aggiorna Categoria</legend>
        <label for="Titolo" >
            <input id="Titolo" name="Titolo" placeholder="Titolo" type="text" value="${discussione.Titolo}" required>
        </label>
        <label for="Corpo" >
            <input id="Corpo" name="Corpo" placeholder="Corpo" type="text" value="${discussione.corpo}" required>
        </label>
        <button type="submit" class="btn primary">Aggiorna</button>
    </fieldset>

</form>