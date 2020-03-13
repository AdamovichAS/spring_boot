<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<sec:authorize access="hasRole('GRAND_ADMIN')">
    <a href="${pageContext.request.contextPath}/user/new"><spring:message code="user.create"/> </a><br>
</sec:authorize>

<jsp:include page="user_pagination.jsp"/>
</body>
</html>