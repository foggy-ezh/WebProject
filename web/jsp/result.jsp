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
<fmt:setBundle basename="properties.text"/>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Parser was used:${parserType}</h1>
<hr/>
<table border="1">
    <caption>IndoorFlowers</caption>
    <tr>
        <th>Name</th>
        <th>Origin</th>
        <th>SoilType</th>
        <th>StemColor</th>
        <th>LeafColor</th>
        <th>AvgSize</th>
        <th>MultiplyingType</th>
        <th>Temperature</th>
        <th>LightingType</th>
        <th>WaterNeed</th>
    </tr>
    <c:forEach var="indoorFlower" items="${indoorFlowers}">
        <tr>
            <td><c:out value="${indoorFlowers.name}"/></td>
            <td><c:out value="${indoorFlowers.origin}"/></td>
            <td><c:out value="${indoorFlowers.soilType}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().stemColor}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().leafColor}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().avgSize}"/></td>
            <td><c:out value="${indoorFlowers.multiplyingType}"/></td>
            <td><c:out value="${indoorFlowers.getGrowingTips().temperature}"/></td>
            <td><c:out value="${indoorFlowers.getGrowingTips().lightingType}"/></td>
            <td><c:out value="${indoorFlowers.getGrowingTips().waterNeed}"/></td>
        </tr>
    </c:forEach>
</table>
<hr/>
<table border="1">
    <caption>OutdoorFlowers</caption>
    <tr>
        <th>Name</th>
        <th>Origin</th>
        <th>SoilType</th>
        <th>StemColor</th>
        <th>LeafColor</th>
        <th>AvgSize</th>
        <th>MultiplyingType</th>
        <th>BloomingPeriodType</th>
    </tr>
    <<c:forEach var="outdoorFlower" items="${outdoorFlowers}">
        <tr>
            <td><c:out value="${indoorFlowers.name}"/></td>
            <td><c:out value="${indoorFlowers.origin}"/></td>
            <td><c:out value="${indoorFlowers.soilType}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().stemColor}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().leafColor}"/></td>
            <td><c:out value="${indoorFlowers.getParameters().avgSize}"/></td>
            <td><c:out value="${indoorFlowers.multiplyingType}"/></td>
            <td><c:out value="${indoorFlowers.bloomingPeriod}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="/WebFirstTask"><fmt:message key="label.link.back"/></a>
</body>
</html>