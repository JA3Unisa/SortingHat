<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 11/02/22
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="discussione" class="Storage.Discussione.Discussione" scope="request"/>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/Interface/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage,adminDashboard"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - DiscussioneCreateUtente"/>
    </jsp:include>

    <!--<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/user/background.css">
    <link rel="stylesheet" href="css/user/main.css">
    <link rel="stylesheet" href="css/user/homepage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>SortingHat - Homepage</title>-->
</head>
<body>
<jsp:include page="/WEB-INF/Interface/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuMobile.jsp"></jsp:include>

<main class="app dashboard">
    <section class="grid-y">
        <div class="grid-x justify-center ">
            <c:if test="${not empty alert}">
                <%@include file="../partials/alert.jsp"%>
            </c:if>

            <form method="post" action="../discussioni/createUtente">



                <fieldset class="grid-x form admin">
                    <legend>Crea discussione</legend>
                    <label for="Titolo" >
                        <input id="Titolo" name="Titolo" placeholder="Titolo" type="text" value="${discussione.titolo}" >
                    </label>
                    <label for="Corpo" >
                        <input id="Corpo" name="Corpo" placeholder="Corpo" type="text" value="${discussione.corpo}" >
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

        </div>

    </section>

</main>
<body>

</body>
</html>