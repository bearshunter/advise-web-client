<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@tag description="ROOT TEMPLATE" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Instant Adviser</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<sec:authorize access="hasRole('ROLE_USER')">
    <sec:authentication var="user" property="principal"/>
</sec:authorize>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <c:url value="/j_spring_security_logout" var="logoutUrl"/>
                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>

                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>


                <c:choose>
                    <c:when test="${not empty user}">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/profile">${user.login} </a></li>
                        <li role="presentation"><a href="javascript:formSubmit()">Log Out</a></li>
                    </c:when>
                    <c:otherwise>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/registration">Sign up</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/login">Log in</a></li>

                    </c:otherwise>
                </c:choose>
                <li role="presentation"><a href="${pageContext.request.contextPath}/about">How it works</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">INSTANT ADVISER</h3>
    </div>
    <hr>
    <jsp:doBody/>
</div>


<hr>
<div id="footer">
    <div class="container">
        <jsp:invoke fragment="footer"/>
        <p class="muted credit">&copy; Instant Adviser 2015.</p>
    </div>
</div>

</body>
</html>