<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 30.11.16
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h2>Something went wrong, please go back and try again.</h2>
<form name="Back" action="FirstWebAction" method="post">
    <button type="submit"><-Back</button>
    <input type="hidden" name="command" value="back"/>
</form>
<hr>
<h3>Leave us a message so we can fix this problem in future.</h3>
<button disabled>Send message</button>
</body>
</html>
