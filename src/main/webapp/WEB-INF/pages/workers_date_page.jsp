<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>
<body>


<table border=2 cellpadding=10>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Enter Time</th>
        <th>Duration</th>
    </tr>
    <c:if test="${not empty workersFromDateFromServer}">
        <ul>
            <c:forEach var="listValue" items="${workersFromDateFromServer}">
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