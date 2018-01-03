$(document).ready(function () {

    var ELEMENTS = {
        BTN_SUBMIT_CREATE_PRACTICE: '.jsSubmitCreatePracticeButton',

        INPUT_STUDENT_COUNT: '.jsStudentRequiredCount',
        INPUT_MIN_AVG_SCORE: '.jsMinAvgScore',
        INPUT_EDUCATION_FORM: '.jsEducationForm',
        INPUT_HIRING_TYPE: '.jsHiringType',
        INPUT_DATE_START: '.jsDateStart',
        INPUT_DATE_END: '.jsDateEnd',
        INPUT_UNIVERSITY: '.jsUniversity',
        INPUT_FACULTY: '.jsFaculty',
        INPUT_SPECIALITY: '.jsSpeciality',

        NOTIFICATION_SUBMIT_PRACTICE_ERROR: '.jsSubmitPracticeNotification',
        NOTIFICATION_STUDENT_REQUIRED_COUNT_ERROR: '.jsStudentRequiredCountNotification',
        NOTIFICATION_AVG_SCORE_ERROR: '.jsMinAvgScoreNotification',
        NOTIFICATION_EDUCATION_FORM_ERROR: '.jsEducationFormNotification',
        NOTIFICATION_HIRE_CONDITION_ERROR: '.jsHireConditionNotification',
        NOTIFICATION_DATE_ERROR: '.jsDateNotification',
        NOTIFICATION_SELECT_UNIVERSITY_ERROR: '.jsSelectUniversityNotification',
        NOTIFICATION_SELECT_FACULTY_ERROR: '.jsSelectFacultyNotification',
        NOTIFICATION_SELECT_SPECIALITY_ERROR: '.jsSelectSpecialityNotification'
    };

    var
        $submitCreatePracticeButton = $(ELEMENTS.BTN_SUBMIT_CREATE_PRACTICE),

        $studentCountField = $(ELEMENTS.INPUT_STUDENT_COUNT),
        $minAvgScoreField = $(ELEMENTS.INPUT_MIN_AVG_SCORE),
        $educationFormField = $(ELEMENTS.INPUT_EDUCATION_FORM),
        $hiringTypeField = $(ELEMENTS.INPUT_HIRING_TYPE),
        $dateStartField = $(ELEMENTS.INPUT_DATE_START),
        $dateEndField = $(ELEMENTS.INPUT_DATE_END),
        $universityField = $(ELEMENTS.INPUT_UNIVERSITY),
        $facultyField = $(ELEMENTS.INPUT_FACULTY),
        $specialityField = $(ELEMENTS.INPUT_SPECIALITY),

        $createPracticeErrorNotification = $(ELEMENTS.NOTIFICATION_SUBMIT_PRACTICE_ERROR),
        $studentsCountErrorNotification = $(ELEMENTS.NOTIFICATION_STUDENT_REQUIRED_COUNT_ERROR),
        $avgScoreErrorNotification = $(ELEMENTS.NOTIFICATION_AVG_SCORE_ERROR),
        $educationFormErrorNotification = $(ELEMENTS.NOTIFICATION_EDUCATION_FORM_ERROR),
        $hireConditionErrorNotification = $(ELEMENTS.NOTIFICATION_HIRE_CONDITION_ERROR),
        $dateErrorNotification = $(ELEMENTS.NOTIFICATION_DATE_ERROR),
        $selectUniveristyErrorNotification = $(ELEMENTS.NOTIFICATION_SELECT_UNIVERSITY_ERROR),
        $selectFacultyErrorNotification = $(ELEMENTS.NOTIFICATION_SELECT_FACULTY_ERROR),
        $selectSpecialityErrorNotification = $(ELEMENTS.NOTIFICATION_SELECT_SPECIALITY_ERROR)
    ;

    var notifications = [
        $createPracticeErrorNotification,
        $studentsCountErrorNotification,
        $avgScoreErrorNotification,
        $educationFormErrorNotification,
        $hireConditionErrorNotification,
        $dateErrorNotification
    ];

    var $universityFields = [
        $universityField,
        $facultyField,
        $specialityField
    ];

    getUniversities();
    Validation.showElements($universityFields);

    function getUniversities() {
        $.ajax({
            url: '/universities',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            data: '',
            success: function (universities) {
                for(var i = 0; i < Object.keys(universities).length; i++){
                    $universityField.append($("<option></option>").attr("value", universities[i].id).text(universities[i].name));
                }
            }
        });
    }

    $universityField.on('change', function () {
        getFacultiesByUniversityId();
    });

    function getFacultiesByUniversityId() {
        var universityId = $universityField.val();

        $.ajax({
            url: 'universities/' + universityId + '/faculties',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            success: function (faculties) {
                for(var i = 0; i < Object.keys(faculties).length; i++){
                    $facultyField.append($("<option></option>").attr("value", faculties[i].id).text(faculties[i].name));
                }
            }
        });
    }

    $studentCountField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        !Validation.validateStudentsCount($studentCountField) ?
            ($studentsCountErrorNotification.show(), Validation.switchButtons([$submitCreatePracticeButton], false)) :
            ($studentsCountErrorNotification.hide(), Validation.switchButtons([$submitCreatePracticeButton], true));
    });

    $universityField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        Validation.switchButtons([$submitCreatePracticeButton], true)
    });

    $facultyField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        Validation.switchButtons([$submitCreatePracticeButton], true)
    });

    $minAvgScoreField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        !Validation.validateAvgScore($minAvgScoreField.val()) ?
            ($avgScoreErrorNotification.show(), Validation.switchButtons([$submitCreatePracticeButton], false)) :
            ($avgScoreErrorNotification.hide(), Validation.switchButtons([$submitCreatePracticeButton], true));
    });

    $educationFormField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        Validation.switchButtons([$submitCreatePracticeButton], true)
    });

    $hiringTypeField.on('blur', function () {
        Validation.hideElements([$createPracticeErrorNotification]);
        Validation.switchButtons([$submitCreatePracticeButton], true)
    });

    $dateStartField.on('blur', function () {
        compareDates();
    });

    $dateEndField.on('blur', function () {
        compareDates();
    });

    function compareDates() {
        Validation.hideElements([$createPracticeErrorNotification]);
        !Validation.validateDates($dateStartField, $dateEndField) ?
            ($dateErrorNotification.show(), Validation.switchButtons([$submitCreatePracticeButton], false)) :
            ($dateErrorNotification.hide(), Validation.switchButtons([$submitCreatePracticeButton], true));
    }

    $submitCreatePracticeButton.click(function (event) {
        event.stopPropagation();

        Validation.hideElements(notifications);

        if(!Validation.validateOnEmpty(
                [$studentCountField,
                    $universityField,
                    $facultyField,
                    $minAvgScoreField,
                    $educationFormField,
                    $hiringTypeField,
                    $dateStartField,
                    $dateEndField
                ]
            )) {
            $createPracticeErrorNotification.show();
            return;
        }

        $.ajax({
            url: '/practices/add',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                studentRequiredCount: $studentCountField.val(),
                facultyId: $facultyField.val(),
                minAvgScore: $minAvgScoreField.val(),
                educationForm: $educationFormField.val(),
                hireCondition: $hiringTypeField.val(),
                dateStart: $dateStartField.val(),
                dateEnd: $dateEndField.val()
            })
            ,
            success: function () {
                alert("Practice has been successfully created.");
                window.location.href = "/home"
            },
            error: function (xhr, textStatus) {
                alert("Practice has been not created. Something going wrong.")
            }
        });

    });

});