$(document).ready(function () {

    var ELEMENTS = {
        BTN_STUDENTS: '.jsStudentsButton',
        BTN_HEADS_FROM_COMPANY: '.jsHeadFromCompanyButton',
        BTN_HEADS_FROM_UNIVERSITY: '.jsHeadFromUniversityButton',
        BTN_ADMINS: '.jsAdminsButton',
        BTN_STUDENT_FULL_INFO: '.jsStudentFullInfoButton',

        CONTAINER_STUDENTS_DATA: '.jsStudentsContainer',
        CONTAINER_HEAD_FROM_COMPANY_DATA: '.jsHeadFromCompanyContainer',
        CONTAINER_HEAD_FROM_UNIVERSITY_DATA: '.jsHeadFromUniversityContainer',
        CONTAINER_ADMINS_DATA: '.jsAdminsContainer',
        CONTAINER_STUDENT_FULL_INFO_DATA: '.jsStudentFullInfoContainer'
    };

    var
        $submitStudentsButton = $(ELEMENTS.BTN_STUDENTS),
        $submitHeadsFromCompanyButton = $(ELEMENTS.BTN_HEADS_FROM_COMPANY),
        $submitHeadsFromUniversityButton = $(ELEMENTS.BTN_HEADS_FROM_UNIVERSITY),
        $submitAdminsButton = $(ELEMENTS.BTN_ADMINS),
        $submitStudentFullInfoButton = $(ELEMENTS.BTN_STUDENT_FULL_INFO),

        $studentsContainerData = $(ELEMENTS.CONTAINER_STUDENTS_DATA),
        $headFromCompanyContainerData = $(ELEMENTS.CONTAINER_HEAD_FROM_COMPANY_DATA),
        $headFromUniversityContainerData = $(ELEMENTS.CONTAINER_HEAD_FROM_UNIVERSITY_DATA),
        $adminsContainerData = $(ELEMENTS.CONTAINER_ADMINS_DATA),
        $studentFullInfoContainerData = $(ELEMENTS.CONTAINER_STUDENT_FULL_INFO_DATA)
    ;

    var $containers = [
        $studentsContainerData,
        $headFromCompanyContainerData,
        $headFromUniversityContainerData,
        $adminsContainerData,
        $studentFullInfoContainerData
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
                $('#studentsTable').bootstrapTable({
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
                $('#headsFromCompanyTable').bootstrapTable({
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
                $('#headsFromUniversityTable').bootstrapTable({
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
                $('#adminsTable').bootstrapTable({
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



    /*function calcOffset() {
        var serverTime = document.cookie['serverTime'];
        // var serverTime = getCookie('serverTime');
        serverTime = serverTime===null ? null : Math.abs(serverTime);
        var clientTimeOffset = (new Date()).getTime() - serverTime;
        document.cookie = 'clientTimeOffset' + '=' + clientTimeOffset;
    }

    function checkSession() {
        var sessionExpiry = Math.abs(getCookie('sessionExpiry'));
        var timeOffset = Math.abs(getCookie('clientTimeOffset'));
        var localTime = (new Date()).getTime();
        if (localTime - timeOffset > (sessionExpiry+15000)) { // 15 extra seconds to make sure
            alert("Session is timed out!");
        } else {
            setTimeout('checkSession()', 10000);
        }
    }

    window.onLoad = function() { calcOffset(); };*/

});