<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,categorie,adminDashboard"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - DashboardAdmin"/>
    </jsp:include>
    <!--<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="discussione.css">
    <link rel="stylesheet" href="../../global/background.css">
    <link rel="stylesheet" href="../../global/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>SortingHat - Categorie Forum</title>-->
</head>
<body>
<jsp:include page="/WEB-INF/Interface/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/Interface/partials/menuMobile.jsp"></jsp:include>

<main class="app dashboard">

    <%@include file="../partials/adminBar.jsp"%>
    <div id="stats">
        <div class="valore">
            <h4>Utenti Registrati:</h4>
            <h2>${utentiNum}</h2>
        </div>
        <div class="valore">
            <h4>Risposte:</h4>
            <h2>${risposteNum}</h2>
        </div>
        <div class="valore">
            <h4>Discussioni:</h4>
            <h2>${discussioniNum}</h2>
        </div>
    </div>

</main>

</body>
</html>
