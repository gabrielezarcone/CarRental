<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.gabrielez.CarRental.entity.Prenotazione.Stato" %>

<div id="elencoAuto">
    <%--<form id="filerAutoForm" class="filerForm" action="CercaAuto" method="post">
        <input type="text" name="testoRicerca" placeholder="Cerca...">
        <select name="filtro" id="selezionaFiltroAuto" onchange="cambiaFiltroAuto()">
            <option value="costruttore">Costruttore</option>
            <option value="modello">Modello</option>
            <option value="targa">Targa</option>
            <option value="immatricolazione">Immatricolazione</option>
            <option value="tipologia">Tipologia</option>
        </select>
        <input type="submit" class="interactive" value="Cerca">
    </form>--%>
    <c:if test="${sessionScope.loggedUser.is_admin}">
        <div id="add_auto_btn" class="add_element_btn interactive customer_card" onclick="servletToGet('./NewAuto')"><p>+</p></div>
    </c:if>
    <c:forEach var="auto" items="${autoList}">
        <div class="customer_card auto_card" <%--onclick="servletToGet('./MostraPrenotazioni?auto=${auto.id}')"--%>>
            <div>
                <table>
                    <tr>
                        <th>Modello</th>
                        <th>Targa</th>
                        <th>Immatricolazione</th>
                        <th>Tipologia</th>
                    </tr>
                    <tr>
                        <td>${auto.costruttore} ${auto.modello}</td>
                        <td>${auto.targa}</td>
                        <td><fmt:formatDate type = "date" value = "${auto.immatricolazione}"/></td>
                        <td>${auto.tipologia}</td>
                    </tr>
                </table>
            </div>
            <c:if test="${sessionScope.loggedUser.is_admin}">
                <div class="customer_btn_div">
                    <div class="interactive customer_btn edit_customer_btn" onclick="servletToGet('./UpdateAutoInfo?id=${auto.id}')">
                        Modifica
                    </div>
                    <div class="interactive customer_btn delete_customer_btn" onclick="deleteAuto('${auto.id}')">
                        Elimina
                    </div>
                </div>
            </c:if>
        </div>
       <%-- <c:if test="${selectedAuto==auto.id && sessionScope.loggedUser.is_admin}">
            <div class="listaPrenotrazioni">
                <table>
                    <tr>
                        <th>Utente</th>
                        <th>Inizio</th>
                        <th>Fine</th>
                        <th>Stato Approvazione</th>
                    </tr>
                    <c:forEach var="prenotazione" items="${listaPrenotazioni}">
                        <tr>
                            <td>${prenotazione.user}</td>
                            <td><fmt:formatDate type = "date" value = "${prenotazione.inizio}"/></td>
                            <td><fmt:formatDate type = "date" value = "${prenotazione.fine}"/></td>
                            <td class="cellaStatoPrenotazione">
                                <c:choose>
                                    &lt;%&ndash;Non riesco ad effettuare la comparazione con Enum dentro a ${}&ndash;%&gt;
                                    <c:when test="${prenotazione.stato eq 'APPROVATO'}">
                                        <div title="approvato">✔️</div>
                                    </c:when>
                                    <c:when test="${prenotazione.stato eq 'RIFIUTATO'}">
                                        <div title="rifiutato">❌</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="interactive approvaBtn" onclick="cambiaStato('${prenotazione.id}','approva')" title="approva">✔️</div>
                                        <div class="interactive rifiutaBtn" onclick="cambiaStato('${prenotazione.id}','rifiuta')" title="rifiuta">❌</div>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <hr>
                    </c:forEach>
                </table>
            </div>
        </c:if>--%>
    </c:forEach>
</div>

