<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.gabrielez.CarRental.entity.Prenotazione.Stato" %>


<form id="filerCusotmerForm" action="CercaCustomer" method="post">
    <div id="testoRicerca"></div>
    <script>mostraFiltriPrenotazioni("auto")</script>
    <select name="filtro" id="selezionaFiltro" onchange="cambiaFiltro()">
        <option value="auto">Auto</option>
        <option value="inizio">Data inizio</option>
        <option value="fine">Data Fine</option>
        <option value="stato">Stato</option>
    </select>
    <input type="submit" class="interactive" value="Cerca">
</form>
<div id="customers"> <div class="customer_card active_customer" onclick="servletToGet('./MostraPrenotazioni?username=${sessionScope.loggedUser.username}')">
    <div>
        <div>${sessionScope.loggedUser.name} ${sessionScope.loggedUser.surname}</div>
        <b>${sessionScope.loggedUser.username}</b>
    </div>
</div>
<div class="listaPrenotrazioni">
    <table>
        <tr>
            <th>Auto</th>
            <th>Inizio</th>
            <th>Fine</th>
            <th>Stato Approvazione</th>
        </tr>
        <tr class="addPrenotazione interactive"><td colspan="4"  onclick="servletToGet('./UpdatePrenotazione')"><b>+</b></td></tr>
        <c:forEach var="prenotazione" items="${listaPrenotazioni}">
            <tr class="interactive" onclick="servletToGet('./UpdatePrenotazione?id=${prenotazione.id}')">
                <td>${prenotazione.auto.costruttore} ${prenotazione.auto.modello}</td>
                <td><fmt:formatDate type = "date" value = "${prenotazione.inizio}"/></td>
                <td><fmt:formatDate type = "date" value = "${prenotazione.fine}"/></td>
                <td class="cellaStatoPrenotazione">
                    <c:choose>
                        <%--Non riesco ad effettuare la comparazione con Enum dentro a ${}--%>
                        <c:when test="${prenotazione.stato eq 'APPROVATO'}">
                            <div title="approvato">✔️</div>
                        </c:when>
                        <c:when test="${prenotazione.stato eq 'RIFIUTATO'}">
                            <div title="rifiutato">❌</div>
                        </c:when>
                        <c:otherwise>
                            <div title="in attesa di approvazione">🕒</div>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <hr>
        </c:forEach>
    </table>
</div>
</div>

