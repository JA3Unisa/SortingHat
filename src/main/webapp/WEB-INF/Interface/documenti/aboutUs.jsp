<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 22/01/22
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/Interface/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - aboutUs"/>
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
    <div id="main-text"><span id="joinUnisa">Salve <div id="unisa"><p>a tutti!</p></div></span></div>
            <br>
            <p>Salve siamo Josef,Matteo,Davide ed Emanuele, siamo 4 studenti dell' università di Fisciano,siamo studenti del terzo anno ed abbiamo</p>
            <p> vissuto anche se in pandemia già buoni 2 anni ,convivendo con lo spirito univeristario  abbiamo riscontrato alcuni problemi come </p>
            <p>la mancanza di informazioni relative a ciò a cui andavamo in contro,quindi spinti dalla scusa del progetto ci siamo riuniti per poter creare </p>
            <p>un forum funzionale sulla divulgazione di informazioni da parte degli altri studenti già "esperti" rispetto ai maturandi o ai primini.</p>
        </div>
</div>
</body>
</html>