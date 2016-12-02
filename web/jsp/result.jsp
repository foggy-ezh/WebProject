<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 02.12.16
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="properties.resultText"/>
<html>
<head>
    <title><fmt:message key="result.title"/></title>
</head>
<body>
<h1><fmt:message key="result.parser.used"/>${parserType}</h1>
<hr>
<table border="1">
    <caption><fmt:message key="result.indoor.flowers"/></caption>
    <tr>
        <th><fmt:message key="result.column.name"/></th>
        <th><fmt:message key="result.column.origin"/></th>
        <th><fmt:message key="result.column.soil"/></th>
        <th><fmt:message key="result.column.stem.color"/></th>
        <th><fmt:message key="result.column.leaf.color"/></th>
        <th><fmt:message key="result.column.size"/></th>
        <th><fmt:message key="result.column.multiplying"/></th>
        <th><fmt:message key="result.column.temperature"/></th>
        <th><fmt:message key="result.column.lightning"/></th>
        <th><fmt:message key="result.column.water.need"/></th>
    </tr>
    <c:forEach var="indoorFlower" items="${indoorFlowers}" varStatus="status">
        <tr>
            <td><c:out value="${indoorFlower.getName()}"/></td>
            <td><c:out value="${indoorFlower.origin}"/></td>
            <td><c:out value="${indoorFlower.soil}"/></td>
            <td><c:out value="${indoorFlower.parameters.stemColor}"/></td>
            <td><c:out value="${indoorFlower.parameters.leafColor}"/></td>
            <td><c:out value="${indoorFlower.parameters.avgSize}"/></td>
            <td><c:out value="${indoorFlower.multiplying}"/></td>
            <td><c:out value="${indoorFlower.growingTips.temperature}"/></td>
            <td><c:out value="${indoorFlower.growingTips.lightingType}"/></td>
            <td><c:out value="${indoorFlower.growingTips.waterNeed}"/></td>
        </tr>
    </c:forEach>
</table>
<hr>
<table border="1">
    <caption><fmt:message key="result.outdoor.flowers"/></caption>
    <tr>
        <th><fmt:message key="result.column.name"/></th>
        <th><fmt:message key="result.column.origin"/></th>
        <th><fmt:message key="result.column.soil"/></th>
        <th><fmt:message key="result.column.stem.color"/></th>
        <th><fmt:message key="result.column.leaf.color"/></th>
        <th><fmt:message key="result.column.size"/></th>
        <th><fmt:message key="result.column.multiplying"/></th>
        <th><fmt:message key="result.column.blooming"/></th>
    </tr>
    <<c:forEach var="outdoorFlower" items="${outdoorFlowers}">
    <tr>
        <td><c:out value="${outdoorFlower.getName()}"/></td>
        <td><c:out value="${outdoorFlower.origin}"/></td>
        <td><c:out value="${outdoorFlower.soil}"/></td>
        <td><c:out value="${outdoorFlower.parameters.stemColor}"/></td>
        <td><c:out value="${outdoorFlower.parameters.leafColor}"/></td>
        <td><c:out value="${outdoorFlower.parameters.avgSize}"/></td>
        <td><c:out value="${outdoorFlower.multiplying}"/></td>
        <td><c:out value="${outdoorFlower.bloomingPeriod}"/></td>
    </tr>
    </c:forEach>
</table>
<form name="Back" action="FirstWebAction" method="post">
    <p></p><button type="submit"><fmt:message key="result.label.submit.back"/></button>
    <input type="hidden" name="command" value="back"/>
</form>
</body>
</html>
