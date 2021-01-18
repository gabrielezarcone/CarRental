<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
HOMEPAGE ADMIN
<div id="customers">
    <c:forEach var="customer" items="${customersList}">
        <div class="customer_card ${customer.deleted ? 'deleted_customer' : ''}">
            <div>
                <div>${customer.name} ${customer.surname}</div>
                <b>${customer.username}</b>
            </div>
            <div class="customer_btn_div">
                <c:choose>
                    <c:when test="${not customer.deleted}">
                        <div class="interactive customer_btn edit_customer_btn" onclick="location.href='./updateUserInfo?username=${customer.username}'">
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
    </c:forEach>
</div>

