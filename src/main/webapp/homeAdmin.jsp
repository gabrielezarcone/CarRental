<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.gabrielez.CarRental.entity.Prenotazione.Stato" %>

<div id="customers">
    <form id="filerCusotmerForm" action="">
        <input type="text" placeholder="Cerca...">
        <select name="filtro" id="selezionaFiltro">
            <option value="username">Username</option>
            <option value="name">Nome</option>
            <option value="surname">Cognome</option>
        </select>
        <input type="submit" class="interactive" value="Cerca">
    </form>
    <div id="add_customer_btn" class="interactive customer_card" onclick="servletToGet('./NewCustomer')"><p>+</p></div>
    <c:forEach var="customer" items="${sessionScope.customersList}">
        <div class="customer_card ${customer.deleted ? 'deleted_customer' : 'active_customer interactive'}" onclick="servletToGet('./MostraPrenotazioni?username=${customer.username}')">
            <div>
                <div>${customer.name} ${customer.surname}</div>
                <b>${customer.username}</b>
            </div>
            <div class="customer_btn_div">
                <c:choose>
                    <c:when test="${not customer.deleted}">
                        <div class="interactive customer_btn edit_customer_btn" onclick="servletToGet('./updateUserInfo?username=${customer.username}')">
                            Modifica
                        </div>
                        <div class="interactive customer_btn delete_customer_btn" onclick="deleteUser('${customer.username}')">
                            Elimina
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="customer_btn"></div>
                        <div class="customer_btn"></div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <c:if test="${selectedCustomer==customer.username && not customer.deleted}">
            <div class="listaPrenotrazioni">
                <table>
                    <tr>
                        <th>Auto</th>
                        <th>Inizio</th>
                        <th>Fine</th>
                        <th>Stato Approvazione</th>
                    </tr>
                    <c:forEach var="prenotazione" items="${listaPrenotazioni}">
                        <tr>
                            <td>${prenotazione.auto.costruttore} ${prenotazione.auto.modello}</td>
                            <td><fmt:formatDate type = "date" value = "${prenotazione.inizio}"/></td>
                            <td><fmt:formatDate type = "date" value = "${prenotazione.fine}"/></td>
                            <td class="cellaStatoPrenotazione">
                                <c:choose>
                                    <%--Non riesco ad effettuare la comparazione con Enum dentro a ${}--%>
                                    <c:when test="${prenotazione.stato eq 'APPROVATO'}">
                                        <div>✔️</div>
                                    </c:when>
                                    <c:when test="${prenotazione.stato eq 'RIFIUTATO'}">
                                        <div>❌</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="interactive approvaBtn" onclick="cambiaStato('${prenotazione.id}','approva')">✔️</div>
                                        <div class="interactive rifiutaBtn" onclick="cambiaStato('${prenotazione.id}','rifiuta')">❌</div>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <hr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </c:forEach>
</div>

