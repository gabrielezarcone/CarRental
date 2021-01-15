
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modifica utente</title>
</head>
<body>

    <form action="" method="post">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="${userInfo.username}">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name" placeholder="${userInfo.name}">
        <label for="surname">Cognome</label>
        <input type="text" name="surname" id="surname" placeholder="${userInfo.surname}">
        <label for="birthDate">Data di nascita</label>
        <input type="date" name="birthDate" id="birthDate" placeholder="${userInfo.birth_date}">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
