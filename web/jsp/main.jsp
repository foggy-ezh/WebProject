<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 26.11.16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.mainText"/>
<html>
<head>
    <title><fmt:message key="title.main"/></title>
</head>
<body>
<h1><fmt:message key="label.header"/></h1>
<hr>
<form name="XMLParser" action="FirstWebAction" method="post">
    <p><fmt:message key="label.select.parser"/></p>
    <select name="parserType">
        <option value="dom"><fmt:message key="label.dom"/></option>
        <option value="sax"><fmt:message key="label.sax"/></option>
        <option value="stax"><fmt:message key="label.stax"/></option>
    </select>
    <button type="submit"><fmt:message key="label.submit"/></button>
    <input type="hidden" name="command" value="parse"/>
    <input type="hidden" name="jspPath" value="${pageContext.request.servletPath}"/>
</form>
<form name="Back" action="FirstWebAction" method="post">
    <button type="submit"><fmt:message key="label.submit.back"/></button>
    <input type="hidden" name="command" value="back"/>
</form>
<hr>
<%@include file="/jsp/language.jsp" %>
</body>
</html>
