<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Students on practice</title>
</head>
<script src="../../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../../resources/js/custom/practice-student.js"></script>
<script src="../../resources/js/libs/bootstrap-table.js"></script>
<link href="../../resources/css/libs/bootstrap-table.min.css" rel="stylesheet" type="text/css" media="all"/>
<link href="../../resources/css/custom/student-full.css" rel="stylesheet" type="text/css" media="all"/>
<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container-fluid">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Students on practice" />
    </jsp:include>
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-10" align="center">
            <jsp:include page="/jsp/block/table/students.jsp" />
        </div>
    </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>