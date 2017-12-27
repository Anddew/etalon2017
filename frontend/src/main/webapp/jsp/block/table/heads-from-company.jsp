<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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