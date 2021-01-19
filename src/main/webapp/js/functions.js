function deleteUser(username){
    event.stopPropagation();
    var xhr = new XMLHttpRequest();
    var method = 'POST';
    var params = 'username='+username;
    var url = './deleteUser';

    xhr.open(method,url);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    xhr.onload = function () {
        alert("L\'utente "+ username +' è stato eliminato');
        location.href= './home';
    }
    xhr.send(params);
}

function servletToGet(url){
    location.href= url;
    event.stopPropagation();
}