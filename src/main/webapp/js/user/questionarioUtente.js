var maxLength = 100;
$('#domanda1 > option').text(function(i, text) {
    if (text.length > maxLength) {
        return text.substr(0, maxLength) + '...';
    }
});

function precedenteDomanda(e){
    let previusElement = e.parentElement.parentElement.previousElementSibling;
    e.parentElement.parentElement.classList.remove("show");
    previusElement.classList.add("show");
}

function prossimaDomanda(e){
    let nextElement = e.parentElement.parentElement.nextElementSibling;
    if(!nextElement){
        let data = [];
        data.push($('#domanda2').find(":selected").val());
        data.push($('input[name="materiaPreferita"]:checked').val());
        data.push($('input[name="computerGiorno"]:checked').val());
        data.push($('input[name="evoluzioneInternet"]:checked').val());
        data.push($('input[name="ottimizzazioneFarmaci"]:checked').val());
        data.push($('input[name="culturaGenerale"]:checked').val());
        data.push($('input[name="internoComputer"]:checked').val());
        data.push($('input[name="attitudineOsservare"]:checked').val());
        data.push($('input[name="andamentoGlobale"]:checked').val());
        data.push($('input[name="managerAzienda"]:checked').val());
        data.push($('input[name="patrimonioCulturale"]:checked').val());
        data.push($('input[name="cateneIndustria"]:checked').val());
        data.push($('input[name="ambitoEdile"]:checked').val());
        data.push($('input[name="servizioComunita"]:checked').val());
        data.push($('input[name="assistenzaSanitaria"]:checked').val());
        data.push($('input[name="materialiNatura"]:checked').val());
        data.push($('input[name="studioLingue"]:checked').val());
        data.push($('input[name="nuoveCose"]:checked').val());
        data.push($('input[name="argomentiScienze"]:checked').val());
        data.push($('input[name="politicaComunitaria"]:checked').val());
        data.push($('input[name="propriDiritti"]:checked').val());
        data.push($('input[name="logicoMatematici"]:checked').val());
        data.push($('input[name="domandaPratica"]:checked').val());
        let checkNull = data.filter(el=>{
            return el == null;
        })
        if(checkNull.length>0){
            alert("Compila tutti i campi");
            return;
        }
        e.parentElement.parentElement.classList.remove("show");
        $.ajax({
            url: "https://fia-exam-project.herokuapp.com/FIA/consiglio",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify({risposte: data}),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                let dipartimenti = ["DI (informatica)", "DIEM (ingegneria informatica)", "DIFARMA (gestione e valorizzazione delle risorse agrarie e delle aree protette - tecniche erboristiche - chimica e tecnologia farmaceutiche - farmacia)", "DISES (economia aziendale - economia e commercio - scienze dell'amministrazione e dell'organizzazione - statistica per i big data - economia, valorizzazione, gestione del patrimonio turistico)", "DISA-MIS (economia e management)", "DISPAC (discipline delle arti visive - della musica e dello spettacolo - filosofia - scienze dei beni culturali)", "DIN (ingegneria chimica - ingegneria elettronica - ingegneria gestionale - ingegneria meccanica)", "DCIV (ingegneria civile - ingegneria civile per l'ambiente ed il territorio - ingegneria edile/architettura)", "DISPC (scienze della comunicazione - scienze politiche e delle relazioni internazionali)", "DIPMED (fisioterapia - infermieristica - ostetricia - tecniche di radiologia medica, per immagini e radioterapia - medicina e chirurgia - odontoiatria e protesi dentaria)", "DCB (chimica - scienze ambientali - scienze biologiche)", "DIPSUM (lettere - lingue e culture straniere)", "DISUFF (scienze dell'educazione - scienze delle attività motorie, sportive e dell'educazione psicomotoria - scienze della formazione primaria)", "DF (fisica)", "DISPS (sociologia - studi diplomatici, internazionali e sulla sicurezza globale)", "DSG (giurista d'impresa e delle nuove tecnologie - giurisprudenza)", "DIPMAT (matematica)"];
                $("#questionarioUniversitario").html("<div class=\"domanda show\"> <p>" + dipartimenti[response.dipartimento] + "</p></div>");
            },
            error: function (xhr, status) {
                alert("error");
            }
        });

        return;
    } //fine questionario
    e.parentElement.parentElement.classList.remove("show");
    nextElement.classList.add("show");
}
