<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <br>
        <h2>Home page</h2>
        <a href="/jm/cm">SpringCompanies</a>
        <a href="${linkTo[CompanyController].companies}">Companies</a></br></br></br></br>
    <form action="/jm/cm/logout" method="POST">
        <button type="submit">Logout</button>
    </form>
    </body>
</html>
