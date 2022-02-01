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
        data.push($('#domanda1').find(":selected").val());
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
        data.push($('input[name="praticoStudi"]:checked').val());
        let checkNull = data.filter(el=>{
            return el == null;
        })

        if(checkNull.length>0){
            alert("Compila tutti i campi");
            return;
        }
        e.parentElement.parentElement.classList.remove("show");
        $.ajax({
            url: "https://fia-exam-project.herokuapp.com/FIA/contribuisci",
            type: "POST",
            crossDomain: true,
            data: JSON.stringify({risposte: data, idUtente: 1000}),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                $("#questionarioUniversitario").html("<div class=\"domanda show\"> <p>Grazie per aver contribuito!</p></div>");
            },
            error: function (xhr, status) {
                $("#questionarioUniversitario").html("<div class=\"domanda show\"> <p>C'è stato un errore, riprova.</p></div>");
            }
        });
        return;
    } //fine questionario
    e.parentElement.parentElement.classList.remove("show");
    nextElement.classList.add("show");
}