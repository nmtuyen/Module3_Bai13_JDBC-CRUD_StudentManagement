
<%--
  Created by IntelliJ IDEA.
  User: Admin-Thính
  Date: 7/8/2021
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>List Student</h1>
    <h2><a href="/Students?action=creat">New student</a></h2>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Age</td>
            <td>Address</td>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.age}"/></td>
                <td><c:out value="${student.address}"/></td>
            </tr>
        </c:forEach>

    </table>
</center>

</body>
</html>
