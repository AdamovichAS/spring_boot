<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.02.2020
  Time: 18:10
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
<form action="${pageContext.request.contextPath}/registration" method="POST">

    <input type="text" required placeholder="<spring:message code="user.name"/>" name="userName"class="form-control"><br>

    <input type="text" required placeholder="<spring:message code="password"/>" name="password"class="form-control"><br>

    <input type="text" required placeholder="<spring:message code="user.first.name"/>" name="firstName"class="form-control"><br>

    <input type="text" required placeholder="<spring:message code="user.last.name"/>" name="lastName"class="form-control"><br>
    <label><spring:message code="user.role"/> </label>
    <select name="role">
        <option value="ADMIN"><spring:message code="role.admin"/> </option>
        <option value="USER"><spring:message code="role.user"/> </option>
        <option value="GRAND_ADMIN"><spring:message code="role.grand_admin"/> </option>
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
