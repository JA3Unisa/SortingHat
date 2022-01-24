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
        <jsp:param name="userStyles" value="main,background,categorie"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat -DashboardAdmin"/>
    </jsp:include>
    <!--<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="../../global/background.css">
    <link rel="stylesheet" href="../../global/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>SortingHat - Categorie Forum</title>-->
</head>
<body>
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>

<main class="app dashboard">

    <%@include file="../partials/adminBar.jsp"%>
    <section class="content grid-y">

        <div class="body grid-x justify-center">
            <div class="valori">
                <jsp:include page="../partials/statscard.jsp">
                    <jsp:param name="title" value="Utenti Registrati"/>
                    <jsp:param name="stat" value="${utentiNum}"/>

                </jsp:include>
            </div><div class="valori">
            <jsp:include page="../partials/statscard.jsp">
                <jsp:param name="title" value="Risposte "/>
                <jsp:param name="stat" value="${risposteNum}"/>

            </jsp:include>
        </div><div class="valori">
            <jsp:include page="../partials/statscard.jsp">
                <jsp:param name="title" value="Discussioni "/>
                <jsp:param name="stat" value="${discussioniNum}"/>

            </jsp:include>

        </div>
        </div>

    </section>

</main>

</body>
</html>
