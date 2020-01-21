<%--
  Created by IntelliJ IDEA.
  User: eport2
  Date: 2019-10-14
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta name="viewport" content="target-densitydpi=device-dpi, width=device-width " />
<head>
    <title>Success</title>
</head>
<body>
Congraduations
<c:out value="${pageContext.request.getAttribute('users')}"></c:out>
<c:if test="${not empty pageContext.request.getAttribute('users')}">
    <c:forEach items="${pageContext.request.getAttribute('users')}" var="user">
        <c:out value="${user.username}"></c:out>
    </c:forEach>
</c:if>

</body>
</html>
