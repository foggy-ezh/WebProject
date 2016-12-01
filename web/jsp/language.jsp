<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 30.11.16
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.languageText"/>
<html>
<head>
</head>
<body>
<form method="post" action="FirstWebAction">
    <input type="radio" name="language" value="en_US" /><fmt:message key="language.eng"/>
    <input type="radio" name="language" value="ru_RU" /><fmt:message key="language.rus"/>
    <button type="submit"><fmt:message key="language.change.button"/></button>
    <input type="hidden" name="command" value="changeLanguage"/>
    <input type="hidden" name="jspPath" value="${pageContext.request.servletPath}"/>
</form>
</body>
</html>
