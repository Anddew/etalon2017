$(document).ready(function () {

    var ELEMENTS = {
        BTN_SUBMIT_REGISTER: '.jsSubmitLogin',
        INPUT_USERNAME: '.jsUsername',
        INPUT_PASSWORD: '.jsPassword',
        NOTIFICATION_SERVER_ERROR: '.jsCredentialsIncorrectNotification',
        NOTIFICATION_INCORRECT_INPUT: '.jsInputIncorrectNotification',
        BTN_SUBMIT_PRINT: '.jsPrintOnClick',
        CONTAINER_DATA_USING_AJAX_PRINT: 'jsPrint'
        };

    var
        $submitButton = $(ELEMENTS.BTN_SUBMIT_REGISTER),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $credentialNotification = $(ELEMENTS.NOTIFICATION_SERVER_ERROR),
        $incorrectInputNotification = $(ELEMENTS.NOTIFICATION_INCORRECT_INPUT),
        usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $submitPrint = $(ELEMENTS.BTN_SUBMIT_PRINT),
        printContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX_PRINT)
        ;

    // $submitPrint.click(function (event) {
    //     event.stopPropagation();
    //
    //     $.ajax({
    //         url: 'students',
    //         type: 'GET',
    //         dataType: 'json',
    //         contentType: "application/json",
    //         mimeType: 'application/json',
    //         data: '',
    //         success: function (data) {
    //             if (data) {
    //                 printUsers(data);
    //             }
    //         }
    //     });
    //
    //     function printUsers(students) {
    //         students.some(function (student) {
    //             printContainer.append('<span>' + student.studentId + ' | ' + student.username + ' | ' + student.email + '</span><br>')
    //         });
    //     }
    //
    // });


    $submitButton.click(function (event) {
        event.stopPropagation();

        if(formValidation()) {
            $.ajax({
                url: 'login',
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify({
                    username: $usernameField.val(),
                    password: $passwordField.val()
                })
                ,
                success: function () {
                    $credentialNotification.hide();
                    $incorrectInputNotification.hide();
                    window.location.href = "/home"
                },
                error: function (xhr, textStatus) {
                    $incorrectInputNotification.hide();
                    xhr.status == 401 ? $credentialNotification.show() : alert('Something went wrong, try again later.');
                }
            });
        } else {
            $credentialNotification.hide();
            $incorrectInputNotification.show();
        }

    });

    function formValidation() {
        return Validation.formValidation([
            $usernameField,
            $passwordField
        ]);
    }


});