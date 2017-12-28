<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="../../resources/js/custom/block/practice-form.js"></script>

<div class="col-sm-2">

    <jsp:include page="/jsp/block/input/input-students-required-count.jsp" />
    <jsp:include page="/jsp/block/input/select-university.jsp" />
    <jsp:include page="/jsp/block/input/select-faculty.jsp" />
    <jsp:include page="/jsp/block/input/input-avg-score.jsp" />
    <jsp:include page="/jsp/block/input/select-education-form.jsp" />
    <jsp:include page="/jsp/block/input/select-hire-condition.jsp" />
    <jsp:include page="/jsp/block/input/date-start-end.jsp" />

    <button type="submit" class="btn btn-primary jsSubmitCreatePracticeButton">Create</button>
    <div class="alert alert-danger jsSubmitPracticeNotification" role="alert" style="display: none">
        Some fields are empty.
        <br/>
        Fill `em all!
    </div>

</div>

