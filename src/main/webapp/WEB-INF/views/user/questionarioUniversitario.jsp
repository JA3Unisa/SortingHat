<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,questionarioUniversitario"/>
        <jsp:param name="userScripts" value="mobileMenu,questionarioUniversitario"/>
        <jsp:param name="title" value="SortingHat - Contribuisci"/>
    </jsp:include>
    <!--<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="discussione.css">
    <link rel="stylesheet" href="../global/background.css">
    <link rel="stylesheet" href="../global/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>SortingHat - Contribuisci</title>-->
</head>
<body>
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>
<div id="main">
    <div id="questionarioUniversitario">
        <div class="domanda show">
            <p>Di che dipartimento fai parte?</p>
            <select name="domanda1" id="domanda1" required>
                <option value="0">DI (informatica)</option>
                <option value="1">DIEM (ingegneria informatica)</option>
                <option value="2">DIFARMA (gestione e valorizzazione delle risorse agrarie e delle aree protette - tecniche erboristiche - chimica e tecnologia farmaceutiche - farmacia)</option>
                <option value="3">DISES (economia aziendale - economia e commercio - scienze dell'amministrazione e dell'organizzazione - statistica per i big data - economia, valorizzazione, gestione del patrimonio turistico)</option>
                <option value="4">DISA-MIS (economia e management)</option>
                <option value="5">DISPAC (discipline delle arti visive - della musica e dello spettacolo - filosofia - scienze dei beni culturali)</option>
                <option value="6">DIN (ingegneria chimica - ingegneria elettronica - ingegneria gestionale - ingegneria meccanica)</option>
                <option value="7">DCIV (ingegneria civile - ingegneria civile per l'ambiente ed il territorio - ingegneria edile/architettura)</option>
                <option value="8">DISPC (scienze della comunicazione - scienze politiche e delle relazioni internazionali)</option>
                <option value="9">DIPMED (fisioterapia - infermieristica - ostetricia - tecniche di radiologia medica, per immagini e radioterapia - medicina e chirurgia - odontoiatria e protesi dentaria)</option>
                <option value="10">DCB (chimica - scienze ambientali - scienze biologiche)</option>
                <option value="11">DIPSUM (lettere - lingue e culture straniere)</option>
                <option value="12">DISUFF (scienze dell'educazione - scienze delle attività motorie, sportive e dell'educazione psicomotoria - scienze della formazione primaria)</option>
                <option value="13">DF (fisica)</option>
                <option value="14">DISPS (sociologia - studi diplomatici, internazionali e sulla sicurezza globale)</option>
                <option value="15">DSG (giurista d'impresa e delle nuove tecnologie - giurisprudenza)</option>
                <option value="16">DIPMAT (matematica)</option>
            </select>
            <div class="comandi">
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Che istituto hai frequentato?</p>
            <select name="domanda1" id="domanda2" required>
                <option value="0">Liceo artistico</option>
                <option value="1">Liceo classico</option>
                <option value="2">Liceo linguistico</option>
                <option value="3">Liceo musicale e coreutico</option>
                <option value="4">Liceo scientifico</option>
                <option value="5">Liceo scientifico - scienze applicate</option>
                <option value="6">Liceo scientifico - indirizzo sportivo</option>
                <option value="7">Liceo delle scienze umane</option>
                <option value="8">Liceo delle scienze umane - economico/sociale</option>
                <option value="9">Amministrazione, Finanza e Marketing</option>
                <option value="10">Turismo</option>
                <option value="11">Meccanica, Meccatronica ed Energia</option>
                <option value="12">Trasporti e Logistica</option>
                <option value="13">Elettronica ed Elettrotecnica</option>
                <option value="14">Informatica e Telecomunicazioni</option>
                <option value="15">Grafica e Comunicazione</option>
                <option value="16">Chimica, Materiali e Biotecnologie</option>
                <option value="17">Sistema Moda</option>
                <option value="18">Agraria, Agroalimentare e Agroindustria</option>
                <option value="19">Costruzioni, Ambiente e Territorio</option>
                <option value="20">Agricoltura, sviluppo rurale, valorizzazione dei prodotti del territorio e gestione [...]</option>
                <option value="21">Pesca commerciale e produzioni ittiche</option>
                <option value="22">Industria e artigianato per il Made in Italy</option>
                <option value="23">Manutenzione e assistenza tecnica</option>
                <option value="24">Gestione delle acque e risanamento ambientale</option>
                <option value="25">Servizi commerciali</option>
                <option value="26">Enogastronomia e ospitalità alberghiera</option>
                <option value="27">Servizi culturali e dello spettacolo</option>
                <option value="28">Servizi per la sanità e l’assistenza sociale</option>
                <option value="29">Arti ausiliarie delle professioni sanitarie: odontotecnico</option>
                <option value="30">Arti ausiliarie delle professioni sanitarie: ottico</option>
            </select>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda" >
            <p>La tua materia preferita è inerente al tuo indirizzo di studio superiore?</p>
            <div class="radio">
                <input type="radio" id="materiaPreferitaSI" name="materiaPreferita" value="1">
                <label for="materiaPreferitaSI">SI</label>
                <input type="radio" id="materiaPreferitaNO" name="materiaPreferita" value="0">
                <label for="materiaPreferitaNO">NO</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto tempo utilizzi il tuo computer ogni giorno?</p>
            <div class="radio" >
                <input type="radio" id="computerGiorno1" name="computerGiorno" value="1">
                <label for="computerGiorno1">1</label>
                <input type="radio" id="computerGiorno2" name="computerGiorno" value="2">
                <label for="computerGiorno2">2</label>
                <input type="radio" id="computerGiorno3" name="computerGiorno" value="3">
                <label for="computerGiorno3">3</label>
                <input type="radio" id="computerGiorno4" name="computerGiorno" value="4">
                <label for="computerGiorno4">4</label>
                <input type="radio" id="computerGiorno5" name="computerGiorno" value="5">
                <label for="computerGiorno5">5</label>
                <input type="radio" id="computerGiorno6" name="computerGiorno" value="6">
                <label for="computerGiorno6">6</label>
                <input type="radio" id="computerGiorno7" name="computerGiorno" value="7">
                <label for="computerGiorno7">7</label>
                <input type="radio" id="computerGiorno8" name="computerGiorno" value="8">
                <label for="computerGiorno8">8</label>
                <input type="radio" id="computerGiorno9" name="computerGiorno" value="9">
                <label for="computerGiorno9">9</label>
                <input type="radio" id="computerGiorno10" name="computerGiorno" value="10">
                <label for="computerGiorno10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti piacerebbe contribuire all’evoluzione di internet?</p>
            <div class="radio">
                <input type="radio" id="evoluzioneInternet1" name="evoluzioneInternet" value="1">
                <label for="evoluzioneInternet1">1</label>
                <input type="radio" id="evoluzioneInternet2" name="evoluzioneInternet" value="2">
                <label for="evoluzioneInternet2">2</label>
                <input type="radio" id="evoluzioneInternet3" name="evoluzioneInternet" value="3">
                <label for="evoluzioneInternet3">3</label>
                <input type="radio" id="evoluzioneInternet4" name="evoluzioneInternet" value="4">
                <label for="evoluzioneInternet4">4</label>
                <input type="radio" id="evoluzioneInternet5" name="evoluzioneInternet" value="5">
                <label for="evoluzioneInternet5">5</label>
                <input type="radio" id="evoluzioneInternet6" name="evoluzioneInternet" value="6">
                <label for="evoluzioneInternet6">6</label>
                <input type="radio" id="evoluzioneInternet7" name="evoluzioneInternet" value="7">
                <label for="evoluzioneInternet7">7</label>
                <input type="radio" id="evoluzioneInternet8" name="evoluzioneInternet" value="8">
                <label for="evoluzioneInternet8">8</label>
                <input type="radio" id="evoluzioneInternet9" name="evoluzioneInternet" value="9">
                <label for="evoluzioneInternet9">9</label>
                <input type="radio" id="evoluzioneInternet10" name="evoluzioneInternet" value="10">
                <label for="evoluzioneInternet10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti interessa contribuire al progresso scientifico attraverso la produzione o l'ottimizzazione di farmaci?</p>
            <div class="radio">
                <input type="radio" id="ottimizzazioneFarmaci1" name="ottimizzazioneFarmaci" value="1">
                <label for="ottimizzazioneFarmaci1">1</label>
                <input type="radio" id="ottimizzazioneFarmaci2" name="ottimizzazioneFarmaci" value="2">
                <label for="ottimizzazioneFarmaci2">2</label>
                <input type="radio" id="ottimizzazioneFarmaci3" name="ottimizzazioneFarmaci" value="3">
                <label for="ottimizzazioneFarmaci3">3</label>
                <input type="radio" id="ottimizzazioneFarmaci4" name="ottimizzazioneFarmaci" value="4">
                <label for="ottimizzazioneFarmaci4">4</label>
                <input type="radio" id="ottimizzazioneFarmaci5" name="ottimizzazioneFarmaci" value="5">
                <label for="ottimizzazioneFarmaci5">5</label>
                <input type="radio" id="ottimizzazioneFarmaci6" name="ottimizzazioneFarmaci" value="6">
                <label for="ottimizzazioneFarmaci6">6</label>
                <input type="radio" id="ottimizzazioneFarmaci7" name="ottimizzazioneFarmaci" value="7">
                <label for="ottimizzazioneFarmaci7">7</label>
                <input type="radio" id="ottimizzazioneFarmaci8" name="ottimizzazioneFarmaci" value="8">
                <label for="ottimizzazioneFarmaci8">8</label>
                <input type="radio" id="ottimizzazioneFarmaci9" name="ottimizzazioneFarmaci" value="9">
                <label for="ottimizzazioneFarmaci9">9</label>
                <input type="radio" id="ottimizzazioneFarmaci10" name="ottimizzazioneFarmaci" value="10">
                <label for="ottimizzazioneFarmaci10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto sei preparato sugli argomenti di cultura generale?</p>
            <div class="radio">
                <input type="radio" id="culturaGenerale1" name="culturaGenerale" value="1">
                <label for="culturaGenerale1">1</label>
                <input type="radio" id="culturaGenerale2" name="culturaGenerale" value="2">
                <label for="culturaGenerale2">2</label>
                <input type="radio" id="culturaGenerale3" name="culturaGenerale" value="3">
                <label for="culturaGenerale3">3</label>
                <input type="radio" id="culturaGenerale4" name="culturaGenerale" value="4">
                <label for="culturaGenerale4">4</label>
                <input type="radio" id="culturaGenerale5" name="culturaGenerale" value="5">
                <label for="culturaGenerale5">5</label>
                <input type="radio" id="culturaGenerale6" name="culturaGenerale" value="6">
                <label for="culturaGenerale6">6</label>
                <input type="radio" id="culturaGenerale7" name="culturaGenerale" value="7">
                <label for="culturaGenerale7">7</label>
                <input type="radio" id="culturaGenerale8" name="culturaGenerale" value="8">
                <label for="culturaGenerale8">8</label>
                <input type="radio" id="culturaGenerale9" name="culturaGenerale" value="9">
                <label for="culturaGenerale9">9</label>
                <input type="radio" id="culturaGenerale10" name="culturaGenerale" value="10">
                <label for="culturaGenerale10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Trovi interessante conoscere il funzionamento interno dei computer?</p>
            <div class="radio">
                <input type="radio" id="internoComputer1" name="internoComputer" value="1">
                <label for="internoComputer1">1</label>
                <input type="radio" id="internoComputer2" name="internoComputer" value="2">
                <label for="internoComputer2">2</label>
                <input type="radio" id="internoComputer3" name="internoComputer" value="3">
                <label for="internoComputer3">3</label>
                <input type="radio" id="internoComputer4" name="internoComputer" value="4">
                <label for="internoComputer4">4</label>
                <input type="radio" id="internoComputer5" name="internoComputer" value="5">
                <label for="internoComputer5">5</label>
                <input type="radio" id="internoComputer6" name="internoComputer" value="6">
                <label for="internoComputer6">6</label>
                <input type="radio" id="internoComputer7" name="internoComputer" value="7">
                <label for="internoComputer7">7</label>
                <input type="radio" id="internoComputer8" name="internoComputer" value="8">
                <label for="internoComputer8">8</label>
                <input type="radio" id="internoComputer9" name="internoComputer" value="9">
                <label for="internoComputer9">9</label>
                <input type="radio" id="internoComputer10" name="internoComputer" value="10">
                <label for="internoComputer10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Hai attitudine nell'osservare ciò che ti circonda?</p>
            <div class="radio">
                <input type="radio" id="attitudineOsservare1" name="attitudineOsservare" value="1">
                <label for="attitudineOsservare1">1</label>
                <input type="radio" id="attitudineOsservare2" name="attitudineOsservare" value="2">
                <label for="attitudineOsservare2">2</label>
                <input type="radio" id="attitudineOsservare3" name="attitudineOsservare" value="3">
                <label for="attitudineOsservare3">3</label>
                <input type="radio" id="attitudineOsservare4" name="attitudineOsservare" value="4">
                <label for="attitudineOsservare4">4</label>
                <input type="radio" id="attitudineOsservare5" name="attitudineOsservare" value="5">
                <label for="attitudineOsservare5">5</label>
                <input type="radio" id="attitudineOsservare6" name="attitudineOsservare" value="6">
                <label for="attitudineOsservare6">6</label>
                <input type="radio" id="attitudineOsservare7" name="attitudineOsservare" value="7">
                <label for="attitudineOsservare7">7</label>
                <input type="radio" id="attitudineOsservare8" name="attitudineOsservare" value="8">
                <label for="attitudineOsservare8">8</label>
                <input type="radio" id="attitudineOsservare9" name="attitudineOsservare" value="9">
                <label for="attitudineOsservare9">9</label>
                <input type="radio" id="attitudineOsservare10" name="attitudineOsservare" value="10">
                <label for="attitudineOsservare10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti interessa l’andamento economico globale/nazionale?</p>
            <div class="radio">
                <input type="radio" id="andamentoGlobale1" name="andamentoGlobale" value="1">
                <label for="andamentoGlobale1">1</label>
                <input type="radio" id="andamentoGlobale2" name="andamentoGlobale" value="2">
                <label for="andamentoGlobale2">2</label>
                <input type="radio" id="andamentoGlobale3" name="andamentoGlobale" value="3">
                <label for="andamentoGlobale3">3</label>
                <input type="radio" id="andamentoGlobale4" name="andamentoGlobale" value="4">
                <label for="andamentoGlobale4">4</label>
                <input type="radio" id="andamentoGlobale5" name="andamentoGlobale" value="5">
                <label for="andamentoGlobale5">5</label>
                <input type="radio" id="andamentoGlobale6" name="andamentoGlobale" value="6">
                <label for="andamentoGlobale6">6</label>
                <input type="radio" id="andamentoGlobale7" name="andamentoGlobale" value="7">
                <label for="andamentoGlobale7">7</label>
                <input type="radio" id="andamentoGlobale8" name="andamentoGlobale" value="8">
                <label for="andamentoGlobale8">8</label>
                <input type="radio" id="andamentoGlobale9" name="andamentoGlobale" value="9">
                <label for="andamentoGlobale9">9</label>
                <input type="radio" id="andamentoGlobale10" name="andamentoGlobale" value="10">
                <label for="andamentoGlobale10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Credi che saresti un buon manager a capo di un’azienda?</p>
            <div class="radio">
                <input type="radio" id="managerAzienda1" name="managerAzienda" value="1">
                <label for="managerAzienda1">1</label>
                <input type="radio" id="managerAzienda2" name="managerAzienda" value="2">
                <label for="managerAzienda2">2</label>
                <input type="radio" id="managerAzienda3" name="managerAzienda" value="3">
                <label for="managerAzienda3">3</label>
                <input type="radio" id="managerAzienda4" name="managerAzienda" value="4">
                <label for="managerAzienda4">4</label>
                <input type="radio" id="managerAzienda5" name="managerAzienda" value="5">
                <label for="managerAzienda5">5</label>
                <input type="radio" id="managerAzienda6" name="managerAzienda" value="6">
                <label for="managerAzienda6">6</label>
                <input type="radio" id="managerAzienda7" name="managerAzienda" value="7">
                <label for="managerAzienda7">7</label>
                <input type="radio" id="managerAzienda8" name="managerAzienda" value="8">
                <label for="managerAzienda8">8</label>
                <input type="radio" id="managerAzienda9" name="managerAzienda" value="9">
                <label for="managerAzienda9">9</label>
                <input type="radio" id="managerAzienda10" name="managerAzienda" value="10">
                <label for="managerAzienda10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Ti interesserebbe valorizzare il patrimonio culturale italiano?</p>
            <div class="radio">
                <input type="radio" id="patrimonioCulturale1" name="patrimonioCulturale" value="1">
                <label for="patrimonioCulturale1">1</label>
                <input type="radio" id="patrimonioCulturale2" name="patrimonioCulturale" value="2">
                <label for="patrimonioCulturale2">2</label>
                <input type="radio" id="patrimonioCulturale3" name="patrimonioCulturale" value="3">
                <label for="patrimonioCulturale3">3</label>
                <input type="radio" id="patrimonioCulturale4" name="patrimonioCulturale" value="4">
                <label for="patrimonioCulturale4">4</label>
                <input type="radio" id="patrimonioCulturale5" name="patrimonioCulturale" value="5">
                <label for="patrimonioCulturale5">5</label>
                <input type="radio" id="patrimonioCulturale6" name="patrimonioCulturale" value="6">
                <label for="patrimonioCulturale6">6</label>
                <input type="radio" id="patrimonioCulturale7" name="patrimonioCulturale" value="7">
                <label for="patrimonioCulturale7">7</label>
                <input type="radio" id="patrimonioCulturale8" name="patrimonioCulturale" value="8">
                <label for="patrimonioCulturale8">8</label>
                <input type="radio" id="patrimonioCulturale9" name="patrimonioCulturale" value="9">
                <label for="patrimonioCulturale9">9</label>
                <input type="radio" id="patrimonioCulturale10" name="patrimonioCulturale" value="10">
                <label for="patrimonioCulturale10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto reputi importante l’ottimizzazione delle catene di montaggio all’interno delle industrie?</p>
            <div class="radio">
                <input type="radio" id="cateneIndustria1" name="cateneIndustria" value="1">
                <label for="cateneIndustria1">1</label>
                <input type="radio" id="cateneIndustria2" name="cateneIndustria" value="2">
                <label for="cateneIndustria2">2</label>
                <input type="radio" id="cateneIndustria3" name="cateneIndustria" value="3">
                <label for="cateneIndustria3">3</label>
                <input type="radio" id="cateneIndustria4" name="cateneIndustria" value="4">
                <label for="cateneIndustria4">4</label>
                <input type="radio" id="cateneIndustria5" name="cateneIndustria" value="5">
                <label for="cateneIndustria5">5</label>
                <input type="radio" id="cateneIndustria6" name="cateneIndustria" value="6">
                <label for="cateneIndustria6">6</label>
                <input type="radio" id="cateneIndustria7" name="cateneIndustria" value="7">
                <label for="cateneIndustria7">7</label>
                <input type="radio" id="cateneIndustria8" name="cateneIndustria" value="8">
                <label for="cateneIndustria8">8</label>
                <input type="radio" id="cateneIndustria9" name="cateneIndustria" value="9">
                <label for="cateneIndustria9">9</label>
                <input type="radio" id="cateneIndustria10" name="cateneIndustria" value="10">
                <label for="cateneIndustria10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti incuriosiscono le tecniche e tecnologie di progettazione e costruzione in ambito edile?</p>
            <div class="radio">
                <input type="radio" id="ambitoEdile1" name="ambitoEdile" value="1">
                <label for="ambitoEdile1">1</label>
                <input type="radio" id="ambitoEdile2" name="ambitoEdile" value="2">
                <label for="ambitoEdile2">2</label>
                <input type="radio" id="ambitoEdile3" name="ambitoEdile" value="3">
                <label for="ambitoEdile3">3</label>
                <input type="radio" id="ambitoEdile4" name="ambitoEdile" value="4">
                <label for="ambitoEdile4">4</label>
                <input type="radio" id="ambitoEdile5" name="ambitoEdile" value="5">
                <label for="ambitoEdile5">5</label>
                <input type="radio" id="ambitoEdile6" name="ambitoEdile" value="6">
                <label for="ambitoEdile6">6</label>
                <input type="radio" id="ambitoEdile7" name="ambitoEdile" value="7">
                <label for="ambitoEdile7">7</label>
                <input type="radio" id="ambitoEdile8" name="ambitoEdile" value="8">
                <label for="ambitoEdile8">8</label>
                <input type="radio" id="ambitoEdile9" name="ambitoEdile" value="9">
                <label for="ambitoEdile9">9</label>
                <input type="radio" id="ambitoEdile10" name="ambitoEdile" value="10">
                <label for="ambitoEdile10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Reputi interessante dedicarsi e lavorare al servizio della comunità?</p>
            <div class="radio">
                <input type="radio" id="servizioComunita1" name="servizioComunita" value="1">
                <label for="servizioComunita1">1</label>
                <input type="radio" id="servizioComunita2" name="servizioComunita" value="2">
                <label for="servizioComunita2">2</label>
                <input type="radio" id="servizioComunita3" name="servizioComunita" value="3">
                <label for="servizioComunita3">3</label>
                <input type="radio" id="servizioComunita4" name="servizioComunita" value="4">
                <label for="servizioComunita4">4</label>
                <input type="radio" id="servizioComunita5" name="servizioComunita" value="5">
                <label for="servizioComunita5">5</label>
                <input type="radio" id="servizioComunita6" name="servizioComunita" value="6">
                <label for="servizioComunita6">6</label>
                <input type="radio" id="servizioComunita7" name="servizioComunita" value="7">
                <label for="servizioComunita7">7</label>
                <input type="radio" id="servizioComunita8" name="servizioComunita" value="8">
                <label for="servizioComunita8">8</label>
                <input type="radio" id="servizioComunita9" name="servizioComunita" value="9">
                <label for="servizioComunita9">9</label>
                <input type="radio" id="servizioComunita10" name="servizioComunita" value="10">
                <label for="servizioComunita10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti piacerebbe offrire assistenza sanitaria a chi lo necessita?</p>
            <div class="radio">
                <input type="radio" id="assistenzaSanitaria1" name="assistenzaSanitaria" value="1">
                <label for="assistenzaSanitaria1">1</label>
                <input type="radio" id="assistenzaSanitaria2" name="assistenzaSanitaria" value="2">
                <label for="assistenzaSanitaria2">2</label>
                <input type="radio" id="assistenzaSanitaria3" name="assistenzaSanitaria" value="3">
                <label for="assistenzaSanitaria3">3</label>
                <input type="radio" id="assistenzaSanitaria4" name="assistenzaSanitaria" value="4">
                <label for="assistenzaSanitaria4">4</label>
                <input type="radio" id="assistenzaSanitaria5" name="assistenzaSanitaria" value="5">
                <label for="assistenzaSanitaria5">5</label>
                <input type="radio" id="assistenzaSanitaria6" name="assistenzaSanitaria" value="6">
                <label for="assistenzaSanitaria6">6</label>
                <input type="radio" id="assistenzaSanitaria7" name="assistenzaSanitaria" value="7">
                <label for="assistenzaSanitaria7">7</label>
                <input type="radio" id="assistenzaSanitaria8" name="assistenzaSanitaria" value="8">
                <label for="assistenzaSanitaria8">8</label>
                <input type="radio" id="assistenzaSanitaria9" name="assistenzaSanitaria" value="9">
                <label for="assistenzaSanitaria9">9</label>
                <input type="radio" id="assistenzaSanitaria10" name="assistenzaSanitaria" value="10">
                <label for="assistenzaSanitaria10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti piacerebbe comprendere la struttura di materiali e sostanze esistenti in natura?</p>
            <div class="radio">
                <input type="radio" id="materialiNatura1" name="materialiNatura" value="1">
                <label for="materialiNatura1">1</label>
                <input type="radio" id="materialiNatura2" name="materialiNatura" value="2">
                <label for="materialiNatura2">2</label>
                <input type="radio" id="materialiNatura3" name="materialiNatura" value="3">
                <label for="materialiNatura3">3</label>
                <input type="radio" id="materialiNatura4" name="materialiNatura" value="4">
                <label for="materialiNatura4">4</label>
                <input type="radio" id="materialiNatura5" name="materialiNatura" value="5">
                <label for="materialiNatura5">5</label>
                <input type="radio" id="materialiNatura6" name="materialiNatura" value="6">
                <label for="materialiNatura6">6</label>
                <input type="radio" id="materialiNatura7" name="materialiNatura" value="7">
                <label for="materialiNatura7">7</label>
                <input type="radio" id="materialiNatura8" name="materialiNatura" value="8">
                <label for="materialiNatura8">8</label>
                <input type="radio" id="materialiNatura9" name="materialiNatura" value="9">
                <label for="materialiNatura9">9</label>
                <input type="radio" id="materialiNatura10" name="materialiNatura" value="10">
                <label for="materialiNatura10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti interessa lo studio della lingua italiana e straniera?</p>
            <div class="radio">
                <input type="radio" id="studioLingue1" name="studioLingue" value="1">
                <label for="studioLingue1">1</label>
                <input type="radio" id="studioLingue2" name="studioLingue" value="2">
                <label for="studioLingue2">2</label>
                <input type="radio" id="studioLingue3" name="studioLingue" value="3">
                <label for="studioLingue3">3</label>
                <input type="radio" id="studioLingue4" name="studioLingue" value="4">
                <label for="studioLingue4">4</label>
                <input type="radio" id="studioLingue5" name="studioLingue" value="5">
                <label for="studioLingue5">5</label>
                <input type="radio" id="studioLingue6" name="studioLingue" value="6">
                <label for="studioLingue6">6</label>
                <input type="radio" id="studioLingue7" name="studioLingue" value="7">
                <label for="studioLingue7">7</label>
                <input type="radio" id="studioLingue8" name="studioLingue" value="8">
                <label for="studioLingue8">8</label>
                <input type="radio" id="studioLingue9" name="studioLingue" value="9">
                <label for="studioLingue9">9</label>
                <input type="radio" id="studioLingue10" name="studioLingue" value="10">
                <label for="studioLingue10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti piacerebbe aiutare gli altri ad imparare nuove cose?</p>
            <div class="radio">
                <input type="radio" id="nuoveCose1" name="nuoveCose" value="1">
                <label for="nuoveCose1">1</label>
                <input type="radio" id="nuoveCose2" name="nuoveCose" value="2">
                <label for="nuoveCose2">2</label>
                <input type="radio" id="nuoveCose3" name="nuoveCose" value="3">
                <label for="nuoveCose3">3</label>
                <input type="radio" id="nuoveCose4" name="nuoveCose" value="4">
                <label for="nuoveCose4">4</label>
                <input type="radio" id="nuoveCose5" name="nuoveCose" value="5">
                <label for="nuoveCose5">5</label>
                <input type="radio" id="nuoveCose6" name="nuoveCose" value="6">
                <label for="nuoveCose6">6</label>
                <input type="radio" id="nuoveCose7" name="nuoveCose" value="7">
                <label for="nuoveCose7">7</label>
                <input type="radio" id="nuoveCose8" name="nuoveCose" value="8">
                <label for="nuoveCose8">8</label>
                <input type="radio" id="nuoveCose9" name="nuoveCose" value="9">
                <label for="nuoveCose9">9</label>
                <input type="radio" id="nuoveCose10" name="nuoveCose" value="10">
                <label for="nuoveCose10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto rimani informato sugli argomenti riguardanti le scienze?</p>
            <div class="radio">
                <input type="radio" id="argomentiScienze1" name="argomentiScienze" value="1">
                <label for="argomentiScienze1">1</label>
                <input type="radio" id="argomentiScienze2" name="argomentiScienze" value="2">
                <label for="argomentiScienze2">2</label>
                <input type="radio" id="argomentiScienze3" name="argomentiScienze" value="3">
                <label for="argomentiScienze3">3</label>
                <input type="radio" id="argomentiScienze4" name="argomentiScienze" value="4">
                <label for="argomentiScienze4">4</label>
                <input type="radio" id="argomentiScienze5" name="argomentiScienze" value="5">
                <label for="argomentiScienze5">5</label>
                <input type="radio" id="argomentiScienze6" name="argomentiScienze" value="6">
                <label for="argomentiScienze6">6</label>
                <input type="radio" id="argomentiScienze7" name="argomentiScienze" value="7">
                <label for="argomentiScienze7">7</label>
                <input type="radio" id="argomentiScienze8" name="argomentiScienze" value="8">
                <label for="argomentiScienze8">8</label>
                <input type="radio" id="argomentiScienze9" name="argomentiScienze" value="9">
                <label for="argomentiScienze9">9</label>
                <input type="radio" id="argomentiScienze10" name="argomentiScienze" value="10">
                <label for="argomentiScienze10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti interessi alla vita politica e comunitaria del tuo paese?</p>
            <div class="radio">
                <input type="radio" id="politicaComunitaria1" name="politicaComunitaria" value="1">
                <label for="politicaComunitaria1">1</label>
                <input type="radio" id="politicaComunitaria2" name="politicaComunitaria" value="2">
                <label for="politicaComunitaria2">2</label>
                <input type="radio" id="politicaComunitaria3" name="politicaComunitaria" value="3">
                <label for="politicaComunitaria3">3</label>
                <input type="radio" id="politicaComunitaria4" name="politicaComunitaria" value="4">
                <label for="politicaComunitaria4">4</label>
                <input type="radio" id="politicaComunitaria5" name="politicaComunitaria" value="5">
                <label for="politicaComunitaria5">5</label>
                <input type="radio" id="politicaComunitaria6" name="politicaComunitaria" value="6">
                <label for="politicaComunitaria6">6</label>
                <input type="radio" id="politicaComunitaria7" name="politicaComunitaria" value="7">
                <label for="politicaComunitaria7">7</label>
                <input type="radio" id="politicaComunitaria8" name="politicaComunitaria" value="8">
                <label for="politicaComunitaria8">8</label>
                <input type="radio" id="politicaComunitaria9" name="politicaComunitaria" value="9">
                <label for="politicaComunitaria9">9</label>
                <input type="radio" id="politicaComunitaria10" name="politicaComunitaria" value="10">
                <label for="politicaComunitaria10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto ti piacerebbe aiutare gli altri a far valere i propri diritti?</p>
            <div class="radio">
                <input type="radio" id="propriDiritti1" name="propriDiritti" value="1">
                <label for="propriDiritti1">1</label>
                <input type="radio" id="propriDiritti2" name="propriDiritti" value="2">
                <label for="propriDiritti2">2</label>
                <input type="radio" id="propriDiritti3" name="propriDiritti" value="3">
                <label for="propriDiritti3">3</label>
                <input type="radio" id="propriDiritti4" name="propriDiritti" value="4">
                <label for="propriDiritti4">4</label>
                <input type="radio" id="propriDiritti5" name="propriDiritti" value="5">
                <label for="propriDiritti5">5</label>
                <input type="radio" id="propriDiritti6" name="propriDiritti" value="6">
                <label for="propriDiritti6">6</label>
                <input type="radio" id="propriDiritti7" name="propriDiritti" value="7">
                <label for="propriDiritti7">7</label>
                <input type="radio" id="propriDiritti8" name="propriDiritti" value="8">
                <label for="propriDiritti8">8</label>
                <input type="radio" id="propriDiritti9" name="propriDiritti" value="9">
                <label for="propriDiritti9">9</label>
                <input type="radio" id="propriDiritti10" name="propriDiritti" value="10">
                <label for="propriDiritti10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Ti piacerebbe affrontare i problemi di tipo logici/matematici?</p>
            <div class="radio" >
                <input type="radio" id="logicoMatematici1" name="logicoMatematici" value="1">
                <label for="logicoMatematici1">1</label>
                <input type="radio" id="logicoMatematici2" name="logicoMatematici" value="2">
                <label for="logicoMatematici2">2</label>
                <input type="radio" id="logicoMatematici3" name="logicoMatematici" value="3">
                <label for="logicoMatematici3">3</label>
                <input type="radio" id="logicoMatematici4" name="logicoMatematici" value="4">
                <label for="logicoMatematici4">4</label>
                <input type="radio" id="logicoMatematici5" name="logicoMatematici" value="5">
                <label for="logicoMatematici5">5</label>
                <input type="radio" id="logicoMatematici6" name="logicoMatematici" value="6">
                <label for="logicoMatematici6">6</label>
                <input type="radio" id="logicoMatematici7" name="logicoMatematici" value="7">
                <label for="logicoMatematici7">7</label>
                <input type="radio" id="logicoMatematici8" name="logicoMatematici" value="8">
                <label for="logicoMatematici8">8</label>
                <input type="radio" id="logicoMatematici9" name="logicoMatematici" value="9">
                <label for="logicoMatematici9">9</label>
                <input type="radio" id="logicoMatematici10" name="logicoMatematici" value="10">
                <label for="logicoMatematici10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Continua</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
        <div class="domanda">
            <p>Quanto reputi pratico il tuo corso di studi?</p>
            <div class="radio">
                <input type="radio" id="praticoStudi1" name="praticoStudi" value="1">
                <label for="praticoStudi1">1</label>
                <input type="radio" id="praticoStudi2" name="praticoStudi" value="2">
                <label for="praticoStudi2">2</label>
                <input type="radio" id="praticoStudi3" name="praticoStudi" value="3">
                <label for="praticoStudi3">3</label>
                <input type="radio" id="praticoStudi4" name="praticoStudi" value="4">
                <label for="praticoStudi4">4</label>
                <input type="radio" id="praticoStudi5" name="praticoStudi" value="5">
                <label for="praticoStudi5">5</label>
                <input type="radio" id="praticoStudi6" name="praticoStudi" value="6">
                <label for="praticoStudi6">6</label>
                <input type="radio" id="praticoStudi7" name="praticoStudi" value="7">
                <label for="praticoStudi7">7</label>
                <input type="radio" id="praticoStudi8" name="praticoStudi" value="8">
                <label for="praticoStudi8">8</label>
                <input type="radio" id="praticoStudi9" name="praticoStudi" value="9">
                <label for="praticoStudi9">9</label>
                <input type="radio" id="praticoStudi10" name="praticoStudi" value="10">
                <label for="praticoStudi10">10</label>
            </div>
            <div class="comandi">
                <div class="back" onclick="precedenteDomanda(this)">
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
                <div class="continua" onclick="prossimaDomanda(this)">
                    <p>Invia</p>
                    <svg viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M13 20H27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                        <path d="M20 13L27 20L20 27" stroke="white" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
