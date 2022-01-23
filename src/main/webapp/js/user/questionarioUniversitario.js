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
    if(!nextElement) return; //fine questionario
    e.parentElement.parentElement.classList.remove("show");
    nextElement.classList.add("show");
}