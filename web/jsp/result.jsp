<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 27.11.16
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.resultText"/>
<html>
<head>
    <title><fmt:message key="title.result"/></title>
</head>
<body>
<h1><fmt:message key="parser.used"/>${parserType}</h1>
<hr/>
<table border="1">
    <caption><fmt:message key="indoor.flowers"/></caption>
    <tr>
        <th><fmt:message key="column.name"/></th>
        <th><fmt:message key="column.origin"/></th>
        <th><fmt:message key="column.soil"/></th>
        <th><fmt:message key="column.stem.color"/></th>
        <th><fmt:message key="column.leaf.color"/></th>
        <th><fmt:message key="column.size"/></th>
        <th><fmt:message key="column.multiplying"/></th>
        <th><fmt:message key="column.temperature"/></th>
        <th><fmt:message key="column.lightning"/></th>
        <th><fmt:message key="column.water.need"/></th>
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
<hr/>
<table border="1">
    <caption><fmt:message key="outdoor.flowers"/></caption>
    <tr>
        <th><fmt:message key="column.name"/></th>
        <th><fmt:message key="column.origin"/></th>
        <th><fmt:message key="column.soil"/></th>
        <th><fmt:message key="column.stem.color"/></th>
        <th><fmt:message key="column.leaf.color"/></th>
        <th><fmt:message key="column.size"/></th>
        <th><fmt:message key="column.multiplying"/></th>
        <th><fmt:message key="column.blooming"/></th>
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
<hr>
<%@include file="/jsp/language.jsp" %>
</body>
</html>