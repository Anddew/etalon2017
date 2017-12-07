$(document).ready(function () {

    var ELEMENTS = {
        BTN_SUBMIT_REGISTER: '.jsSubmitRegister',
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
        NOTIFICATION_SERVER_ERROR: '.jsServerErrorNotification'
    };

    var
        $submitButton = $(ELEMENTS.BTN_SUBMIT_REGISTER),
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
        $serverErrorNotification = $(ELEMENTS.NOTIFICATION_SERVER_ERROR)
    ;

    $submitButton.click(function (event) {
        event.stopPropagation();

        if(formValidation() && checkPasswordRepeating()) {
            $.ajax({
                url: 'register',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    role: $('input[name=role]:checked').val(),
                    username: $usernameField.val(),
                    email: $emailField.val(),
                    password: $passwordField.val(),
                    passwordRepeat: $passwordRepeatField.val(),
                    firstname: $firstNameField.val(),
                    lastname: $lastNameField.val()
                })
                ,
                success: function () {
                    window.location.href = "/login"
                },
                error: function (xhr, textStatus) {
                    $formErrorNotification.hide();
                    xhr.status == 500 ? $serverErrorNotification.show() : alert('Something went wrong, try again later.');
                }


            });
        } else {
            $serverErrorNotification.hide();
            $formErrorNotification.show();
        }

    });

    function formValidation() {
        var role = $('input[name=role]:checked').val();
        var $field;
        switch (role) {
            case 'student':
                $field = $studentField;
                break;
            case 'head_from_company':
                $field = $headFromCompanyField;
                break;
            case 'head_from_university':
                $field = $headFromUniversityField;
                break;
        }
        return Validation.formValidation([
            $field,
            $usernameField,
            $emailField,
            $passwordField,
            $passwordRepeatField,
            $firstNameField,
            $lastNameField
        ]);
    }

    function checkPasswordRepeating() {
        return Validation.checkPasswordRepeating($passwordField, $passwordRepeatField);
    }



});