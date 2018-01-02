<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<table class="jsPracticesTable"
       data-pagination="true"
       data-page-size="10"
       data-page-list="[5, 10, 20, 50, 100]"
       data-search="true"
       data-classes="table table-hover">
    <thead>
    <tr>
        <sec:authorize access="hasAnyAuthority('ADMINISTRATOR','HEAD_FROM_COMPANY')">
            <th data-checkbox="true" data-halign="center" data-align="center" data-valign="middle">#</th>
        </sec:authorize>
        <th data-field="status" data-halign="center" data-align="center" data-valign="middle">Status</th>
        <th data-field="faculty.university.name" data-halign="center" data-align="center" data-valign="middle">University</th>
        <th data-field="faculty.name" data-halign="center" data-align="center" data-valign="middle">Faculty</th>
        <th data-field="educationForm" data-halign="center" data-align="center" data-valign="middle">Education form</th>
        <th data-field="currentStudentRequiredCount" data-halign="center" data-align="center" data-valign="middle">Students current</th>
        <th data-field="studentRequiredCount" data-halign="center" data-align="center" data-valign="middle">Students count</th>
        <th data-field="minAvgScore" data-halign="center" data-align="center" data-valign="middle">Score</th>
        <th data-field="hireCondition" data-halign="center" data-align="center" data-valign="middle">Hiring</th>
        <th data-field="dateStart" data-halign="center" data-align="center" data-valign="middle">Start</th>
        <th data-field="dateEnd" data-halign="center" data-align="center" data-valign="middle">End</th>
        <th data-field="headFromUniversity.lastName" data-halign="center" data-align="center" data-valign="middle">Head from university</th>
        <th data-field="headFromCompany.lastName" data-halign="center" data-align="center" data-valign="middle">Head from company</th>
        <th data-field="id" data-formatter="linkFormatter2" data-halign="center" data-align="center" data-valign="middle"></th>
        <script>
            function linkFormatter2(value) {
                return "<a href=\"students/practice/" + value + "\" class=\"btn btn-default btn-block\" target=\"_blank\">Students</a>";
            }
        </script>
    </tr>
    </thead>
</table>

<sec:authorize access="hasAnyAuthority('HEAD_FROM_COMPANY')">
    <button type="button" class="btn btn-primary jsFindStudentsButton" disabled>Find students</button>
</sec:authorize>
<sec:authorize access="hasAnyAuthority('ADMINISTRATOR')">
    <button type="button" class="btn btn-primary jsApprovePracticeButton" disabled>Approve practice</button>
</sec:authorize>