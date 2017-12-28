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
        INPUT_HEAD_FROM_UNIVERSITY: '.jsHeadFromUniversity',
        INPUT_STUDENT: '.jsStudent',

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
        NOTIFICATION_HEAD_FROM_UNIVERSITY_FIELD_ERROR: '.jsHeadFromUniversityNotification'
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
        $headFromUniversityField = $(ELEMENTS.INPUT_HEAD_FROM_UNIVERSITY),
        $studentField = $(ELEMENTS.INPUT_STUDENT),

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

    var $basicNesessaryFields = [
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
    });

    $usernameField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateAlphanumericField($usernameField) ?
            ($usernameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($usernameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $emailField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateEmail($emailField) ?
            ($emailErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($emailErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $passwordField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateAlphanumericField($passwordField) ?
            ($passwordErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($passwordErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $passwordRepeatField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validatePasswordRepeating($passwordField, $passwordRepeatField) ?
            ($passwordRepeatErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($passwordRepeatErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $firstNameField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($firstNameField) ?
            ($firstnameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($firstnameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $lastNameField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($lastNameField) ?
            ($lastnameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($lastnameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $studentField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateGroupNumber($studentField) ?
            ($studentErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($studentErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $headFromCompanyField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($headFromCompanyField) ?
            ($headFromCompanyErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($headFromCompanyErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $headFromUniversityField.on('blur', function () {
        Validation.hideNotifications([$radioButtonErrorNotification, $serverErrorNotification, $formErrorNotification]);
        !Validation.validateTextField($headFromUniversityField) ?
            ($headFromUniversityErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($headFromUniversityErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $submitButton.click(function (event) {
        event.stopPropagation();

        if(!$radioButton.is(':checked')) {
            $radioButtonErrorNotification.show();
            return;
        }

        var inputs = $basicNesessaryFields.concat(selectExtraFields());

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
                faculty: $headFromUniversityField.val(),
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
                $extraFields = [$studentField];
                break;
            case 'head_from_company':
                $extraFields = [$headFromCompanyField];
                break;
            case 'head_from_university':
                $extraFields = [$headFromUniversityField];
                break;
        }
        return $extraFields;
    }

});