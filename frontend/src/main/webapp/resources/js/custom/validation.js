+function () {

    var $alphanumericPattern = /^[\w]{3,15}$/,
        $emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
        $textPattern = /^[\w]{2,15}$/,
        $groupNumberPattern = /^[\d]{1,10}$/,
        $excludeDigitsAndUnderscorePattern = /\d|_/
    ;

    var Validation = {

        switchButtons: function (btns, condition) {
            if (btns) {
                if (condition) {
                    btns.some(function (button) {
                        button.removeAttr('disabled')
                    })
                } else {
                    btns.some(function (button) {
                        button.attr("disabled", true)
                    })
                }
            }
        },

        validateOnEmpty: function (inputs) {
            for(var i = 0; i < inputs.length; i++) {
                if(!inputs[i].val().trim()) {
                    return false;
                }
            }
            return true;
        },

        validateAlphanumericField: function (value) {
            if(value.val() === "") {
                return true;
            }
            return $alphanumericPattern.test(value.val());
        },

        validateEmail: function (email) {
            if(email.val() === "") {
                return true;
            }
            return $emailPattern.test(email.val().toLowerCase());
        },

        validatePasswordRepeating: function (password, repeat) {
            if(password.val() === "" || repeat.val() === "") {
                return true;
            }
            return (password.val() === repeat.val());
        },

        validateTextField: function (value) {
            var text = value.val();
            if(text === "") {
                return true;
            }
            return $textPattern.test(text) && !$excludeDigitsAndUnderscorePattern.test(text);
        },

        validateGroupNumber: function (value) {
            if(value.val() === "") {
                return true;
            }
            return $groupNumberPattern.test(value.val());
        },

        hideNotifications: function (notifications) {
        if(notifications) {
            for(var i = 0; i < notifications.length; i++) {
                notifications[i].hide();
            }
        }
    }

    };

    window.Validation = Validation;

}();
