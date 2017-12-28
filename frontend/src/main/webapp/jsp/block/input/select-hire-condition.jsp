<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<select id="selectHiringForm" class="form-control jsHiringType">
    <option value="">Select hiring type</option>
    <option value="ACCEPT">Require</option>
    <option value="DENY">Not require</option>
</select>
<div class="alert alert-danger jsHireConditionNotification" role="alert" style="display: none">
    Select hiring type.
</div>