<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>CAR RENTAL SERVICE</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
    <jsp:include page="lib/header.jsp" />

    <c:choose>
            <c:when test="${empty sessionScope.loggedUser}">
                <form id="loginForm" action="Login" method="post">
                    <input type="text" name="username" placeholder="Username">
                    <input type="password" name="password" placeholder="Password">
                    <input type="submit" value="Log In">
                </form>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${not empty pagina}">
                        <jsp:include page="${pagina}" />
                    </c:when>
                    <c:otherwise>
                        <jsp:include page='${sessionScope.loggedUser.is_admin ? "homeAdmin.jsp" : "homeCustomers.jsp"}' />
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
    </c:choose>

</body>
</html>
