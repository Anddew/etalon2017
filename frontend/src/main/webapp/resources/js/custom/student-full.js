$(document).ready(function () {

    var ELEMENTS = {
        BTN_SHOW_STUDENT_INFO_FORM: '.jsShowStudentInfoFormButton',
        BTN_SUBMIT_STUDENT_INFO_FORM: '.jsStudentInfoFormSubmitButton',
        INPUT_AVG_SCORE: '.jsAvgScore',
        INPUT_EDUCATION_FORM: '.jsEducationForm',
        INPUT_HIRING: '.jsHiringForm',

        NOTIFICATION_AVG_SCORE_ERROR: '.jsAvgScoreNotification',
        NOTIFICATION_EDUCATION_FORM_ERROR: '.jsEducationFormNotification',
        NOTIFICATION_HIRE_CONDITION_ERROR: '.jsHireConditionNotification',

        CONTAINER_STUDENT_FULL_INFO_FORM_DATA: '.jsStudentInfoFormContainer',
        CONTAINER_STUDENT_FULL_INFO_BUTTON_DATA: '.jsStudentInfoFormButtonContainer'
    };

    var
        $showStudentInfoFormButton = $(ELEMENTS.BTN_SHOW_STUDENT_INFO_FORM),
        $submitStudentInfoFormButton = $(ELEMENTS.BTN_SUBMIT_STUDENT_INFO_FORM),
        $avgScoreField = $(ELEMENTS.INPUT_AVG_SCORE),
        $educationFormField = $(ELEMENTS.INPUT_EDUCATION_FORM),
        $hiringFormField = $(ELEMENTS.INPUT_HIRING),

        $avgScoreErrorNotification = $(ELEMENTS.NOTIFICATION_AVG_SCORE_ERROR),
        $educationFormErrorNotification = $(ELEMENTS.NOTIFICATION_EDUCATION_FORM_ERROR),
        $hireConditionErrorNotification = $(ELEMENTS.NOTIFICATION_HIRE_CONDITION_ERROR),

        $studentFullInfoFormContainer = $(ELEMENTS.CONTAINER_STUDENT_FULL_INFO_FORM_DATA),
        $studentFullInfoButtonContainer = $(ELEMENTS.CONTAINER_STUDENT_FULL_INFO_BUTTON_DATA)
    ;

    $showStudentInfoFormButton.click(function (event) {
        event.stopPropagation();

        $studentFullInfoFormContainer.show();
        $studentFullInfoButtonContainer.hide();
    });


    $submitStudentInfoFormButton.click(function (event) {
        event.stopPropagation();

        var id = $('#id').text();
        var avgScore = $avgScoreField.val();
        var educationForm = $educationFormField.val();
        var hiring = $hiringFormField.val();

        Validation.hideNotifications([
            $avgScoreErrorNotification,
            $educationFormErrorNotification,
            $hireConditionErrorNotification
        ]);

        if(!Validation.validateAvgScore(avgScore)) {
            $avgScoreErrorNotification.show();
            return;
        }
        if(!Validation.validateIsSelectChosen(educationForm)) {
            $educationFormErrorNotification.show();
            return;
        }
        if(!Validation.validateIsSelectChosen(hiring)) {
            $hireConditionErrorNotification.show();
            return;
        }

        $.ajax({
            url: id +'/setInfo',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                avgScore: avgScore,
                educationForm: educationForm,
                hireCondition: hiring
            })
            ,
            success: function (studentInfo) {
                $('#avgScore').html(studentInfo.avgScore);
                $('#educationForm').html(studentInfo.educationForm);
                $('#hireCondition').html(studentInfo.hireCondition);
            },
            error: function () {
                alert("Error! Data have not set!")
            }
        });

        $studentFullInfoFormContainer.hide();
        $studentFullInfoButtonContainer.show();
    });

});