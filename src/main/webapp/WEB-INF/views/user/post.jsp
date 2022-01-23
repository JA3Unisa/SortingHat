<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,post"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - Post Forum"/>
    </jsp:include>
    <!--<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="../../global/background.css">
    <link rel="stylesheet" href="../../global/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>SortingHat - Post Forum</title>-->
</head>
<body>
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>
<div id="main">
    <p id="PostTitle">Post [Esami]</p>
    <a class="post" href="">
        <div class="intestazione-post">
            <img src="data:image/jpeg;base64,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" alt="" class="img-categoria">
            <div class="testo-intestazione-post">
                <p class="nome-utente">Matteo</p>
                <p class="data-intestazione-post">12/01/2022 13:44</p>
            </div>
            <i class="fas fa-pencil-alt edit-intestazione-post"></i>
        </div>
        <div class="corpo-post">
            <p class="titolo-corpo-post">Esame di IS</p>
            <p class="descrizione-corpo-post">Sto trovando difficoltà con la struttura del RAD, qualcuno saprebbe dirmi [...]</p>
        </div>
    </a>
    <a class="post" href="">
        <div class="intestazione-post">
            <img src="data:image/png;base64,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" alt="" class="img-categoria">
            <div class="testo-intestazione-post">
                <p class="nome-utente">Josef</p>
                <p class="data-intestazione-post">15/01/2022 23:44</p>
            </div>
            <i class="fas fa-pencil-alt edit-intestazione-post"></i>
        </div>
        <div class="corpo-post">
            <p class="titolo-corpo-post">Esame di FIA</p>
            <p class="descrizione-corpo-post">Ma esattamente, Arad dove si trova? No perchè io non riesco a capire [...]</p>
        </div>
    </a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
