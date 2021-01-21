
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Modifica utente</title>
</head>
<body>
    <form class="updateInfoForm" action="UpdatePrenotazione" method="post">
        <label for="auto">Auto</label>
        <input type="text" name="auto" id="auto" value="${prenotazione.auto}">
        <label for="inizio">Data di inizio</label>
        <input type="date" name="inizio" id="inizio" placeholder="${prenotazione.inizio}">
        <label for="fine">Data di fine</label>
        <input type="date" name="fine" id="fine" value="${prenotazione.fine}">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
