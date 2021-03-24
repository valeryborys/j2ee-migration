<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
<h1><fmt:message key="companies"/> using Spring</h1>
<table>
    <c:forEach items="${companies}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.phone}</td>
            <td>${item.website}</td>
        </tr>
    </c:forEach>
</table>
<form:form action="/jm/cm" modelAttribute="company" method="POST">
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors}">
            ${error.message}
        </c:forEach>
    </c:if>
    <br/>


                            <form:hidden path="id" />
        <span>Name: </span><form:input path="name" /><br/><br/>
        <span>Phone: </span><form:input path="phone" /><br/><br/>
        <span>Website: </span><form:input path="website" /><br/><br/>
<%--    <input type="submit" value="Submit"/>--%>
    <button>Add company</button>
</form:form>
</body>
</html>