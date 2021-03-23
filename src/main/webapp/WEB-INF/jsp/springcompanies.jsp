<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</body>
</html>