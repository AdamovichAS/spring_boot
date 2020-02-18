<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="POST" class="form-signin">
    <fieldset>
        <legend><spring:message code="form.login"/></legend>

        <label for="user_name"><strong><spring:message code="user.name"/></strong></label>
        <input id="user_name" type="text" name="user_name" required class="form-control"><br>

        <label for="password"><strong><spring:message code="password"/></strong></label>
        <input id="password" type="password" name="password" required class="form-control"><br>
        <input type="submit" value="<spring:message code="submit"/>"/><br>
    </fieldset>
</form>
<c:if test="${error ne null}">
    <spring:message code="login.error"/> <br>
    Reason ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</c:if>

</body>
</html>
