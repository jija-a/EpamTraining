<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
        .welcome h1, h2 {
            text-align: center;
        }

        .welcome {
            font-family: arial;
            font-size: 24px;
            margin: 0 auto;
            width: 500px;
            height: 200px;
        }

        table, tr, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="welcome">
    <h1>Result of parsing</h1>
</div>
<table width="100%">
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Volume</td>
        <td>Is-monthly</td>
        <td>Is-color</td>
        <td>Is-glance</td>
        <td>Subscript-index</td>
        <td>Genre</td>
        <td>Date of issue</td>
    </tr>

    <c:if test="${not empty requestScope.papers}">
        <c:forEach var="p" items="${requestScope.papers}">
            <tr>
                <td><c:out value="${p.id}"/></td>
                <td><c:out value="${p.title}"/></td>
                <td><c:out value="${p.chars.volume}"/></td>
                <td><c:out value="${p.chars.monthly}"/></td>
                <td><c:out value="${p.chars.color}"/></td>
                <td><c:out value="${p.chars.glance}"/></td>
                <td></td>
                <c:if test="${not empty p.chars.genre}">
                    <td><c:out value="${p.chars.genre}"/></td>
                </c:if>
                    <td><fmt:parseDate value="${p.chars.dateOfIssue}" pattern="yyyy-MM-dd" var="date" type="date"/>
                        <fmt:formatDate pattern="dd/MMM/yyyy" value="${date}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
