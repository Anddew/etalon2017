<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="resources/js/custom/loadSimpleData.js"></script>
<body>

<jsp:include page="/jsp/block/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Full student information" />
    </jsp:include>
</div>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <h5>User Info</h5>
            <ul class="list-group">
                <li class="list-group-item">Role <a>Student</a></li>
                <li class="list-group-item">First name <a>Ivan</a></li>
                <li class="list-group-item">Last name <a>Petrov</a></li>
            </ul>
            <br><br>
            <h5>User Menu</h5>
            <div class="btn-group-vertical">
                <button type="button" class="btn btn-primary">Requests</button>
                <button type="button" class="btn btn-primary">Info</button>
                <button type="button" class="btn btn-primary">Ask for help</button>
            </div>

        </div>

        <div class="col-sm-10">

            <table class = "table table-hover">

                <thead>
                <tr>
                    <th>Check-box</th>
                    <th>Last name</th>
                    <th>First name</th>
                    <th>University</th>
                    <th>Faculty</th>
                    <th>Group</th>
                    <th>Form</th>
                    <th>Avg score</th>
                    <th>Status</th>
                    <th>Company</th>
                    <th>Practice period</th>
                    <th>Comment</th>
                    <th>Info</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>
                        <input type="checkbox" class="form-check-input">
                    </td>
                    <td>Petrov</td>
                    <td>Ivan</td>
                    <td>BSUIR</td>
                    <td>FKP</td>
                    <td>902761</td>
                    <td>Budget</td>
                    <td>7.56</td>
                    <td>Available</td>
                    <td>Integral</td>
                    <td>20.10.2017 - 29.12.2017</td>
                    <td></td>
                    <td></td>
                </tr>

                </tbody>

            </table>

        </div>
    </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>

</body>
</html>
