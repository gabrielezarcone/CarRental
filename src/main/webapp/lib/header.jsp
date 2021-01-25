<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="js/functions.js"></script>
<link rel="stylesheet" href="style/style.css">

<h1 id="appName">Car Rental Service</h1>
<div id="header">
    <a href="home" id="homepage_btn" class="header_btn interactive">HomePage</a>
    <a href="parco" id="parcoauto_btn" class="header_btn interactive">Parco Auto</a>
    <a href="profilo" id="profilo_btn" class="header_btn interactive">Profilo utente</a>
    <div id="loginForm">
        <c:choose>
            <c:when test="${not empty sessionScope.loggedUser.username}">
                <a class="logout_btn header_btn interactive" href="Logout">Logout ${sessionScope.loggedUser.username}👋</a>
            </c:when>
            <c:otherwise>
                <form action="Login" method="post">
                    <input type="text" name="username" placeholder="Username">
                    <input type="password" name="password" placeholder="Password">
                    <input type="submit" value="Invia">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>