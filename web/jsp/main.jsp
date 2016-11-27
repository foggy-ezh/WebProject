<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 26.11.16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>XML Parser</title>
</head>
<body>
<h1>Main Page</h1>
<hr>
<form name="XMLParser" action="FirstWebAction" method="post">
    <p>Choose type of xml parser:</p>
    <select name="typeParser">
        <option value="dom">DOM parser</option>
        <option value="sax">SAX parser</option>
        <option value="stax">StAX parser</option>
    </select>
    <button type="submit">Submit</button>
    <input type="hidden" name="command" value="parse">
</form>
</body>
</html>
