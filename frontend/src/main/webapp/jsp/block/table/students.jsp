<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table class="jsStudentsTable"
       data-pagination="true"
       data-page-size="10"
       data-page-list="[5, 10, 20, 50, 100]"
       data-search="true"
       data-classes="table table-hover">
    <thead>
    <tr>
        <th data-checkbox="true" data-halign="center" data-align="center" data-valign="middle">#</th>
        <th data-field="firstName" data-halign="center" data-align="left" data-valign="middle" data-sortable="true">First name</th>
        <th data-field="lastName" data-halign="center" data-align="left" data-valign="middle" data-sortable="true">Last name</th>
        <th data-field="email" data-halign="center" data-align="left" data-valign="middle">Email</th>
        <th data-field="speciality.faculty.university.name" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">University</th>
        <th data-field="speciality.faculty.name" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Faculty</th>
        <th data-field="speciality.name" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Speciality</th>
        <th data-field="groupNumber" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Group number</th>
        <th data-field="avgScore" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Avg score</th>
        <th data-field="educationForm" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Education form</th>
        <th data-field="hireCondition" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Hiring</th>
        <th data-field="practiceStatus" data-halign="center" data-align="center" data-valign="middle" data-sortable="true">Status</th>
        <th data-field="studentId" data-formatter="linkFormatter" data-halign="center" data-align="center" data-valign="middle">Profile</th>
        <script>
            function linkFormatter(value) {
                return "<a href=\"/students/" + value + "\" class=\"btn btn-default btn-block\" target=\"_blank\">Show</a>";
            }
        </script>
    </tr>
    </thead>
</table>

<sec:authorize access="hasAnyAuthority('HEAD_FROM_COMPANY')">
    <button type="button" class="btn btn-primary jsAssignStudentsButton" disabled style="display: none">Assign students</button>
</sec:authorize>