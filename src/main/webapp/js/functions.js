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


function cambiaFiltro(){
    var filtro = document.getElementById("selezionaFiltro").value;
    mostraFiltriPrenotazioni(filtro);
}
function mostraFiltriPrenotazioni(filtro){

    var ricerca =document.getElementById("testoRicerca");
    ricerca.innerHTML = '';

    switch (filtro) {
        case "auto":
            var xhr = new XMLHttpRequest();
            var method = 'POST';
            var url = './FiltroPrenotazioniAjax';
            xhr.responseType = "json";
            xhr.open(method, url);
            xhr.onload = function () {
                var array = xhr.response;
                var select = document.createElement("select");
                select.name = "testoRicerca";
                for (var i = 0; i < array.length; i++) {
                    var option = document.createElement("option");
                    option.value = array[i].id;
                    option.text = array[i].costruttore+' '+array[i].modello;
                    select.appendChild(option);
                }
                ricerca.appendChild(select);
                console.log(xhr.response);
            }
            xhr.send();
            break
        case "inizio":
        case "fine":
            var input = document.createElement("input");
            input.type = "date";
            input.name = "testoRicerca";
            ricerca.appendChild(input);
            break
        case "stato":
            var select = document.createElement("select");
            select.name = "testoRicerca";
            var opt1 = document.createElement("option");
            opt1.value = 0;
            opt1.text = "Approvato";
            var opt2 = document.createElement("option");
            opt2.value = 1;
            opt2.text = "Rifiutato";
            var opt3 = document.createElement("option");
            opt3.value = 2;
            opt3.text = "In attesa";
            select.appendChild(opt1);
            select.appendChild(opt2);
            select.appendChild(opt3);
            ricerca.appendChild(select);
            break
    }
}
