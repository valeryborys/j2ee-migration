<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <body>
        <c:set var="user" value="${user}"/>
        <form id="loginForm" action="${linkTo[LoginController].signin}" method="post">
            <span>Email: </span><input type="text" name="email"/>
            <br/>
            <span>Password: </span><input type="password" name="password"/>
            <br/>
            <input type="checkbox" name="rememberme" id="rememberme"><label for="rememberme">Remember me</label>
            <input type="submit" value="log in"/>
        </form>
        <c:if test="${!empty errorMessage}">
            <c:out value="${errorMessage}"/>
        </c:if>
    </body>
</html>