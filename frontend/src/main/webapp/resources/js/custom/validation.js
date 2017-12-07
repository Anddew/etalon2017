+function () {

    var Validation = {

        validateOnEmpty: function (inputs, btns) {
            var isAnyValidationErrors = false;
            if (inputs) {
                inputs.some(function (input) {
                    if (!input.val().trim()) {
                        isAnyValidationErrors = true;

                        input.next().html('Field is required.');
                        input.next().show();
                    } else {
                        input.next().hide();
                    }
                });
            }
            if (btns) {
                if (isAnyValidationErrors) {
                    btns.some(function (button) {
                        button.attr("disabled", true)
                    })
                } else {
                    btns.some(function (button) {
                        button.removeAttr('disabled')
                    })
                }
            }
        },

        formValidation: function (inputs) {
            var isNoErrors = true;
            if (inputs) {
                inputs.some(function (input) {
                    if (!input.val().trim()) {
                        isNoErrors = false;
                        input.next().html('Field is required.');
                        input.next().show();
                    } else {
                        input.next().hide();
                    }
                });
            }
            return isNoErrors;
        },

        checkPasswordRepeating: function (password, repeat) {
            return (password.val() === repeat.val());
        }

    };

    window.Validation = Validation;

}();
