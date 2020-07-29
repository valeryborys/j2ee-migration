<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="o" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<body>
<h1><fmt:message key="companies"/></h1>
<table>
    <c:forEach items="${companies}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.phone}</td>
            <td>${item.website}</td>
        </tr>
    </c:forEach>
</table>
<form action="${linkTo[CompanyController].add}" method="post">
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors}">
            ${error.message}
        </c:forEach>
    </c:if>
    <br/>
    <span>Name: </span><input type="text" name="company.name"/><br/><br/>
    <span>Phone: </span><input type="text" name="company.phone"/><br/><br/>
    <span>Website: </span><input type="text" name="company.website"/><br/><br/>
    <button>Add company</button>
</form>
</body>
</html>