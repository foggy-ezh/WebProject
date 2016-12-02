<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 29.11.16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="properties.uploadFileText"/>
<html>
<head>
    <title><fmt:message key="upload.title"/></title>
</head>
<body>
<h1><fmt:message key="upload.header.upload.file"/></h1>
<hr>
<form method="post" action="FirstWebAction" enctype="multipart/form-data">
    <fmt:message key="upload.select.file"/><input type="file" name="file" accept=".xml" /><br/>
    <br/><button type="submit"><fmt:message key="upload.button.upload"/></button>
    <input type="hidden" name="command" value="upload"/>
    <input type="hidden" name="jspPath" value="${pageContext.request.servletPath}"/>
</form>
<hr>
<%@include file="/jsp/language.jsp" %>
<%--<jsp:include page="/jsp/language.jsp" flush="false"/>--%>
</body>
</html>
