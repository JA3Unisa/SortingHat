<%--
  Created by IntelliJ IDEA.
  User: 39331
  Date: 10/02/2022
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="it">
<head>
    <jsp:include page="../partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,statistiche"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - Statistiche"/>
    </jsp:include>
</head>
<body>
<input type="hidden" id="statistiche_jsp" value='${stats}'>
<div id="rectangle-background">
    <div id="dotted">
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
        <div class="dot"></div>
    </div>
</div>
<div id="menu_desktop">
    <div id="logo">
        <svg id="img" width="57" height="56" viewBox="0 0 57 56" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M40.8559 29.3537L42.4583 36.5C38.6359 39.9599 33.6756 41.9263 28.5 42.0334C23.3243 41.9263 18.3641 39.9599 14.5416 36.5C14.5416 36.5 15.4796 33.4844 16.8727 29.2154C7.2666 30.9667 0.583313 34.8013 0.583313 39.2667C0.583313 45.3783 13.0816 55.8667 28.5 55.8667C43.9184 55.8667 56.4166 45.3783 56.4166 39.2667C56.4166 34.9147 50.0684 31.1631 40.8559 29.3537Z" fill="black"/>
            <path d="M28.5 30.9667C32.7548 30.9047 36.8896 29.5594 40.3534 27.1099L36.875 11.6L45.25 22.6501C46.5802 21.168 47.5289 19.3889 48.015 17.4648C48.5011 15.5406 48.5103 13.5284 48.0417 11.6C45.25 3.29999 31.2917 0.533333 28.5 0.533333C26.2416 0.533333 18.3579 24.5508 17.3948 27.5858C20.6922 29.746 24.5475 30.9197 28.5 30.9667Z" fill="black"/>
        </svg>
        <p id="title">Sorting Hat</p>
    </div>
    <div id="scelte">
        <a href="" class="selected">Home</a>
        <div class="separatorDot"></div>
        <a href="">Chi siamo</a>
        <div class="separatorDot"></div>
        <a href="">Contribuisci</a>
        <div class="separatorDot"></div>
        <a href="">Forum</a>
    </div>
    <div id="utente">
        <a href="">Login</a>
    </div>
</div>
<div id="menu_mobile">
    <i class="fas fa-bars" id="openMobileMenu" style="display: none" onclick="openMenuMobile()"></i>
    <div id="logo_mobile">
        <svg id="img" width="57" height="56" viewBox="0 0 57 56" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M40.8559 29.3537L42.4583 36.5C38.6359 39.9599 33.6756 41.9263 28.5 42.0334C23.3243 41.9263 18.3641 39.9599 14.5416 36.5C14.5416 36.5 15.4796 33.4844 16.8727 29.2154C7.2666 30.9667 0.583313 34.8013 0.583313 39.2667C0.583313 45.3783 13.0816 55.8667 28.5 55.8667C43.9184 55.8667 56.4166 45.3783 56.4166 39.2667C56.4166 34.9147 50.0684 31.1631 40.8559 29.3537Z" fill="black"/>
            <path d="M28.5 30.9667C32.7548 30.9047 36.8896 29.5594 40.3534 27.1099L36.875 11.6L45.25 22.6501C46.5802 21.168 47.5289 19.3889 48.015 17.4648C48.5011 15.5406 48.5103 13.5284 48.0417 11.6C45.25 3.29999 31.2917 0.533333 28.5 0.533333C26.2416 0.533333 18.3579 24.5508 17.3948 27.5858C20.6922 29.746 24.5475 30.9197 28.5 30.9667Z" fill="black"/>
        </svg>
        <p id="title_mobile">Sorting Hat</p>
    </div>
    <div id="main_menu_mobile" class="menuMobileChiuso">
        <i class="fas fa-times" id="close" onclick="closeMenuMobile()"></i>
        <div id="scelte_mobile">
            <a href="" class="selected">Home</a>
            <div class="separatorDot"></div>
            <a href="">Chi siamo</a>
            <div class="separatorDot"></div>
            <a href="">Contribuisci</a>
            <div class="separatorDot"></div>
            <a href="">Forum</a>
        </div>
        <div id="utente_mobile">
            <a href="">Login</a>
        </div>
    </div>

</div>
<div id="main">
    <canvas id="predict-chart"></canvas>
    <canvas id="contribuisci-chart"></canvas>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.0.0/chart.min.js"></script>
<script>
    // Bar chart
    Chart.defaults.font.size = 40;

    function loadCharts(data){
        data = [
            [
                {
                    "idCategoria": 15,
                    "nome": "esami",
                    "descrizione": "chiedi qui tutto quello che vuoi degli esami",
                    "dataOra": "Feb 2, 2022, 5:35:52 PM",
                    "titoloDescrizione": "categoria riservata agli esami"
                },
                {
                    "idCategoria": 16,
                    "nome": "magistrali",
                    "descrizione": "chiedi qui tutto quello che vuoi sulle magistrali",
                    "dataOra": "Feb 2, 2022, 5:35:52 PM",
                    "titoloDescrizione": "categoria riservata alle magistrali"
                },
                {
                    "idCategoria": 10054,
                    "nome": "Test",
                    "descrizione": "TestCat",
                    "dataOra": "Feb 9, 2022, 10:54:03 PM",
                    "titoloDescrizione": "TestTitolo"
                }
            ],
            [
                {
                    "id": 1,
                    "dipartimento": 12,
                    "dataOra": "Jan 28, 2022, 5:47:54 PM"
                },
                {
                    "id": 2,
                    "dipartimento": 2,
                    "dataOra": "Feb 1, 2022, 10:31:15 PM"
                },
                {
                    "id": 3,
                    "dipartimento": 6,
                    "dataOra": "Feb 1, 2022, 10:31:43 PM"
                },
                {
                    "id": 4,
                    "dipartimento": 6,
                    "dataOra": "Feb 2, 2022, 5:23:36 PM"
                },
                {
                    "id": 5,
                    "dipartimento": 5,
                    "dataOra": "Feb 4, 2022, 9:17:11 PM"
                },
                {
                    "id": 6,
                    "dipartimento": 0,
                    "dataOra": "Feb 4, 2022, 9:21:15 PM"
                },
                {
                    "id": 7,
                    "dipartimento": 3,
                    "dataOra": "Feb 4, 2022, 9:39:01 PM"
                },
                {
                    "id": 8,
                    "dipartimento": 0,
                    "dataOra": "Feb 4, 2022, 9:42:05 PM"
                },
                {
                    "id": 9,
                    "dipartimento": 12,
                    "dataOra": "Feb 5, 2022, 11:17:10 AM"
                },
                {
                    "id": 12,
                    "dipartimento": 3,
                    "dataOra": "Feb 7, 2022, 3:44:14 PM"
                },
                {
                    "id": 13,
                    "dipartimento": 3,
                    "dataOra": "Feb 8, 2022, 7:52:26 AM"
                },
                {
                    "id": 14,
                    "dipartimento": 3,
                    "dataOra": "Feb 8, 2022, 1:06:36 PM"
                },
                {
                    "id": 15,
                    "dipartimento": 3,
                    "dataOra": "Feb 8, 2022, 7:50:23 PM"
                }
            ],
            [
                {
                    "id": 1,
                    "idUtente": 0,
                    "domande": [
                        0
                    ]
                },
                {
                    "id": 2,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 3,
                    "idUtente": 0,
                    "domande": [
                        9
                    ]
                },
                {
                    "id": 4,
                    "idUtente": 0,
                    "domande": [
                        5
                    ]
                },
                {
                    "id": 5,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 6,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 7,
                    "idUtente": 0,
                    "domande": [
                        11
                    ]
                },
                {
                    "id": 8,
                    "idUtente": 0,
                    "domande": [
                        4
                    ]
                },
                {
                    "id": 9,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 10,
                    "idUtente": 0,
                    "domande": [
                        1
                    ]
                },
                {
                    "id": 11,
                    "idUtente": 0,
                    "domande": [
                        4
                    ]
                },
                {
                    "id": 12,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 13,
                    "idUtente": 0,
                    "domande": [
                        4
                    ]
                },
                {
                    "id": 14,
                    "idUtente": 0,
                    "domande": [
                        16
                    ]
                },
                {
                    "id": 15,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 16,
                    "idUtente": 0,
                    "domande": [
                        1
                    ]
                },
                {
                    "id": 17,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 18,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 19,
                    "idUtente": 0,
                    "domande": [
                        1
                    ]
                },
                {
                    "id": 20,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 21,
                    "idUtente": 0,
                    "domande": [
                        1
                    ]
                },
                {
                    "id": 22,
                    "idUtente": 0,
                    "domande": [
                        11
                    ]
                },
                {
                    "id": 23,
                    "idUtente": 0,
                    "domande": [
                        11
                    ]
                },
                {
                    "id": 24,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 25,
                    "idUtente": 0,
                    "domande": [
                        4
                    ]
                },
                {
                    "id": 26,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 27,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 28,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 29,
                    "idUtente": 0,
                    "domande": [
                        5
                    ]
                },
                {
                    "id": 30,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 31,
                    "idUtente": 0,
                    "domande": [
                        4
                    ]
                },
                {
                    "id": 32,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 33,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 34,
                    "idUtente": 0,
                    "domande": [
                        11
                    ]
                },
                {
                    "id": 35,
                    "idUtente": 0,
                    "domande": [
                        9
                    ]
                },
                {
                    "id": 36,
                    "idUtente": 0,
                    "domande": [
                        11
                    ]
                },
                {
                    "id": 37,
                    "idUtente": 0,
                    "domande": [
                        1
                    ]
                },
                {
                    "id": 38,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 39,
                    "idUtente": 0,
                    "domande": [
                        8
                    ]
                },
                {
                    "id": 40,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 41,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 42,
                    "idUtente": 0,
                    "domande": [
                        10
                    ]
                },
                {
                    "id": 43,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 44,
                    "idUtente": 0,
                    "domande": [
                        0
                    ]
                },
                {
                    "id": 45,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 46,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 47,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 48,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 49,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 50,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 51,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 52,
                    "idUtente": 0,
                    "domande": [
                        0
                    ]
                },
                {
                    "id": 53,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 54,
                    "idUtente": 0,
                    "domande": [
                        0
                    ]
                },
                {
                    "id": 55,
                    "idUtente": 0,
                    "domande": [
                        16
                    ]
                },
                {
                    "id": 56,
                    "idUtente": 0,
                    "domande": [
                        9
                    ]
                },
                {
                    "id": 57,
                    "idUtente": 0,
                    "domande": [
                        8
                    ]
                },
                {
                    "id": 58,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 59,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                },
                {
                    "id": 60,
                    "idUtente": 0,
                    "domande": [
                        0
                    ]
                },
                {
                    "id": 61,
                    "idUtente": 0,
                    "domande": [
                        9
                    ]
                },
                {
                    "id": 62,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 63,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 64,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 65,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 66,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 67,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 68,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 69,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 70,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 71,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 72,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 73,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 74,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 75,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 76,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 77,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 78,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 79,
                    "idUtente": 0,
                    "domande": [
                        12
                    ]
                },
                {
                    "id": 80,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 81,
                    "idUtente": 0,
                    "domande": [
                        9
                    ]
                },
                {
                    "id": 82,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 83,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 84,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 85,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 86,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 87,
                    "idUtente": 0,
                    "domande": [
                        3
                    ]
                },
                {
                    "id": 88,
                    "idUtente": 0,
                    "domande": [
                        10
                    ]
                },
                {
                    "id": 89,
                    "idUtente": 0,
                    "domande": [
                        10
                    ]
                },
                {
                    "id": 90,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 91,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 92,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 93,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 94,
                    "idUtente": 0,
                    "domande": [
                        7
                    ]
                },
                {
                    "id": 95,
                    "idUtente": 0,
                    "domande": [
                        5
                    ]
                },
                {
                    "id": 96,
                    "idUtente": 0,
                    "domande": [
                        10
                    ]
                },
                {
                    "id": 97,
                    "idUtente": 0,
                    "domande": [
                        10
                    ]
                },
                {
                    "id": 98,
                    "idUtente": 0,
                    "domande": [
                        6
                    ]
                },
                {
                    "id": 99,
                    "idUtente": 0,
                    "domande": [
                        13
                    ]
                },
                {
                    "id": 100,
                    "idUtente": 0,
                    "domande": [
                        2
                    ]
                }
            ]
        ];

        let dipartimenti = ["DI", "DIEM", "DIFARMA", "DISES", "DISA-MIS", "DISPAC", "DIN", "DCIV", "DISPC", "DIPMED", "DCB", "DIPSUM", "DISUFF", "DF", "DISPS", "DSG", "DIPMAT"];

        let categorie = data[0];
        let predict = data[1];
        let contribuisci = data[2];

        let predictDipartimentiUsati = [];
        predict.forEach(el=>{
            trovato = false;
            predictDipartimentiUsati.forEach(el2 =>{
                if(el2.dipartimento==dipartimenti[el.dipartimento]){
                    trovato = true;
                    el2.usato++;
                }
            })
            if(!trovato){
                predictDipartimentiUsati.push({dipartimento: dipartimenti[el.dipartimento], usato: 1})
            }
        })
        var colorPredict = [];
        for(var i = 0; i < predictDipartimentiUsati.length; i++)
            colorPredict.push("#"+Math.floor(Math.random()*16777215).toString(16));

        let contribuisciDipartimentiUsati = [];
        contribuisci.forEach(el=>{
            trovato = false;
            contribuisciDipartimentiUsati.forEach(el2 =>{
                if(el2.dipartimento==dipartimenti[el.domande[0]]){
                    trovato = true;
                    el2.usato++;
                }
            })
            if(!trovato){
                contribuisciDipartimentiUsati.push({dipartimento: dipartimenti[el.domande[0]], usato: 1})
            }
            if(dipartimenti[el.domande[0]]==undefined){

                console.log(el.domande[0])
            }
        })
        var colorContribuisci = [];
        for(var i = 0; i < contribuisciDipartimentiUsati.length; i++)
            colorContribuisci.push("#"+Math.floor(Math.random()*16777215).toString(16));


        new Chart(document.getElementById("predict-chart"), {
            type: 'bar',
            data: {
                labels: predictDipartimentiUsati.map(el =>{ return el.dipartimento }),
                datasets: [
                    {
                        label: "Consigli generati",
                        backgroundColor: colorPredict,
                        data: predictDipartimentiUsati.map(el =>{ return el.usato })
                    }
                ]
            }
        });

        new Chart(document.getElementById("contribuisci-chart"), {
            type: 'pie',
            data: {
                labels: contribuisciDipartimentiUsati.map(el =>{ return el.dipartimento }),
                datasets: [{
                    label: "Contributi",
                    backgroundColor: colorContribuisci,
                    data: contribuisciDipartimentiUsati.map(el =>{ return el.usato })
                }]
            }
        });
    }

    loadCharts(document.getElementById("statistiche_jsp").value);

</script>
</body>
</html>
