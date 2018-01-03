$(document).ready(function () {

    var ELEMENTS = {
        BTN_SUBMIT_REGISTER: '.jsSubmitRegister',

        RADIO_BUTTON: '.jsRadioButton',

        INPUT_USERNAME: '.jsUsername',
        INPUT_EMAIL: '.jsEmail',
        INPUT_PASSWORD: '.jsPassword',
        INPUT_PASSWORD_REPEAT: '.jsPasswordRepeat',
        INPUT_FIRST_NAME: '.jsFirstName',
        INPUT_LAST_NAME: '.jsLastName',
        INPUT_HEAD_FROM_COMPANY: '.jsHeadFromCompany',
        INPUT_STUDENT: '.jsStudent',
        INPUT_UNIVERSITY: '.jsUniversity',
        INPUT_FACULTY: '.jsFaculty',
        INPUT_SPECIALITY: '.jsSpeciality',

        NOTIFICATION_FORM_ERROR: '.jsErrorFormNotification',
        NOTIFICATION_DUPLICATION_ERROR: '.jsDuplicationErrorNotification',
        NOTIFICATION_SERVER_ERROR: '.jsServerErrorNotification',
        NOTIFICATION_RADIO_BUTTON_ERROR: '.jsRadioButtonSelectNotification',
        NOTIFICATION_USERNAME_ERROR: '.jsUsernameNotification',
        NOTIFICATION_EMAIL_ERROR: '.jsEmailNotification',
        NOTIFICATION_PASSWORD_ERROR: '.jsPasswordNotification',
        NOTIFICATION_PASSWORD_REPEAT_ERROR: '.jsPasswordRepeatNotification',
        NOTIFICATION_FIRST_NAME_ERROR: '.jsFirstNameNotification',
        NOTIFICATION_LAST_NAME_ERROR: '.jsLastNameNotification',
        NOTIFICATION_STUDENT_FIELD_ERROR: '.jsStudentNotification',
        NOTIFICATION_HEAD_FROM_COMPANY_FIELD_ERROR: '.jsHeadFromCompanyNotification',
        NOTIFICATION_HEAD_FROM_UNIVERSITY_FIELD_ERROR: '.jsHeadFromUniversityNotification',
        NOTIFICATION_SELECT_UNIVERSITY_ERROR: '.jsSelectUniversityNotification',
        NOTIFICATION_SELECT_FACULTY_ERROR: '.jsSelectFacultyNotification',
        NOTIFICATION_SELECT_SPECIALITY_ERROR: '.jsSelectSpecialityNotification'
    };

    var
        $submitButton = $(ELEMENTS.BTN_SUBMIT_REGISTER),

        $radioButton = $(ELEMENTS.RADIO_BUTTON),

        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $emailField = $(ELEMENTS.INPUT_EMAIL),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $passwordRepeatField = $(ELEMENTS.INPUT_PASSWORD_REPEAT),
        $firstNameField = $(ELEMENTS.INPUT_FIRST_NAME),
        $lastNameField = $(ELEMENTS.INPUT_LAST_NAME),
        $headFromCompanyField = $(ELEMENTS.INPUT_HEAD_FROM_COMPANY),
        $studentField = $(ELEMENTS.INPUT_STUDENT),
        $universityField = $(ELEMENTS.INPUT_UNIVERSITY),
        $facultyField = $(ELEMENTS.INPUT_FACULTY),
        $specialityField = $(ELEMENTS.INPUT_SPECIALITY),

        $formErrorNotification = $(ELEMENTS.NOTIFICATION_FORM_ERROR),
        $duplicationErrorNotification = $(ELEMENTS.NOTIFICATION_DUPLICATION_ERROR),
        $serverErrorNotification = $(ELEMENTS.NOTIFICATION_SERVER_ERROR),
        $radioButtonErrorNotification = $(ELEMENTS.NOTIFICATION_RADIO_BUTTON_ERROR),
        $usernameErrorNotification = $(ELEMENTS.NOTIFICATION_USERNAME_ERROR),
        $emailErrorNotification = $(ELEMENTS.NOTIFICATION_EMAIL_ERROR),
        $passwordErrorNotification = $(ELEMENTS.NOTIFICATION_PASSWORD_ERROR),
        $passwordRepeatErrorNotification = $(ELEMENTS.NOTIFICATION_PASSWORD_REPEAT_ERROR),
        $firstnameErrorNotification = $(ELEMENTS.NOTIFICATION_FIRST_NAME_ERROR),
        $lastnameErrorNotification = $(ELEMENTS.NOTIFICATION_LAST_NAME_ERROR),
        $studentErrorNotification = $(ELEMENTS.NOTIFICATION_STUDENT_FIELD_ERROR),
        $headFromCompanyErrorNotification = $(ELEMENTS.NOTIFICATION_HEAD_FROM_COMPANY_FIELD_ERROR),
        $headFromUniversityErrorNotification = $(ELEMENTS.NOTIFICATION_HEAD_FROM_UNIVERSITY_FIELD_ERROR)
    ;

    var $basicNecessaryFields = [
        $radioButton,
        $usernameField,
        $passwordField,
        $passwordRepeatField,
        $emailField,
        $firstNameField,
        $lastNameField
    ];

    $radioButton.on('click', function () {
        $radioButtonErrorNotification.hide();
        Validation.switchButtons([$submitButton], true);
        var isRoleSelected = $radioButton.is(':checked');
        var role;
        if(isRoleSelected) {
            role = $(".jsRadioButton:checked").val()
        } else {
            return null;
        }
        switch (role) {
            case 'student':
                getUniversities();
                Validation.showElements([$universityField, $facultyField, $specialityField]);
                break;
            case 'head_from_company':
                Validation.hideElements([$universityField, $facultyField, $specialityField]);
                break;
            case 'head_from_university':
                Validation.hideElements([$universityField, $facultyField, $specialityField]);
                getUniversities();
                Validation.showElements([$universityField, $facultyField]);
                break;
        }
    });

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

    $facultyField.on('change', function () {
        getSpecialitiesByFacultyId();
    });

    function getSpecialitiesByFacultyId() {
        var facultyId = $facultyField.val();

        $.ajax({
            url: 'universities/faculties/' + facultyId + '/specialities',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            success: function (specialities) {
                for(var i = 0; i < Object.keys(specialities).length; i++){
                    $specialityField.append($("<option></option>").attr("value", specialities[i].id).text(specialities[i].name));
                }
            }
        });
    }

    $usernameField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateAlphanumericField($usernameField) ?
            ($usernameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($usernameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $emailField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateEmail($emailField) ?
            ($emailErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($emailErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $passwordField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateAlphanumericField($passwordField) ?
            ($passwordErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($passwordErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $passwordRepeatField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validatePasswordRepeating($passwordField, $passwordRepeatField) ?
            ($passwordRepeatErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($passwordRepeatErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $firstNameField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($firstNameField) ?
            ($firstnameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($firstnameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $lastNameField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($lastNameField) ?
            ($lastnameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($lastnameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $studentField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateGroupNumber($studentField) ?
            ($studentErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($studentErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $universityField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        Validation.switchButtons([$submitButton], true)
    });

    $facultyField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        Validation.switchButtons([$submitButton], true)
    });

    $specialityField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        Validation.switchButtons([$submitButton], true)
    });

    $headFromCompanyField.on('blur', function () {
        Validation.hideElements([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($headFromCompanyField) ?
            ($headFromCompanyErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($headFromCompanyErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $submitButton.click(function (event) {
        event.stopPropagation();

        if(!$radioButton.is(':checked')) {
            $radioButtonErrorNotification.show();
            return;
        }

        var inputs = $basicNecessaryFields.concat(selectExtraFields());

        if(!Validation.validateOnEmpty(inputs)) {
            $formErrorNotification.show();
            Validation.switchButtons([$submitButton], false);
            return;
        }

        $.ajax({
            url: 'register',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                role: $(".jsRadioButton:checked").val(),
                username: $usernameField.val(),
                email: $emailField.val(),
                password: $passwordField.val(),
                passwordRepeat: $passwordRepeatField.val(),
                firstname: $firstNameField.val(),
                lastname: $lastNameField.val(),
                group: $studentField.val(),
                facultyId: $facultyField.val(),
                specialityId: $specialityField.val(),
                company: $headFromCompanyField.val()
            })
            ,
            success: function () {
                window.location.href = "/home"
            },
            error: function (xhr) {
                xhr.status == 400 ? $duplicationErrorNotification.show() : $serverErrorNotification.show();
            }
        });

    });
    
    function selectExtraFields() {
        var isRoleSelected = $radioButton.is(':checked');
        var role;
        if(isRoleSelected) {
            role = $(".jsRadioButton:checked").val()
        } else {
            return null;
        }
        var $extraFields = null;
        switch (role) {
            case 'student':
                $extraFields = [$studentField, $universityField, $facultyField, $specialityField];
                break;
            case 'head_from_company':
                $extraFields = [$headFromCompanyField];
                break;
            case 'head_from_university':
                $extraFields = [$universityField, $facultyField];
                break;
        }
        return $extraFields;
    }

});