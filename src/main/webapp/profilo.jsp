<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div id="userInfoList">
    <div class="userInfo">
        <h1>Username</h1>
        <p>${sessionScope.loggedUser.username}</p>
    </div>
    <div class="userInfo">
        <h1>Nome</h1>
        <p>${sessionScope.loggedUser.name}</p>
    </div>
    <div class="userInfo">
        <h1>Cognome</h1>
        <p>${sessionScope.loggedUser.surname}</p>
    </div>
    <div class="userInfo">
        <h1>Data di nascita</h1>
        <p><fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope.loggedUser.birth_date}"/> </p>
    </div>
    <div onclick="servletToGet('./updateUserInfo?username=${sessionScope.loggedUser.username}')">
        Modifica informazioni utente
    </div>
</div>