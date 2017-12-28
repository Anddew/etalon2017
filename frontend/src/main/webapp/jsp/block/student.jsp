<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <tbody>
    <tr style="display: none">
        <td id="id">${student.studentId}</td>
    </tr>
    <tr>
        <th>First name: </th>
        <td id="firstname">${student.firstName}</td>
    </tr>
    <tr>
        <th>Last Name: </th>
        <td id="lastname">${student.lastName}</td>
    </tr>
    <tr>
        <th>Email: </th>
        <td id="email">${student.email}</td>
    </tr>
    <tr>
        <th>University: </th>
        <td id="university">${student.speciality.faculty.university.name}</td>
    </tr>
    <tr>
        <th>Faculty: </th>
        <td id="faculty">${student.speciality.faculty.name}</td>
    </tr>
    <tr>
        <th>Speciality: </th>
        <td id="speciality">${student.speciality.name}</td>
    </tr>
    <tr>
        <th>Group number: </th>
        <td id="groupNumber">${student.groupNumber}</td>
    </tr>
    <tr>
        <th>Avg score: </th>
        <td id="avgScore">${student.avgScore}</td>
    </tr>
    <tr>
        <th>Education form: </th>
        <td id="educationForm">${student.educationForm}</td>
    </tr>
    <tr>
        <th>Hiring: </th>
        <td id="hireCondition">${student.hireCondition}</td>
    </tr>
    <tr>
        <th>Status: </th>
        <td id="status">${student.practiceStatus}</td>
    </tr>
    </tbody>
</table>
