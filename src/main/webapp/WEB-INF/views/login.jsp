<%@include file="/WEB-INF/template/import.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:url value="/j_spring_security_check" var="loginUrl"/>
<t:wrapper>
    <jsp:body>

        <div class="login" >
            <h1>Login to Web App</h1>
            <c:if test="${not empty logout}">
                <div class="msg">${logout}</div>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.email == null}">
                <form action="${loginUrl}" name="loginForm" method="post">
                    <p><input type="text" name="j_username" value="" placeholder="Username or Email"></p>

                    <p><input type="password" name="j_password" value="" placeholder="Password"></p>

                    <p class="submit"><input type="submit" name="commit" value="Login"></p>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
            </c:if>

        </div>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>


        <div class="login-help">
            <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
        </div>
    </jsp:body>
</t:wrapper>


