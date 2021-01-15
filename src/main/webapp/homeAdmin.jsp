<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
HOMEPAGE ADMIN
<c:forEach var="customer" items="${customersList}">
    <div class="customer_card ${customer.deleted ? 'deleted_customer' : ''}">
        <div>
            <div>${customer.name} ${customer.surname}</div>
            <div>Username: ${customer.username}</div>
        </div>
        <div class="interactive customer_btn edit_customer_btn">Modifica</div>
        <div class="interactive customer_btn delete_customer_btn">Elimina</div>
    </div>
</c:forEach>

