<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="categoria" class="Storage.Categoria.Categoria" scope="request"/>

<%--Se esiste l'alert lo include --%>
<c:if test="${not empty alert}">
    <%@include file="../partials/alert.jsp"%>
</c:if>

<form method="post" action="../categorie/update">


    <input type="hidden" name="id" value="${categoria.idCategoria}">
    <fieldset class="grid-x form admin">
        <legend>Aggiorna Categoria</legend>
        <label for="Nome" >
            <input id="Nome" name="Nome" placeholder="Nome" type="text" value="${categoria.nome}" >
        </label>
        <label for="Descrizione" >
            <input id="Descrizione" name="Descrizione" placeholder="Descrizione" type="text" value="${categoria.descrizione}" >
        </label>
        <label for="TitoloDescrizione" >
            <input id="TitoloDescrizione" name="TitoloDescrizione" placeholder="Titolo Descrizione" type="text" value="${categoria.titoloDescrizione}" >
        </label>
        <button type="submit" class="btn primary">Aggiorna</button>
    </fieldset>

</form>