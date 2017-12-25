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
                <sec:authorize access="hasAnyAuthority('ADMINISTRATOR','HEAD_FROM_COMPANY','HEAD_FROM_UNIVERSITY')">
                    <h5>Menu</h5>
                    <button type="button" class="btn btn-primary jsStudentsButton">Students</button>
                    <button type="button" class="btn btn-primary jsHeadFromCompanyButton">Heads from company</button>
                    <button type="button" class="btn btn-primary jsHeadFromUniversityButton">Heads from university</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('HEAD_FROM_COMPANY','HEAD_FROM_UNIVERSITY')">
                <h5>User menu</h5>
                <button type="button" class="btn btn-primary">My practices</button>
                <button type="button" class="btn btn-primary">My students</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('STUDENT')">
                    <h5>Student menu</h5>
                    <button type="button" class="btn btn-primary">My practices</button>
                    <button type="button" class="btn btn-primary jsStudentFullInfoButton" value="0">My full info</button>
                </sec:authorize>
                <sec:authorize access="hasAnyAuthority('ADMINISTRATOR')">
                    <h5>Admin menu</h5>
                    <button type="button" class="btn btn-primary jsAdminsButton">Admins</button>
                    <button type="button" class="btn btn-primary">Set student info</button>
                    <button type="button" class="btn btn-primary">Assign to practice</button>
                </sec:authorize>
            </div>
        </div>

        <div class="col-sm-10">
            <div class="jsStudentsContainer" style="display: none">
                <table id="studentsTable"
                       data-pagination="true"
                       data-page-size="10"
                       data-page-list="[5, 10, 20, 50, 100]"
                       data-search="true"
                       data-classes="table table-hover">
                    <thead>
                    <tr>
                        <th data-checkbox="true" data-halign="center" data-align="center">#</th>
                        <th data-field="firstName" data-halign="center" data-align="left" data-sortable="true">First name</th>
                        <th data-field="lastName" data-halign="center" data-align="left" data-sortable="true">Last name</th>
                        <th data-field="email" data-halign="center" data-align="left">Email</th>
                        <th data-field="speciality.faculty.university.name" data-halign="center" data-align="left" data-sortable="true">University</th>
                        <th data-field="speciality.faculty.name" data-halign="center" data-align="left" data-sortable="true">Faculty</th>
                        <th data-field="speciality.name" data-halign="center" data-align="left" data-sortable="true">Speciality</th>
                        <th data-field="groupNumber" data-halign="center" data-align="center" data-sortable="true">Group number</th>
                        <th data-field="avgScore" data-halign="center" data-align="center" data-sortable="true">Avg score</th>
                        <th data-field="educationForm" data-halign="center" data-align="center" data-sortable="true">Education form</th>
                        <th data-field="requiredJob" data-halign="center" data-align="center" data-sortable="true">Hiring</th>
                        <th data-field="practiceStatus" data-halign="center" data-align="center" data-sortable="true">Status</th>
                        <th data-field="studentId" data-formatter="linkFormatter" data-halign="center" data-align="center">Profile</th>
                        <script>
                            function linkFormatter(value) {
                                return "<a href=\"students/" + value + "\" class=\"btn btn-default btn-block\" target=\"_blank\">Show</a>";
                            }
                        </script>
                    </tr>
                    </thead>
                </table>
            </div>

            <div class="jsHeadFromCompanyContainer" style="display: none">
                <table id="headsFromCompanyTable"
                       data-pagination="true"
                       data-page-size="10"
                       data-page-list="[5, 10, 20, 50, 100]"
                       data-search="true"
                       data-classes="table table-hover">
                    <thead>
                    <tr>
                       <th data-checkbox="true" data-halign="center" data-align="center">#</th>
                       <th data-field="firstName" data-halign="center" data-align="left">First name</th>
                       <th data-field="lastName" data-halign="center" data-align="left">Last name</th>
                       <th data-field="email" data-halign="center" data-align="left">Email</th>
                       <th data-field="company.name" data-halign="center" data-align="left">Company</th>
                    </tr>
                    </thead>
                </table>
            </div>

            <div class="jsHeadFromUniversityContainer" style="display: none">
                <table id="headsFromUniversityTable"
                       data-pagination="true"
                       data-page-size="10"
                       data-page-list="[5, 10, 20, 50, 100]"
                       data-search="true"
                       data-classes="table table-hover">
                    <thead>
                    <tr>
                        <th data-checkbox="true" data-halign="center" data-align="center">#</th>
                        <th data-field="firstName" data-halign="center" data-align="left">First name</th>
                        <th data-field="lastName" data-halign="center" data-align="left">Last name</th>
                        <th data-field="email" data-halign="center" data-align="left">Email</th>
                        <th data-field="faculty.name" data-halign="center" data-align="center">Faculty</th>
                    </tr>
                    </thead>
                </table>
            </div>

            <div class="jsAdminsContainer" style="display: none">
                <table id="adminsTable"
                       data-pagination="true"
                       data-page-size="10"
                       data-page-list="[5, 10, 20, 50, 100]"
                       data-search="true"
                       data-classes="table table-hover">
                    <thead>
                    <tr>
                        <th data-checkbox="true" data-halign="center" data-align="center">#</th>
                        <th data-field="firstName" data-halign="center" data-align="left">First name</th>
                        <th data-field="lastName" data-halign="center" data-align="left">Last name</th>
                        <th data-field="email" data-halign="center" data-align="left">Email</th>
                    </tr>
                    </thead>
                </table>
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
