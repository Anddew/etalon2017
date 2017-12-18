<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home page</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<body>

<jsp:include page="/jsp/block/header.jsp"/>

<div class="container">
    <%--<jsp:include page="/jsp/block/title.jsp">--%>
        <%--<jsp:param name="heading" value="" />--%>
    <%--</jsp:include>--%>
</div>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <h5>User Menu</h5>
            <div class="btn-group-vertical">
                <button type="button" class="btn btn-primary">Requests</button>
                <button type="button" class="btn btn-primary">Info</button>
                <button type="button" class="btn btn-primary">Ask for help</button>
            </div>
        </div>

        <div class="col-sm-10">



        </div>
    </div>
</div>



<jsp:include page="/jsp/block/footer.jsp"/>

</body>
</html>
