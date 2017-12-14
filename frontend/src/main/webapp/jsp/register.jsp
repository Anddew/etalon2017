<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Register page</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/register.js"></script>
<link href="../resources/css/custom/register.css" rel="stylesheet" type="text/css" media="all"/>
<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container-fluid">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Welcome on registration page" />
    </jsp:include>

    <div class="row">
        <div class="col-md-5">
        </div>
        <div class="col-md-2" align="center">
            <sec:authorize access="isAuthenticated()">
                <jsp:include page="/jsp/block/logged.jsp"/>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <h6>I want to register as</h6>
                <input class="jsRadioButton" type="radio" id="roleStudent" name="role" value="student">
                <label for="roleStudent">Student</label>
                <br/>
                <input class="jsRadioButton" type="radio" id="roleHeadFromCompany" name="role" value="head_from_company">
                <label for="roleHeadFromCompany">Head from company</label>
                <br/>
                <input class="jsRadioButton" type="radio" id="roleHeadFromUniversity" name="role" value="head_from_university">
                <label for="roleHeadFromUniversity">Head from university</label>
                <div class="alert alert-danger jsRadioButtonSelectNotification" role="alert" style="display: none">
                    Select your registration type.
                </div>

                <div class="form-group">
                    <input type="text" class="form-control jsUsername" id="username" placeholder="User name" name="username">
                </div>
                <div class="alert alert-danger jsUsernameNotification" role="alert" style="display: none">
                    Input your username. Only letters and digits available. Length 3..15 symbols.
                </div>

                <div class="form-group">
                    <input type="email" class="form-control jsEmail" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                </div>
                <div class="alert alert-danger jsEmailNotification" role="alert" style="display: none">
                    Input your email. Should be like "example@gmail.com".
                </div>

                <div class="form-group">
                    <input type="password" class="form-control jsPassword" id="exampleInputPassword" placeholder="Password" name="password">
                </div>
                <div class="alert alert-danger jsPasswordNotification" role="alert" style="display: none">
                    Input your password. Only letters and digits available. Length 3..15 symbols.
                </div>

                <div class="form-group">
                    <input type="password" class="form-control jsPasswordRepeat" id="repeatPassword" placeholder="Repeat password" name="passwordRepeat">
                </div>
                <div class="alert alert-danger jsPasswordRepeatNotification" role="alert" style="display: none">
                    Passwords don`t match! Correct it.
                </div>

                <div class="form-group">
                    <input type="text" class="form-control jsFirstName" id="firstName" placeholder="First name" name="firstName">
                </div>
                <div class="alert alert-danger jsFirstNameNotification" role="alert" style="display: none">
                    Input your first name. Only letters available.
                </div>

                <div class="form-group">
                    <input type="text" class="form-control jsLastName" id="lastName" placeholder="Last name" name="lastName">
                </div>
                <div class="alert alert-danger jsLastNameNotification" role="alert" style="display: none">
                    Input your last name. Only letters available. Length 2..15 symbols.
                </div>

                <div id="head_from_company" class="form-group show-hide">
                    <input type="text" class="form-control jsHeadFromCompany" id="inputHeadFromCompany"  placeholder="Company" name="company">
                </div>
                <div class="alert alert-danger jsHeadFromCompanyNotification" role="alert" style="display: none">
                    Input your company. Only letters available. Length 2..15 symbols.
                </div>

                <div id="head_from_university" class="form-group show-hide">
                    <input type="text" class="form-control jsHeadFromUniversity" id="inputHeadFromUniversity" placeholder="Faculty" name="faculty">
                </div>
                <div class="alert alert-danger jsHeadFromUniversityNotification" role="alert" style="display: none">
                    Input your faculty. Only letters available. Length 2..15 symbols.
                </div>

                <div id="student" class="form-group show-hide">
                    <input type="text" class="form-control jsStudent" id="inputStudent" placeholder="Group number" name="group">
                </div>
                <div class="alert alert-danger jsStudentNotification" role="alert" style="display: none">
                    Input your group number like "850505" or "RT-611". Max 10 symbols.
                </div>

                <button type="submit" class="btn btn-primary jsSubmitRegister">Register</button>
                <a href="login">Go login</a>

                <div class="alert alert-danger jsErrorFormNotification" role="alert" style="display: none">
                    Some fields are empty. Please fill all of them.
                </div>

                <div class="alert alert-danger jsServerErrorNotification" role="alert" style="display: none">
                    Server error. Try again later or call your system administrator.
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