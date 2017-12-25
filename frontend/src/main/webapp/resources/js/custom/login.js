$(document).ready(function () {

    var ELEMENTS = {
        BTN_SUBMIT_REGISTER: '.jsSubmitLogin',
        INPUT_USERNAME: '.jsUsername',
        INPUT_PASSWORD: '.jsPassword',
        INPUT_REMEMBER_ME: '.jsRememberMe',

        NOTIFICATION_USERNAME_ERROR: '.jsUsernameNotification',
        NOTIFICATION_PASSWORD_ERROR: '.jsPasswordNotification',
        NOTIFICATION_SERVER_ERROR: '.jsCredentialsIncorrectNotification',
        NOTIFICATION_INCORRECT_INPUT: '.jsInputIncorrectNotification'
        };

    var
        $submitButton = $(ELEMENTS.BTN_SUBMIT_REGISTER),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $rememberMeField = $(ELEMENTS.INPUT_REMEMBER_ME),

        $usernameErrorNotification = $(ELEMENTS.NOTIFICATION_USERNAME_ERROR),
        $passwordErrorNotification = $(ELEMENTS.NOTIFICATION_PASSWORD_ERROR),
        $credentialNotification = $(ELEMENTS.NOTIFICATION_SERVER_ERROR),
        $incorrectInputNotification = $(ELEMENTS.NOTIFICATION_INCORRECT_INPUT)
        ;

    $usernameField.on('blur', function () {
        Validation.hideNotifications([$incorrectInputNotification, $credentialNotification]);
        !Validation.validateAlphanumericField($usernameField) ?
            ($usernameErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($usernameErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $passwordField.on('blur', function () {
        Validation.hideNotifications([$incorrectInputNotification, $credentialNotification]);
        !Validation.validateAlphanumericField($passwordField) ?
            ($passwordErrorNotification.show(), Validation.switchButtons([$submitButton], false)) :
            ($passwordErrorNotification.hide(), Validation.switchButtons([$submitButton], true));
    });

    $submitButton.click(function (event) {
        event.stopPropagation();

        if(!Validation.validateOnEmpty([$usernameField, $passwordField])) {
            $incorrectInputNotification.show();
            Validation.switchButtons([$submitButton], false);
            return;
        }

        $.ajax({
            url: 'authorization',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                username: $usernameField.val(),
                password: $passwordField.val(),
                rememberme: $rememberMeField.is(':checked')
            })
            ,
            success: function () {
                window.location.href = "/home"
            },
            error: function (xhr, textStatus) {
                xhr.status == 401 ? $credentialNotification.show() : alert('Something went wrong, try again later.');
            }
        });

    });



});