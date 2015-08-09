<%@include file="/WEB-INF/template/import.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/j_spring_security_check" var="loginUrl"/>

<t:wrapper>
    <jsp:body>
        <div class="container">
            <h1>Registration</h1>
            <br/>
            <spring:url value="/user/save" var="userSaveUrl"/>

            <form:form class="form-horizontal" method="post"
                       modelAttribute="userForm" action="${userSaveUrl}">

                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Email</label>

                        <div class="col-sm-10">
                            <form:input path="email" type="text" class="form-control"
                                        id="email" placeholder="email"/>
                            <form:errors path="email" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="login">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Login</label>

                        <div class="col-sm-10">
                            <form:input path="login" class="form-control"
                                        id="login" placeholder="Login"/>
                            <form:errors path="login" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Password</label>

                        <div class="col-sm-10">
                            <form:password path="password" class="form-control"
                                           id="password" placeholder="password"/>
                            <form:errors path="password" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">confirm Password</label>

                        <div class="col-sm-10">
                            <form:password path="confirmPassword" class="form-control"
                                           id="password" placeholder="password"/>
                            <form:errors path="confirmPassword" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </div>
                </div>
            </form:form>
        </div>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

    </jsp:body>
</t:wrapper>


