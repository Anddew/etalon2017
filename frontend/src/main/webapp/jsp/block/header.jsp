<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="../../resources/js/libs/popper.min.js"></script>
<script src="../../resources/js/libs/bootstrap.min.js"></script>
<script src="../../resources/js/custom/validation.js"></script>
<link href="../../resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../../resources/css/custom/general.css" rel="stylesheet" type="text/css" media="all"/>
<header class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <span class="text-muted text-center fixed-top" style="padding-bottom: 20px" >Student practice application</span>
            </div>
            <div class="col-md-2">
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="user" property="principal"/>
                    <h5>Hello, ${user.username}</h5>
                    <a href="/logout">Log out</a>
                    <br/>
                    <h6>Role - ${user.authorities}</h6>
                    <a href="/home" >Go home</a>
                </sec:authorize>
            </div>
        </div>
    </div>
</header>
