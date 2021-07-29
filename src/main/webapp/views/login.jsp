<%--
  Created by IntelliJ IDEA.
  User: welldev003
  Date: ২৪/৭/২১
  Time: ৪:১৩ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Likhalikhi</title>
</head>
<body>
    <form action="/register" method="post">
        <label for="name">Name</label>
        <input name="name" id="name" type="text"/>

        <label for="password">Enter password</label>
        <input name="password" id="password" type="password"/>

        <input type="submit" value="Submit">

    </form>
</body>
</html>
