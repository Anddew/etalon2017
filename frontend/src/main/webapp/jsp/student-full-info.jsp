<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Full student info</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<body>
<jsp:include page="/jsp/block/header.jsp"/>

<div class="container-fluid">
    <jsp:include page="/jsp/block/title.jsp">
        <jsp:param name="heading" value="Full student information" />
    </jsp:include>

    <div class="row">
        <div class="col-sm-5">
        </div>
        <div class="col-sm-2" align="center">
            <jsp:include page="/jsp/block/student.jsp" />
        </div>
        <div class="col-sm-5">
        </div>
    </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>