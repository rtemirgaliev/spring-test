<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags" %>
<%@ page import="java.io.*, java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: rinat
  Date: 9/8/16
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>



    <%--<h2><spring:message code="title.msg"/></h2>--%>

    <h2>
        First Name: ${user.firstName}
        <br />
        Last Name: ${user.lastName}
        <br/>
        Age: ${user.age}
    </h2>






</body>
</html>
