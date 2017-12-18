<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal"/>
<div align="center">
    You are already logged as ${user.authorities}.
</div>
<br/>
<a href="/home">Go home</a>
<br/>
<a href="/logout">Log out</a>