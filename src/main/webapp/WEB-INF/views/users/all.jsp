<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rinat
  Date: 9/16/16
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.userList"/></title>
    <h2><spring:message code="title.userList"/></h2>
</head>
<body>

<c:if test="${userList != null}"><div>
    <ul>
        <c:forEach items="${userList}" var="user">
            <li><c:out value="${user.firstName}" /></li>
            <li><c:out value="${user.lastName}" /></li>
            <li><c:out value="${user.age}" /></li>
            <br/>
        </c:forEach>
    </ul>
</div></c:if>

<a href="users/create">Create new user</a>

</body>
</html>
