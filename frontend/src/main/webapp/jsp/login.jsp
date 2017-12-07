<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Login</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/login.js"></script>
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
                    <div class="form-group">
                        <input class="form-control jsUsername" id="inputUsername" placeholder="Username" type="text"/>
                    </div>
                    <div class="form-group">
                        <input class="form-control jsPassword" id="exampleInputPassword1" placeholder="Password" type="password" />
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="" />
                            Remember me
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary jsSubmitLogin">Log in</button>
                    <a href="register" class="btn btn-secondary">Go register</a>
                    <div class="alert alert-danger jsInputIncorrectNotification" role="alert" style="display: none">
                        Incorrect input. Check your input data.
                    </div>
                    <div class="alert alert-danger jsCredentialsIncorrectNotification" role="alert" style="display: none">
                        No such user. Check your username and password.
                    </div>
                </sec:authorize>
            </div>
            <div class="col-md-5">
            </div>
        </div>


</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>
