<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
HOMEPAGE ADMIN
<c:forEach var="customer" items="${customersList}">
    <div class="customer_card ${customer.deleted ? 'deleted_customer' : ''}">
        <div>${customer.name} ${customer.surname}</div>
        <div>${customer.username}</div>
    </div>
</c:forEach>

