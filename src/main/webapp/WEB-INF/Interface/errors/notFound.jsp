<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 22/12/21
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/Interface/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - notFound"/>
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
<div id="main">
    <div id="main-text"><span id="joinUnisa">Error <div id="unisa"><p>404</p></div></span></div>

    <p>Errore 404,ritorna alla Home e ritenta</p>
    <a href="${pageContext.request.contextPath}/pages/" class="selected">Home</a>
</div>
</div>
</body>
</html>