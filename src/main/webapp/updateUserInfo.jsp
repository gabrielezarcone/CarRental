
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modifica utente</title>
</head>
<body>

    <form class="updateInfoForm" action="updateUserInfo" method="post">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" value="${userInfo.username}">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="--invariata--">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name" value="${userInfo.name}">
        <label for="surname">Cognome</label>
        <input type="text" name="surname" id="surname" value="${userInfo.surname}">
        <c:if test="${sessionScope.loggedUser.is_admin}">
            <label for="admin">Amministratore</label>
            <input type="checkbox" name="admin" id="admin" value="true" ${userInfo.is_admin ? "checked": ""}>
        </c:if>
        <label for="birth_date">Data di nascita</label>
        <input type="date" name="birth_date" id="birth_date" value="${userInfo.birth_date}">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
