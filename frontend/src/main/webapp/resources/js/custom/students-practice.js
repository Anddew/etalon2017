$(document).ready(function () {

    var ELEMENTS = {
        TABLE_STUDENTS: '.jsStudentsTable',
        BTN_RELEASE_STUDENTS: '.jsReleaseStudentsButton'
    };

    var
        $tableStudents = $(ELEMENTS.TABLE_STUDENTS),
        $submitReleaseStudentsButton = $(ELEMENTS.BTN_RELEASE_STUDENTS)
    ;

    var path = window.location.pathname;
    var parseRegex = /.*\/(\d+)/;
    var match = parseRegex.exec(path);
    var id = match[1];
    var selectedStudents;

    $.ajax({
        url: '/students/practice/'+ id + '/get',
        type: 'GET',
        contentType: "application/json",
        data: '',
        success: function (students) {
            $tableStudents.bootstrapTable({
                data: students
            });
        },
        error: function () {
            alert("Error!")
        }
    });

    $tableStudents.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function (e, row, $element) {
        var selections = $tableStudents.bootstrapTable('getSelections');
        if(selections.length > 0) {
            selectedStudents = selections;
            Validation.switchButtons([$submitReleaseStudentsButton], true)
        } else {
            selectedStudents = null;
            Validation.switchButtons([$submitReleaseStudentsButton], false)
        }
    });

    $submitReleaseStudentsButton.click(function (event) {
        event.stopPropagation();

        var studentsId = [];
        for(var i = 0; i < selectedStudents.length; i++) {
            studentsId.push(selectedStudents[i].studentId);
        }


        $.ajax({
            url: '/practices/release',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                practiceId: id,
                studentsId : studentsId
            }),
            success: function () {
                alert('Release successful!');
                window.location.href = "/home"
            },
            error: function () {
                alert('Release failed!');
            }
        });
    })

});