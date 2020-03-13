<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.02.2020
  Time: 19:13
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
        <H3><spring:message code="users"/></H3>
        <tr>
            <th><spring:message code="user.name"/></th>
        </tr>

        <c:forEach items="${page.views}" var="user">
            <tr>
                    <%--                <td>${user.getUserName()}</td>--%>
                <td>
                    <sec:authorize access="hasAnyRole('ADMIN','GRAND_ADMIN')">
                        <a href="${pageContext.request.contextPath}/user/${user.id}">${user.userName}</a><br>
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        ${user.userName}<br>
                    </sec:authorize>
                </td>
                    <%--                <c:if test="${id eq user.id}">--%>
                    <%--                    <jsp:include page="user_view.jsp"/>--%>
                    <%--                </c:if>--%>
            </tr>
        </c:forEach>
    </table>
</div>

<nav aria-label="...">
    <ul class="pagination">
        <c:if test="${page.currentPage > 1}">
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/user/?currentPage=${page.currentPage-1}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:forEach begin="1" end="${page.maxPages}" var="item">
            <c:choose>
                <c:when test="${page.currentPage == item}">
                    <li class="page-item active" aria-current="page">
                        <a class="page-link">${item}<span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/user/?currentPage=${item}">${item}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${page.currentPage < page.maxPages}">
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/user/?currentPage=${page.currentPage+1}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>
</body>
</body>
</html>
