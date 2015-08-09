<%@include file="/WEB-INF/template/import.jsp"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:url value="/j_spring_security_check" var="loginUrl" />

<t:wrapper>
    <jsp:body>
        <h1>PROFILE</h1>
        Email :  ${email}
        Login :  ${login}






        <div class="login-help">
            <p>Forgot your password? <a href="#">Click here to reset it</a>.</p>
        </div>
    </jsp:body>
</t:wrapper>
