<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Login</title>
</head>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>

<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container-fluid">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Welcome on login page" />
    </jsp:include>

        <div class="row">
            <div class="col-md-5">
            </div>
            <div class="col-md-2" align="center">
                <sec:authorize access="isAuthenticated()">
                    <jsp:include page="/jsp/block/logged.jsp"/>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <jsp:include page="/jsp/block/login-form.jsp"/>
                </sec:authorize>
            </div>
            <div class="col-md-5">
            </div>
        </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>
