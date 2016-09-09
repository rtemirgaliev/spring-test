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


    <h2>HTTP Header Request</h2>


    <form action="create" method="POST">
        First Name: <input type="text" name="firstName">
        <br />
        Last Name: <input type="text" name="lastName" />
        <br>
        Age: <input type="text" name="age" />
        <input type="submit" value="Submit" />
    </form>

    <%--<table border="1" align="center">--%>
        <%--<tr bgcolor="#949494">--%>
            <%--<th>Header Name</th><th>Header Value(s)</th>--%>
        <%--</tr>--%>
        <%--<%--%>
            <%--Enumeration headerNames = request.getHeaderNames();--%>
            <%--while(headerNames.hasMoreElements()) {--%>
                <%--String paramName = (String)headerNames.nextElement();--%>
                <%--out.print("<tr><td>" + paramName + "</td>\n");--%>
                <%--String paramValue = request.getHeader(paramName);--%>
                <%--out.println("<td> " + paramValue + "</td></tr>\n");--%>
            <%--}--%>
        <%--%>--%>
    <%--</table>--%>

    <%--<h2>HTTP Header Response</h2>--%>
    <%--<table border="1" align="center">--%>
        <%--<tr bgcolor="#949494">--%>
            <%--<th>Header Name</th><th>Header Value(s)</th>--%>
        <%--</tr>--%>
        <%--<%--%>
            <%--Collection responseHeaderNames = response.getHeaderNames();--%>
            <%--for (Object headerName : responseHeaderNames) {--%>
                <%--out.print("<tr><td>" + headerName + "</td>\n");--%>
                <%--String headerValue = response.getHeader((String)headerName);--%>
                <%--out.println("<td> " + headerValue + "</td></tr>\n");--%>
            <%--}--%>

        <%--%>--%>
    <%--</table>--%>


</body>
</html>
