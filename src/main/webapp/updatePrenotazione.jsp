
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Modifica utente</title>
</head>
<body>
    <form class="updateInfoForm" action="UpdatePrenotazione" method="post">
        <label for="auto">Auto</label>
        <select name="auto" id="auto">
            <c:forEach var="auto" items="${autoList}">
                <option value="${auto.id}" ${prenotazione.auto.id==auto.id ? 'selected' : ''}>${auto.costruttore} ${auto.modello}</option>
            </c:forEach>
        </select>
        <label for="inizio">Data di inizio</label>
        <input type="date" name="inizio" id="inizio" value="<fmt:formatDate pattern="yyyy-MM-dd" value = "${prenotazione.inizio}"/>">
        <label for="fine">Data di fine</label>
        <input type="date" name="fine" id="fine" value="<fmt:formatDate pattern="yyyy-MM-dd" value = "${prenotazione.fine}"/>">
        <input type="submit" value="Salva">
    </form>
</body>
</html>
