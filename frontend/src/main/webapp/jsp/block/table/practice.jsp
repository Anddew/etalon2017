<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table id="practicesTable"
       data-pagination="true"
       data-page-size="10"
       data-page-list="[5, 10, 20, 50, 100]"
       data-search="true"
       data-classes="table table-hover">
    <thead>
    <tr>
        <th data-field="status" data-halign="center" data-align="left">Status</th>
        <th data-field="faculty.name" data-halign="center" data-align="left">Faculty</th>
        <th data-field="educationForm" data-halign="center" data-align="left">Education form</th>
        <th data-field="studentRequiredCount" data-halign="center" data-align="left">Count</th>
        <th data-field="minAvgScore" data-halign="center" data-align="left">Score (min)</th>
        <th data-field="hireCondition" data-halign="center" data-align="left">Hiring</th>
        <th data-field="dateStart" data-halign="center" data-align="left">Start</th>
        <th data-field="dateEnd" data-halign="center" data-align="left">End</th>
        <th data-field="headFromUniversity.lastName" data-halign="center" data-align="left">Head from university</th>
        <th data-field="headFromCompany.lastName" data-halign="center" data-align="left">Head from company</th>
        <th data-field="id" data-formatter="linkFormatter2" data-halign="center" data-align="center"></th>
        <script>
            function linkFormatter2(value) {
                return "<a href=\"students/practice/" + value + "\" class=\"btn btn-default btn-block\" target=\"_blank\">Students</a>";
            }
        </script>

        <th data-field="id" data-formatter="linkFormatter3" data-halign="center" data-align="center"></th>
        <script>
            function linkFormatter3(value) {
                return "<button class=\"btn btn-default btn-block jsStudentsFromPracticeButton\" value=\"" + value + "\">Students2</button>";
            }
        </script>
    </tr>
    </thead>
</table>