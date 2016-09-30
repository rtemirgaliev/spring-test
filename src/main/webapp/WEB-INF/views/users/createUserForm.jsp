<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rinat
  Date: 9/9/16
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>

<c:if test="${validationErrors != null}"><div class="error">
    <ul>
        <c:forEach items="${validationErrors}" var="error">
            <li><c:out value="${error.message}" /></li>
        </c:forEach>
    </ul>

</div></c:if>

<body>

<h2><spring:message code="title.createuser"/></h2>

    <form:form method="post" modelAttribute="user" action="create">
        <form:label path="firstName">First Name</form:label><br/>
        <form:input path="firstName"/><br/>
        <form:errors path="firstName"/><br/>
        <br/>
        <form:label path="lastName">Last Name</form:label><br/>
        <form:input path="lastName"/><br/>
        <form:errors path="lastName" /><br/>
        <br/>
        <form:label path="age">Age</form:label><br/>
        <form:input path="age"/><br/>
        <form:errors path="age"/><br/>
        <br/>
        <input type="submit" value="Save"/>
    </form:form>


    <%--<form action="create" method="POST">--%>
    <%--First Name: <input type="text" name="firstName">--%>
    <%--<br />--%>
    <%--Last Name: <input type="text" name="lastName" />--%>
    <%--<br>--%>
    <%--Age: <input type="text" name="age" />--%>
    <%--<input type="submit" value="Submit" />--%>
    <%--</form>--%>


</body>
</html>
