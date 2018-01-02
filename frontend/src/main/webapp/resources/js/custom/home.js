$(document).ready(function () {

    var ELEMENTS = {
        BTN_STUDENTS: '.jsStudentsButton',
        BTN_HEADS_FROM_COMPANY: '.jsHeadFromCompanyButton',
        BTN_HEADS_FROM_UNIVERSITY: '.jsHeadFromUniversityButton',
        BTN_ADMINS: '.jsAdminsButton',
        BTN_STUDENT_FULL_INFO: '.jsStudentFullInfoButton',
        BTN_PRACTICES: '.jsPracticesButton',
        BTN_CREATE_PRACTICE: '.jsCreatePracticeButton',
        BTN_FIND_STUDENTS: '.jsFindStudentsButton',
        BTN_ASSIGN_STUDENTS: '.jsAssignStudentsButton',
        BTN_APPROVE_PRACTICE: '.jsApprovePracticeButton',

        TABLE_HEADS_FROM_COMPANY: '.jsHeadsFromCompanyTable',
        TABLE_HEADS_FROM_UNIVERSITY: '.jsHeadsFromUniversityTable',
        TABLE_STUDENTS: '.jsStudentsTable',
        TABLE_ADMINS: '.jsAdminsTable',
        TABLE_PRACTICES: '.jsPracticesTable',

        CONTAINER_STUDENTS_DATA: '.jsStudentsContainer',
        CONTAINER_HEAD_FROM_COMPANY_DATA: '.jsHeadFromCompanyContainer',
        CONTAINER_HEAD_FROM_UNIVERSITY_DATA: '.jsHeadFromUniversityContainer',
        CONTAINER_ADMINS_DATA: '.jsAdminsContainer',
        CONTAINER_STUDENT_FULL_INFO_DATA: '.jsStudentFullInfoContainer',
        CONTAINER_PRACTICES_DATA: '.jsPracticesContainer',
        CONTAINER_PRACTICE_FORM_DATA: '.jsPracticeFormContainer'
    };

    var
        $submitStudentsButton = $(ELEMENTS.BTN_STUDENTS),
        $submitHeadsFromCompanyButton = $(ELEMENTS.BTN_HEADS_FROM_COMPANY),
        $submitHeadsFromUniversityButton = $(ELEMENTS.BTN_HEADS_FROM_UNIVERSITY),
        $submitAdminsButton = $(ELEMENTS.BTN_ADMINS),
        $submitStudentFullInfoButton = $(ELEMENTS.BTN_STUDENT_FULL_INFO),
        $submitPracticesButton = $(ELEMENTS.BTN_PRACTICES),
        $submitCreatePracticeButton = $(ELEMENTS.BTN_CREATE_PRACTICE),
        $submitFindStudentsButton = $(ELEMENTS.BTN_FIND_STUDENTS),
        $submitAssignStudentsButton = $(ELEMENTS.BTN_ASSIGN_STUDENTS),
        $submitApprovePracticeButton = $(ELEMENTS.BTN_APPROVE_PRACTICE),

        $tableHeadsFromCompany = $(ELEMENTS.TABLE_HEADS_FROM_COMPANY),
        $tableHeadsFromUniversity = $(ELEMENTS.TABLE_HEADS_FROM_UNIVERSITY),
        $tableStudents = $(ELEMENTS.TABLE_STUDENTS),
        $tableAdmins = $(ELEMENTS.TABLE_ADMINS),
        $tablePractices = $(ELEMENTS.TABLE_PRACTICES),

        $studentsContainerData = $(ELEMENTS.CONTAINER_STUDENTS_DATA),
        $headFromCompanyContainerData = $(ELEMENTS.CONTAINER_HEAD_FROM_COMPANY_DATA),
        $headFromUniversityContainerData = $(ELEMENTS.CONTAINER_HEAD_FROM_UNIVERSITY_DATA),
        $adminsContainerData = $(ELEMENTS.CONTAINER_ADMINS_DATA),
        $studentFullInfoContainerData = $(ELEMENTS.CONTAINER_STUDENT_FULL_INFO_DATA),
        $practicesContainerData = $(ELEMENTS.CONTAINER_PRACTICES_DATA),
        $practiceFormContainerData = $(ELEMENTS.CONTAINER_PRACTICE_FORM_DATA)
    ;

    var $containers = [
        $studentsContainerData,
        $headFromCompanyContainerData,
        $headFromUniversityContainerData,
        $adminsContainerData,
        $studentFullInfoContainerData,
        $practicesContainerData,
        $practiceFormContainerData
    ];

    function hideAllContainters(containers) {
        if(containers) {
            for(var i = 0; i < containers.length; i++) {
                containers[i].hide();
            }
        }
    }

    $submitStudentsButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);

        $.ajax({
            url: 'students',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (students) {
                $studentsContainerData.show();
                $tableStudents.bootstrapTable({
                    data: students
                });
            }
        });

    });


    $submitHeadsFromCompanyButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);

        $.ajax({
            url: 'heads-company',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (headsFromCompany) {
                $headFromCompanyContainerData.show();
                $tableHeadsFromCompany.bootstrapTable({
                    data: headsFromCompany
                });
            }
        });

    });

    $submitHeadsFromUniversityButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);

        $.ajax({
            url: 'heads-university',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (headsFromUniversity) {
                $headFromUniversityContainerData.show();
                $tableHeadsFromUniversity.bootstrapTable({
                    data: headsFromUniversity
                });
            }
        });

    });

    $submitAdminsButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);

        $.ajax({
            url: 'admins',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (admins) {
                $adminsContainerData.show();
                $tableAdmins.bootstrapTable({
                    data: admins
                });
            }
        });

    });


    $submitStudentFullInfoButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);
        var id = $submitStudentFullInfoButton.val();

        $.ajax({
            url: '/students/' + id,
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (student) {
                $studentFullInfoContainerData.show();
                setStudentInfo(student);
            }
        });

    });

    function setStudentInfo(student) {
        $('#id').html(student.studentId);
        $('#firstname').html(student.firstName);
        $('#lastname').html(student.lastName);
        $('#email').html(student.email);
        $('#university').html(student.speciality.faculty.university.name);
        $('#faculty').html(student.speciality.faculty.name);
        $('#speciality').html(student.speciality.name);
        $('#groupNumber').html(student.groupNumber);
        $('#avgScore').html(student.avgScore);
        $('#educationForm').html(student.educationForm);
        $('#requiredJob').html(student.requiredJob);
        $('#status').html(student.practiceStatus);
    }

    $submitPracticesButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);

        $.ajax({
            url: '/practices',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (practices) {
                $practicesContainerData.show();
                $tablePractices.bootstrapTable({
                    data: practices
                });
            }
        });

    });

    $submitCreatePracticeButton.click(function (event) {
        event.stopPropagation();

        hideAllContainters($containers);
        $practiceFormContainerData.show();

    });

    $submitFindStudentsButton.click(function (event) {
        event.stopPropagation();

        $.ajax({
            url: '/students/available',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: '',
            success: function (students) {
                $studentsContainerData.show();
                $submitAssignStudentsButton.show();
                $tableStudents.bootstrapTable({
                    data: students
                });
            }
        });

    });

    var selectedPractice;
    var studentsLeft;
    var selectedStudents = [];

    $tablePractices.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function (e, row, $element) {
        $studentsContainerData.hide();
        var selections = $tablePractices.bootstrapTable('getSelections');
        if(selections.length === 1 && selections[0].status === 'Checked') {
            selectedPractice = selections[0];
            studentsLeft = selectedPractice.studentRequiredCount - selectedPractice.currentStudentRequiredCount;
            if(studentsLeft > 0) {
                Validation.switchButtons([$submitFindStudentsButton], true);
                return;
            }
        }
        Validation.switchButtons([$submitFindStudentsButton], false);
    });

    $tablePractices.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function (e, row, $element) {
        var selections = $tablePractices.bootstrapTable('getSelections');
        if(selections.length === 1 && selections[0].status !== 'Checked') {
            selectedPractice = selections[0];
            Validation.switchButtons([$submitApprovePracticeButton], true);
        } else {
            Validation.switchButtons([$submitApprovePracticeButton], false);
        }
    });

    $tableStudents.on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function (e, row, $element) {
        var selections = $tableStudents.bootstrapTable('getSelections');
        if(selections.length > 0 && selections.length <= studentsLeft) {
            selectedStudents = selections;
            Validation.switchButtons([$submitAssignStudentsButton], true)
        } else {
            Validation.switchButtons([$submitAssignStudentsButton], false)
        }
    });

    $submitAssignStudentsButton.click(function (event) {
        event.stopPropagation();

        var practiceId = selectedPractice.id;
        var studentsId = [];
        for(var i = 0; i < selectedStudents.length; i++) {
            studentsId.push(selectedStudents[i].studentId);
        }

        $.ajax({
            url: '/practices/assign',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                practiceId: practiceId,
                studentsId : studentsId
            }),
            success: function () {
                alert('Assign successful!');
                window.location.href = "/home"
            },
            error: function () {
                alert('Assign failed!');
            }
        });
    })

    $submitApprovePracticeButton.click(function (event) {
        event.stopPropagation();

        $.ajax({
            url: '/practices/approve',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                practiceId: selectedPractice.id
            }),
            success: function () {
                alert('Approving successful!');
                window.location.href = "/home"
            },
            error: function () {
                alert('Approving failed!');
            }
        });
    })


});