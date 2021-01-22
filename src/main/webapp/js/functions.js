function deleteItem(method, params, url, messaggio){
    event.stopPropagation();
    var xhr = new XMLHttpRequest();

    xhr.open(method,url);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    xhr.onload = function () {
        alert(messaggio);
        location.href= './home';
    }
    xhr.send(params);
}


function deleteUser(username){
    event.stopPropagation();
    var xhr = new XMLHttpRequest();
    var method = 'POST';
    var params = 'username='+username;
    var url = './deleteUser';
    var messaggio = "L\'utente "+ username +' è stato eliminato';
    deleteItem(method, params, url, messaggio)
}
function deletePrenotazione(id){
    event.stopPropagation();
    var xhr = new XMLHttpRequest();
    var method = 'POST';
    var params = 'id='+id;
    var url = './DeletePrenotazione';
    var messaggio = "La prenotazione è stata eliminata";
    deleteItem(method, params, url, messaggio)
}


function servletToGet(url){
    location.href= url;
    event.stopPropagation();
}

function cambiaStato(id, stato){
    // stato è una stringa che può essere solo 'approva' o 'rifiuta'
    event.stopPropagation();
    var xhr = new XMLHttpRequest();
    var method = 'POST';
    var params = 'id='+id+'&stato='+stato;
    var url = './CambiaStatoPrenotazione';
    xhr.open(method, url);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.onload = function () {
        location.href = './home';
    }
    xhr.send(params);
}

function mostraFiltriPrenotazioni(filtro){
    var xhr = new XMLHttpRequest();
    var method = 'POST';
    var url = './FiltroPrenotazioniAjax';
    xhr.open(method, url);
    xhr.onload = function () {
        switch (filtro) {
            case "auto":
                console.log(xhr.response);
            case "inizio":;
            case "fine":;
            case "stato":;
        }
    }
    xhr.send();
}
