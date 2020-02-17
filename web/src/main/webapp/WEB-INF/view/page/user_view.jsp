<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.02.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table class="table table-striped table-bordered table-sm">
        <tr>
            <sec:authorize access="hasRole('ADMIN')">
                <th><spring:message code="user.id"/> </th>
            </sec:authorize>
            <th><spring:message code="user.name"/> </th>
            <sec:authorize access="hasRole('ADMIN')">
                <th><spring:message code="password"/> </th>
            </sec:authorize>
            <th><spring:message code="user.first.name"/> </th>
            <th><spring:message code="user.last.name"/> </th>
            <th><spring:message code="user.created.at"/> </th>
            <th><spring:message code="user.role"/> </th>
            <th><spring:message code="user.status"/> </th>
        </tr>

        <tr>
            <sec:authorize access="hasRole('ADMIN')">
                <th>${user.id} </th>
            </sec:authorize>
            <td>${user.userName}</td>
            <sec:authorize access="hasRole('ADMIN')">
                <th>${user.password} </th>
            </sec:authorize>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.createdAt}</td>
            <td>${user.role}</td>
            <td>${user.status}</td>
        </tr>
    </table>
</div>

<sec:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/user/${user.id}/edit"><spring:message code="edit.user"/> </a><br>
</sec:authorize>
</body>
</html>
