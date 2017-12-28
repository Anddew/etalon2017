$(document).ready(function () {

    var path = window.location.pathname;
    var parseRegex = /.*\/(.?)/;
    var match = parseRegex.exec(path);
    var id = match[1];

    $.ajax({
        url: '/students/practice/'+ id + '/get',
        type: 'GET',
        contentType: "application/json",
        data: '',
        success: function (students) {
            $('#studentsTable').bootstrapTable({
                data: students
            });
        },
        error: function () {
            alert("Something went wrong!")
        }
    });

});