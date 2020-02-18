<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

    <sec:authorize access="!isAuthenticated()">
        <a href="${pageContext.request.contextPath}/login"><spring:message code="form.login"/></a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
<%--        <a href="${pageContext.request.contextPath}/my_page"><sec:authentication property="principal.login"/></a>--%>
        <a href="${pageContext.request.contextPath}/logout"><spring:message code="logout"/> </a>
        <a href="${pageContext.request.contextPath}/user/"><spring:message code="page.main"/> </a>
    </sec:authorize>

</body>
</html>