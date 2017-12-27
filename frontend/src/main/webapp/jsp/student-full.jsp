<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Full student info</title>
</head>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/custom/student-full.js"></script>
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
            <sec:authorize access="hasAnyAuthority('ADMINISTRATOR')">
                <div class="jsStudentInfoFormButtonContainer">
                    <button type="button" class="btn btn-primary jsShowStudentInfoFormButton">Set student info</button>
                </div>
                <div class="form-group jsStudentInfoFormContainer" style="display: none">
                    <input class="form-control jsAvgScore" id="avgScore" placeholder="Average score" type="text" />
                    <div class="alert alert-danger jsAvgScoreNotification" role="alert" style="display: none">
                        Input average score between 0.00-9.99
                    </div>
                    <select id="selectEducationForm" class="jsEducationForm" required>
                        <option value="0">Select education form</option>
                        <option value="FULL_TIME">Full time</option>
                        <option value="PART_TIME">Part time</option>
                        <option value="EVENING">Evening</option>
                        <option value="DISTANCE">Distance</option>
                    </select>
                    <div class="alert alert-danger jsEducationFormNotification" role="alert" style="display: none">
                        Select education form.
                    </div>
                    <select id="selectHiringForm" class="jsHiringForm">
                        <option value="0">Select hiring type</option>
                        <option value="ACCEPT">Require</option>
                        <option value="DENY">Not require</option>
                    </select>
                    <div class="alert alert-danger jsHireConditionNotification" role="alert" style="display: none">
                        Select hiring type.
                    </div>
                    <button type="submit" class="btn btn-primary jsStudentInfoFormSubmitButton">Submit</button>
                </div>
            </sec:authorize>
        </div>
        <div class="col-sm-5">
        </div>
    </div>
</div>

<jsp:include page="/jsp/block/footer.jsp"/>
</body>
</html>