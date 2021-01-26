
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Modifica utente</title>
</head>
<body>

    <form class="updateInfoForm" action="UpdateAutoInfo" method="post">
        <label for="costruttore">Costruttore</label>
        <input type="text" name="costruttore" id="costruttore" value="${autoInfo.costruttore}">
        <label for="modello">Modello</label>
        <input type="text" name="modello" id="modello" value="${autoInfo.modello}">
        <label for="targa">Targa</label>
        <input type="text" name="targa" id="targa" value="${autoInfo.targa}">
        <label for="tipologia">Tipologia di veicolo</label>
        <input type="text" name="tipologia" id="tipologia" value="${autoInfo.tipologia}">
        <label for="immatricolazione">Data immatricolazione</label>
        <input type="date" name="immatricolazione" id="immatricolazione" value="<fmt:formatDate pattern="yyyy-MM-dd" value = "${autoInfo.immatricolazione}"/>">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
