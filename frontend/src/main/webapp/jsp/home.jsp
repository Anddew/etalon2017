<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 06.10.2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<script src="resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="resources/js/custom/loadSimpleData.js"></script>
<body>
<jsp:include page="/jsp/blocks/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Home page" />
    </jsp:include>
</div>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>

