<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/loadSimpleData.js"></script>
<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Welcome on login page" />
    </jsp:include>

    <div class="row">
        <div class="col login-border">
            <form name="loginForm" action="login" method="post">
                <div>
                    <input type="radio" id="roleStudent" name="role" value="student">
                    <label for="roleStudent">Student</label>
                </div>
                <div>
                    <input type="radio" id="roleHeadFromCompany" name="role" value="head_from_company">
                    <label for="roleHeadFromCompany">Head from company</label>
                </div>
                <div>
                    <input type="radio" id="roleHeadFromUniversity" name="role" value="head_from_university">
                    <label for="roleHeadFromUniversity">Head from university</label>
                </div>
                <div>
                    <input type="radio" id="roleAdministrator" name="role" value="administrator">
                    <label for="roleAdministrator">Administrator</label>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="">
                        Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <%--<button type="button" class="btn btn-secondary" href="register">Register</button>--%>
                <a href="register" class="btn btn-secondary">Register</a>
            </form>

        </div>
    </div>
    <%--<br>
    <div>
        <h3>Printing data using model and view</h3>
        <div class="jsDataUsingModelAndView">
            <c:if test="${not empty users}">
                <c:forEach items="${users}" var="users">
                    ${users.id} | ${users.name} <br>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div>
        <h3>Printing data using js & ajax</h3>
        <div class="jsDataUsingAjax">
        </div>
    </div>--%>

</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>
