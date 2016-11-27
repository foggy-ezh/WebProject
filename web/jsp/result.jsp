<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 27.11.16
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <td><c:out value="${indoorFlower.name}"/></td>
            <td><c:out value="${indoorFlower.origin}"/></td>
            <td><c:out value="${indoorFlower.soilType}"/></td>
            <td><c:out value="${indoorFlower.parameters.stemColor}"/></td>
            <td><c:out value="${indoorFlower.parameters.leafColor}"/></td>
            <td><c:out value="${indoorFlower.parameters.avgSize}"/></td>
            <td><c:out value="${indoorFlower.multiplyingType}"/></td>
            <td><c:out value="${indoorFlower.growingTips.temperature}"/></td>
            <td><c:out value="${indoorFlower.growingTips.lightingType}"/></td>
            <td><c:out value="${indoorFlower.growingTips.waterNeed}"/></td>
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
            <td><c:out value="${outdoorFlower.name}"/></td>
            <td><c:out value="${outdoorFlower.origin}"/></td>
            <td><c:out value="${outdoorFlower.soilType}"/></td>
            <td><c:out value="${outdoorFlower.parameters.stemColor}"/></td>
            <td><c:out value="${outdoorFlower.parameters.leafColor}"/></td>
            <td><c:out value="${outdoorFlower.parameters.avgSize}"/></td>
            <td><c:out value="${outdoorFlower.multiplyingType}"/></td>
            <td><c:out value="${outdoorFlower.bloomingPeriod}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>