<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.02.2020
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/new" method="POST">
    <label><spring:message code="user.name"/> </label>
    <input type="text" required placeholder="User name" name="userName"><br>
    <label><spring:message code="password"/> </label>
    <input type="text" required placeholder="Password" name="password"><br>
    <label><spring:message code="user.first.name"/> </label>
    <input type="text" required placeholder="First name" name="firstName"><br>
    <label><spring:message code="user.last.name"/> </label>
    <input type="text" required placeholder="Last name" name="lastName"><br>
    <label><spring:message code="user.role"/> </label>
    <select name="role">
        <option value="ADMIN"><spring:message code="role.admin"/> </option>
        <option value="USER"><spring:message code="role.user"/> </option>
    </select><br>
    <label><spring:message code="user.status"/> </label>
    <select name="status">
        <option value="ACTIVE"><spring:message code="status.active"/> </option>
        <option value="INACTIVE"><spring:message code="status.inactive"/> </option>
    </select><br>
    <input type="submit" name="submit" value=<spring:message code="user.create"/> />
</form>

<c:if test="${message ne null}">
    <c:out value="${message}"/>
</c:if>
</body>
</html>
