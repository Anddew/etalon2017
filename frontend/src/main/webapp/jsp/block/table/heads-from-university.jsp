<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table class="jsHeadsFromUniversityTable"
       data-pagination="true"
       data-page-size="10"
       data-page-list="[5, 10, 20, 50, 100]"
       data-search="true"
       data-classes="table table-hover">
    <thead>
    <tr>
        <th data-checkbox="true" data-halign="center" data-align="center" data-valign="middle">#</th>
        <th data-field="firstName" data-halign="center" data-align="left" data-valign="middle">First name</th>
        <th data-field="lastName" data-halign="center" data-align="left" data-valign="middle">Last name</th>
        <th data-field="email" data-halign="center" data-align="left" data-valign="middle">Email</th>
        <th data-field="faculty.name" data-halign="center" data-align="center" data-valign="middle">Faculty</th>
    </tr>
    </thead>
</table>

<sec:authorize access="hasAnyAuthority('ADMINISTRATOR')">
    <button type="button" class="btn btn-primary jsSetHeadButton" disabled style="display: none">Set head</button>
</sec:authorize>