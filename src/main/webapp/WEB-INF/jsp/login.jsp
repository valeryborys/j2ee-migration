<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <body>
    <div class="container">
        <form class="form-signin" method="post" action="/jm/cm/login">
            <h2 class="form-signin-heading">Login</h2>
            <p>
                <label for="username">E-mail</label>
                <input type="text" id="username" name="username" placeholder="E-mail" required>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Password" required>
            </p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> or
        </form>
    </div>
    <input type="button" value="Registration" onclick='location.href="/jm/cm/registration"'>
    </body>
</html>