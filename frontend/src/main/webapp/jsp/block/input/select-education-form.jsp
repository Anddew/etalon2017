<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<select id="selectEducationForm" class="form-control jsEducationForm" required>
    <option value="">Select education form</option>
    <option value="FULL_TIME">Full time</option>
    <option value="PART_TIME">Part time</option>
    <option value="EVENING">Evening</option>
    <option value="DISTANCE">Distance</option>
</select>
<div class="alert alert-danger jsEducationFormNotification" role="alert" style="display: none">
    Select education form.
</div>