<%@ taglib prefix="c-rt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Categoria.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,categorie"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - Categorie"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>

<div id="main">
    <p id="CategorieTitle">Categorie</p>
    <%
        List<Categoria> categoriaList = (List<Categoria>)request.getAttribute("categorie");
            for (Categoria c: categoriaList){
                String nome = c.getNome(), titoloDescrizione = c.getTitoloDescrizione(), descrizione = c.getDescrizione();
                nome = nome.substring(0,1).toUpperCase() + nome.substring(1);
                titoloDescrizione = titoloDescrizione.substring(0,1).toUpperCase() + titoloDescrizione.substring(1);
                descrizione = descrizione.substring(0,1).toUpperCase() + descrizione.substring(1);%>
    <a class="categoria" href="${pageContext.request.contextPath}/pages/discussione?id=<%= c.getIdCategoria()%>">
        <div class="intestazione-categoria">
            <img src="https://miro.medium.com/max/924/1*JvcT-AKla3rnmaMhTP5wbQ.png" alt="" class="img-categoria">
            <div class="testo-intestazione-categoria">
                <p class="titolo-intestazione-categoria"><%= nome%></p>
                <p class="data-intestazione-categoria"><%= c.getDataOra()%></p>
            </div>
        </div>
        <div class="corpo-categoria">
            <p class="titolo-corpo-categoria"><%= titoloDescrizione%></p>
            <p class="descrizione-corpo-categoria"><%= descrizione%></p>
        </div>
    </a>

    <%}%>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
