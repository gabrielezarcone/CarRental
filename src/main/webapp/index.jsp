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

    <%--Temporaneo. Da togliere dopo aver implementato il meccanismo di login--%>
    <% session.setAttribute("isAdmin", true); %>

    <c:choose>
        <c:when test="${not empty pagina}">
            <jsp:include page="${pagina}" />
        </c:when>
        <c:otherwise>
            <jsp:include page="/home" />
        </c:otherwise>
    </c:choose>

</body>
</html>
