<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 29.11.16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<h1>File Upload</h1>
<hr>
<form method="post" action="FirstWebAction" enctype="multipart/form-data">
    Select file to upload:  <input type="file" name="file" accept=".xml" /><br/>
    <br/><button type="submit">Upload</button>
    <input type="hidden" name="command" value="upload"/>
    <input type="hidden" name="jspPath" value="${pageContext.request.servletPath}"/>
</form>
</body>
</html>
