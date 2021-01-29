
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.gabrielez.CarRental.util.DateUtil" %>
<%@ page import="java.util.Date" %>

<%--Data di oggi:--%>
<jsp:useBean id="oggi" class="java.util.Date"/>

<html>
<head>
    <title>Modifica Prenotazione</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty prenotazione.inizio and DateUtil.diffMenoNGiorni(prenotazione.inizio, 2)}">
            <p class="errorMessage"> Questa prenotazione non può essere modificata perchè mancano meno di 2 giorni alla sua data di inizio</p>
        </c:when>
        <c:when test="${not empty prenotazione.inizio and oggi.after(prenotazione.inizio)}">
            <p class="errorMessage"> Questa prenotazione non può essere modificata perchè è passata</p>
        </c:when>
        <c:otherwise>
            <form class="updateInfoForm" action="UpdatePrenotazione" method="post">
                <input name="id" type="text" hidden value="${prenotazione.id}">
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
                <input type="submit" value="Salva" class="interactive">
                <div id="eliminaPrenotazioneBtn" class="interactive" onclick="deletePrenotazione('${prenotazione.id}')">Elimina prenotazione</div>
            </form>
        </c:otherwise>
    </c:choose></body>
</html>
