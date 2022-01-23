<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="WEB-INF/views/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - Homepage"/>
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
    <jsp:include page="WEB-INF/views/partials/background.jsp"></jsp:include>
    <jsp:include page="WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
    <jsp:include page="WEB-INF/views/partials/menuMobile.jsp"></jsp:include>
    <div id="main">
        <div id="main-text"><span id="joinUnisa">Join <div id="unisa"><p>Unisa</p></div></span><br>Scopri il dipartimento più adatto a te</div>
        <svg id="main-logo" viewBox="0 0 57 56" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M40.8559 29.3537L42.4583 36.5C38.6359 39.9599 33.6756 41.9263 28.5 42.0334C23.3243 41.9263 18.3641 39.9599 14.5416 36.5C14.5416 36.5 15.4796 33.4844 16.8727 29.2154C7.2666 30.9667 0.583313 34.8013 0.583313 39.2667C0.583313 45.3783 13.0816 55.8667 28.5 55.8667C43.9184 55.8667 56.4166 45.3783 56.4166 39.2667C56.4166 34.9147 50.0684 31.1631 40.8559 29.3537Z" fill="black"/>
            <path d="M28.5 30.9667C32.7548 30.9047 36.8896 29.5594 40.3534 27.1099L36.875 11.6L45.25 22.6501C46.5802 21.168 47.5289 19.3889 48.015 17.4648C48.5011 15.5406 48.5103 13.5284 48.0417 11.6C45.25 3.29999 31.2917 0.533333 28.5 0.533333C26.2416 0.533333 18.3579 24.5508 17.3948 27.5858C20.6922 29.746 24.5475 30.9197 28.5 30.9667Z" fill="black"/>
        </svg>
        <a href="/pages/questionarioUtente">
            <div id="comincia">
                <p>Comincia</p>
                <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                </svg>
            </div>
        </a>
        <div id="info">
            <div id="compila" class="info">
                <i class="fas fa-bolt" id="fulmine"></i>
                <p class="title">Compila il form</p>
                <p class="testo">Rispondi a poche domande autovalutative che aiuteranno l’intelligenza artificiale della piattaforma a darti un consiglio</p>
            </div>
            <div id="consiglio" class="info">
                <i class="fas fa-thumbs-up" id="pollice"></i>
                <p class="title">Ricevi un consiglio</p>
                <p class="testo">L’intelligenza artificiale analizzerà le tue risposte e sarà capace di consigliarti quale dipartimento è più adatto a te.</p>
            </div>
            <div id="statistiche" class="info">
                <i class="fas fa-chart-pie" id="torta"></i>
                <p class="title">Visualizza Statistiche</p>
                <p class="testo">Visualizza le statistiche della piattaforma e divertiti a scoprire quanti studenti hanno le tue stesse idee.</p>
            </div>
        </div>
    </div>
    </body>
</html>