<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 28/01/22
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="discussione" class="Storage.Discussione.Discussione" scope="request"/>

<%--Se esiste l'alert lo include --%>
<c:if test="${not empty alert}">
    <%@include file="../partials/alert.jsp"%>
</c:if>

<form method="post" action="../discussioni/create">



    <fieldset class="grid-x form admin">
        <legend>Crea discussione</legend>
        <label for="Titolo" >
            <input id="Titolo" name="Titolo" placeholder="Titolo" type="text" value="${discussione.titolo}" required>
        </label>
        <label for="Corpo" >
            <input id="Corpo" name="Corpo" placeholder="Corpo" type="text" value="${discussione.corpo}" required>
        </label>
        <label for="Categoria" >
            <select name="Categoria" id="Categoria">
                <c:forEach items="${categorie}" var="categoria">
                    <option value="${categoria.idCategoria}">${categoria.nome}</option>
                </c:forEach>

            </select>
        </label>
        <input type="hidden" name="idUtente" value="${risposta.utente.idUtente}">
        <button type="submit" class="btn primary">Crea</button>
    </fieldset>

</form>
