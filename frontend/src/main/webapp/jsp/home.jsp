<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/home.js"></script>
<script src="../resources/js/libs/bootstrap-table.js"></script>
<link href="../resources/css/libs/bootstrap-table.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../resources/css/custom/home.css" rel="stylesheet" type="text/css" media="all"/>
<body>
<jsp:include page="/jsp/block/header.jsp"/>
<div class="container-fluid">
    <div class="row content">

        <div class="col-sm-2" align="center">
            <div class="btn-group-vertical">
                <sec:authentication var="user" property="principal"/>
                <sec:authorize access="hasAnyAuthority('STUDENT')">
                    <h5>Student menu</h5>
                    <button type="button" class="btn btn-primary jsPracticesButton">My practices</button>
                    <button type="button" class="btn btn-primary jsStudentFullInfoButton" value="0">My full info</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('HEAD_FROM_COMPANY','HEAD_FROM_UNIVERSITY')">
                <h5>Head menu</h5>
                    <button type="button" class="btn btn-primary jsPracticesButton">My practices</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('ADMINISTRATOR','HEAD_FROM_COMPANY','HEAD_FROM_UNIVERSITY')">
                    <button type="button" class="btn btn-primary jsStudentsButton">Students</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('ADMINISTRATOR')">
                    <h5>Admin menu</h5>
                    <button type="button" class="btn btn-primary jsPracticesButton">Practices</button>
                    <button type="button" class="btn btn-primary jsAdminsButton">Admins</button>
                    <button type="button" class="btn btn-primary jsHeadFromCompanyButton">Heads from company</button>
                    <button type="button" class="btn btn-primary jsHeadFromUniversityButton">Heads from university</button>
                    <button type="button" class="btn btn-primary">Set student info</button>
                    <button type="button" class="btn btn-primary">Assign to practice</button>
                </sec:authorize>
            </div>
        </div>

        <div class="col-sm-10">
            <div class="jsStudentsContainer" style="display: none">
                <jsp:include page="/jsp/block/table/students.jsp" />
            </div>
            <div class="jsHeadFromCompanyContainer" style="display: none">
                <jsp:include page="/jsp/block/table/heads-from-company.jsp" />
            </div>
            <div class="jsHeadFromUniversityContainer" style="display: none">
                <jsp:include page="/jsp/block/table/heads-from-university.jsp" />
            </div>
            <div class="jsAdminsContainer" style="display: none">
                <jsp:include page="/jsp/block/table/admins.jsp" />
            </div>
            <div class="jsPracticesContainer" style="display: none">
                <jsp:include page="/jsp/block/table/practice.jsp" />
            </div>
            <div class="jsStudentFullInfoContainer" style="display: none">
                <jsp:include page="/jsp/block/student.jsp" />
            </div>
        </div>

    </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>

</body>
</html>
