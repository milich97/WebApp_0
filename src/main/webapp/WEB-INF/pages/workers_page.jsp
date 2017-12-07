<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 27.11.2017
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>
</head>
<body>

<form modelAttribute="workersFromServer" method="post" action="${pageContext.request.contextPath}/date">
    <input type="date" name="date" value="date_value">
    <input type="submit" value="Submit">
</form>

<h2>Table of information about workers:</h2>

<table border=2 cellpadding=10>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Enter Time</th>
        <th>Duration</th>
    </tr>
    <c:if test="${not empty workersFromServer}">
        <ul>
            <c:forEach var="listValue" items="${workersFromServer}">
                <tr>
                    <td>
                            ${listValue.worker_name}
                    </td>
                    <td>
                            ${listValue.date}
                    </td>
                    <td>
                            ${listValue.enterTime}
                    </td>
                    <td>
                            ${listValue.duration}
                    </td>
                </tr>
            </c:forEach>
        </ul>
    </c:if>
</table>



</body>
</html>
