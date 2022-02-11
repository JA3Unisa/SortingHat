<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/views/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage,adminDashboard"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - utenteList"/>
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
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>

<main class="app dashboard">

    <%@include file="../partials/adminBar.jsp"%>
    <div id="listaUtenteUtenteList">
        <%@include file="utenteTable.jsp"%>
        <jsp:include page="../partials/paginator.jsp">
            <jsp:param name="risorse" value="utenti"/>
        </jsp:include>
    </div>
</main>
</body>
</html>