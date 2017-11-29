<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/loadSimpleData.js"></script>
<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Register page" />
    </jsp:include>
</div>

<div class="container">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Welcome on login page" />
    </jsp:include>

    <div class="row">
        <div class="col">
        </div>
        <div class="col login-border">
            <form name="registerForm" action="register" method="post">
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

                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
                </div>
                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input type="text" class="form-control" id="firstName" placeholder="First name" name="firstName">
                </div>
                <div class="form-group">
                    <label for="lastName">Last name</label>
                    <input type="text" class="form-control" id="lastName" placeholder="Last name" name="lastName">
                </div>

                <button type="submit" class="btn btn-primary">Register</button>
            </form>

        </div>
    </div>

</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>