<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <body>
    <div class="container">
        <form:form method="post" action="/jm/cm/registration" modelAttribute="user">
            <form:hidden path="id" />
            <h2>Register</h2>

            <p>
                <label for="email">E-mail</label>
                <input type="text" id="email" name="email" placeholder="E-mail" required>
            </p>
            <p>
                <label for="firstName">First Name</label>
                <input type="text" id="firstName" name="firstName" placeholder="First Name" required>
            </p>
            <p>
                <label for="lastName">Last Name</label>
                <input type="text" id="lastName" name="lastName" placeholder="Last Name" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </p>
            <c:out value="${emailError}" />
            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form:form>
    </div>
    </body>
</html>