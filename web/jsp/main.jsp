<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 26.11.16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="properties.mainText"/>
<html>
<head>
    <title><fmt:message key="main.title"/></title>
</head>
<body>
<h1><fmt:message key="main.header"/></h1>
<hr>
<form name="XMLParser" action="FirstWebAction" method="post">
    <p><fmt:message key="main.select.parser"/></p>
    <select name="parserType">
        <option value="dom"><fmt:message key="main.dom"/></option>
        <option value="sax"><fmt:message key="main.sax"/></option>
        <option value="stax"><fmt:message key="main.stax"/></option>
    </select>
    <button type="submit"><fmt:message key="main.submit"/></button>
    <input type="hidden" name="command" value="parse"/>
    <input type="hidden" name="jspPath" value="${pageContext.request.servletPath}"/>
</form>
<form name="Back" action="FirstWebAction" method="post">
    <button type="submit"><fmt:message key="main.submit.back"/></button>
    <input type="hidden" name="command" value="back"/>
</form>
<hr>
<%@include file="/jsp/language.jsp" %>
<%--<jsp:include page="/jsp/language.jsp" flush="false"/>--%>
</body>
</html>
